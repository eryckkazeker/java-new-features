package br.com.alura;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

import br.com.alura.model.NotaFiscal;
import br.com.alura.wsclient.NotaFiscalWSClient;

public class TesteEnvioNaoBloqueante {

	public static void main(String[] args) {
        var startTime = Instant.now();
        var threadPool = Executors.newFixedThreadPool(3);
        List<NotaFiscal> notasFiscais = List.of(new NotaFiscal("Joao", 39.99, LocalDate.now()),
				new NotaFiscal("Renata", 41.20, LocalDate.now()), new NotaFiscal("Paulo", 32.10, LocalDate.now()),
				new NotaFiscal("Feranda", 15.00, LocalDate.now()));
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>(threadPool, 1);
		NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
		publisher.consume(nfwsc::enviar);
        notasFiscais.forEach(nf -> {
            publisher.submit(nf);
            System.out.println(nf.getNome()+" Voce ira receber a nota fiscal no seu e-mail");
        });
        var endTime = Instant.now().toEpochMilli() - startTime.toEpochMilli();
        System.out.println("Completed in "+endTime+"ms");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}
}

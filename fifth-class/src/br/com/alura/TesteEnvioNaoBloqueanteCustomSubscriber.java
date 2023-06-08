package br.com.alura;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

import br.com.alura.model.NotaFiscal;
import br.com.alura.processor.NotaFiscalProcessor;
import br.com.alura.subscriber.NotaFiscalSubscriber;

public class TesteEnvioNaoBloqueanteCustomSubscriber {

	public static void main(String[] args) {
        var startTime = Instant.now();
        List<NotaFiscal> notasFiscais = List.of(new NotaFiscal("Joao", 39.99, LocalDate.now()),
                new NotaFiscal("Helcio", 99.99, LocalDate.now()),
				new NotaFiscal("Renata", 41.20, LocalDate.now()), new NotaFiscal("Paulo", 32.10, LocalDate.now()),
				new NotaFiscal("Feranda", 15.00, LocalDate.now()));
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();
		
        NotaFiscalSubscriber subscriber = new NotaFiscalSubscriber();
        NotaFiscalProcessor processor = new NotaFiscalProcessor();

        publisher.subscribe(processor);
        processor.subscribe(subscriber);

        // publisher.subscribe(subscriber);

        notasFiscais.forEach(nf -> {
            publisher.submit(nf);
            System.out.println(nf.getNome()+" Voce ira receber a nota fiscal no seu e-mail");
        });

        publisher.close();
        var endTime = Instant.now().toEpochMilli() - startTime.toEpochMilli();
        System.out.println("Completed in "+endTime+"ms");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
	}
    
}

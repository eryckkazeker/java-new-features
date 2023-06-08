package br.com.alura.processor;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;

import br.com.alura.model.NotaFiscal;

public class NotaFiscalProcessor extends SubmissionPublisher<NotaFiscal> implements Processor<NotaFiscal, NotaFiscal> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("NotaFiscalProcessor - onSubscribe()");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(NotaFiscal item) {
        System.out.println("NotaFiscalProcessor - onNext()");
        System.out.println("NotaFiscalProcessor - valor: "+item.getValor());

        
        if (item.getValor() > 50.0) {
            System.err.println("Valor da nota é muito alto");
        }

        submit(item);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onError'");
    }

    @Override
    public void onComplete() {
        System.out.println("Processor complete");
    }

    
}

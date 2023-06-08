package br.com.alura.subscriber;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import br.com.alura.model.NotaFiscal;
import br.com.alura.wsclient.NotaFiscalWSClient;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("NotaFiscalSubscriber - onSubscribe()");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(NotaFiscal item) {
        System.out.println("NotaFiscalSubscriber - onNext()");

        NotaFiscalWSClient client = new NotaFiscalWSClient();
        client.enviar(item);

        // In order to continue processing requests, we need to request another item from the subscription
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();    
    }

    @Override
    public void onComplete() {
        System.out.println("NotaFiscalSubscriber - onComplete()");

    }
    
}

package br.ufsc.ine.agent.context.communication;


import rx.subjects.PublishSubject;

public abstract class Sensor implements Runnable{
    protected PublishSubject<String>  publisher;
    protected Sensor(){
        publisher  = PublishSubject.create();
    }
    public PublishSubject<String> getPublisher() {
        return publisher;
    }
}

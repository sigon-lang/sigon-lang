package br.ufsc.ine.sensor;


import rx.subjects.PublishSubject;

public abstract class Sensor implements Runnable{

    protected PublishSubject<String>  publisher;

    public Sensor(){
        publisher  = PublishSubject.create();
    }

    public PublishSubject<String> getPublisher() {
        return publisher;
    }
}

package br.ufsc.ine.environment;

import br.ufsc.ine.sensor.Sensor;
import com.github.davidmoten.rx.FileObservable;
import rx.Observable;

public class TestSensor2 extends Sensor{

    private  Observable<String> fileObservable;


    @Override
    public void run() {
        this.fileObservable = FileObservable
                .tailer().file("/home/valdirluiz/teste1").tailText();
        this.fileObservable.subscribe(super.publisher);
    }
}

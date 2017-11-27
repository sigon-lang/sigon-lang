package br.ufsc.ine.environment;

import br.ufsc.ine.sensor.Sensor;
import com.github.davidmoten.rx.FileObservable;
import rx.Observable;

public class TestSensor extends Sensor{

    private  Observable<String> fileObservable;

    public TestSensor(){
        super();
        this.fileObservable = FileObservable
                .tailer().file("/home/valdirluiz/teste").tailText();

    }

    @Override
    public void run() {
        this.fileObservable.subscribe(super.publisher);
    }
}

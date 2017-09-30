package br.ufsc.ine.environment;

import com.github.davidmoten.rx.FileObservable;

import rx.Observable;

public class FileEnvironment extends Environment {

	@Override
	public void init() {
		Observable<String> fileObservable = FileObservable
				.tailer().file("/home/valdirluiz/teste").tailText();
		super.addSensor(fileObservable);

	}

 

}

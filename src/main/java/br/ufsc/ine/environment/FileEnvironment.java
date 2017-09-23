package br.ufsc.ine.environment;

import com.github.davidmoten.rx.FileObservable;

import rx.Observable;

public class FileEnvironment extends Environment {

	@Override
	public Observable<String> observe() {

		Observable<String> items = FileObservable
										.tailer()
										.file("/home/valdirluiz/teste")
										.tailText();
		return items;
	}

}

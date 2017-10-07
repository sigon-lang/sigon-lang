package br.ufsc.ine.environment;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import br.ufsc.ine.context.plans.Action;
import rx.Observable;

public abstract class Environment {

	private List<Observable<String>> sensors = new ArrayList<>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void execute(Action function) {

		try {
			Class clazz = Class.forName(Environment.class.getName());
			Method method = clazz.getMethod(function.getName(), String.class);
			method.invoke(this, function.getArguments().toArray());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void print(String arg) {
		System.out.println(arg);
	}

	public void addSensor(Observable<String> observable) {
		this.sensors.add(observable);
	}
	
	public List<Observable<String>> getSensors() {
		return sensors;
	}
	
	public abstract void init();

}

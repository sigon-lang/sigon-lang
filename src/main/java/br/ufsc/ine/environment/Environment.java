package br.ufsc.ine.environment;

import java.lang.reflect.Method;

import br.ufsc.ine.context.plans.Function;

public class Environment {

	private Environment() {

	}

	private static Environment ourInstance = new Environment();

	public static Environment getInstance() {
		return ourInstance;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void execute(Function function) {

		try {
			Class clazz = Class.forName(Environment.class.getName());
			Method method = clazz.getMethod(function.getName(), String.class);
			method.invoke(this, function.getArguments().toArray());

		} catch (Exception e) {
			System.out.println(e);
			// TODO: tratar erros
		}

	}

	public void print(String arg) {
		System.out.println(arg);
	}

}

package br.ufsc.ine.context.functions;

import java.lang.reflect.Method;

import br.ufsc.ine.context.plans.Function;

public class Functions {

	private Functions() {

	}

	private static Functions ourInstance = new Functions();

	public static Functions getInstance() {
		return ourInstance;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void execute(Function function) {

		try {
			Class clazz = Class.forName(Functions.class.getName());
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

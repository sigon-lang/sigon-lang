package br.ufsc.ine.context.plans;

import java.util.ArrayList;
import java.util.List;

public class Function {

	private String name;
	private String className;
	private List<Object> arguments = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Object> getArguments() {
		return arguments;
	}

	public void setArguments(List<Object> arguments) {
		this.arguments = arguments;
	}

}

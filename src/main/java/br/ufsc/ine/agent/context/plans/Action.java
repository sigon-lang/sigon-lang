package br.ufsc.ine.agent.context.plans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Action {

	private String name;
	private List<Object> arguments = new ArrayList<>();
	private Set<String> preConditions = new HashSet<>();
	private Set<String> posConditions = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Object> getArguments() {
		return arguments;
	}

	public void setArguments(List<Object> arguments) {
		this.arguments = arguments;
	}

	public Set<String> getPreConditions() {
		return preConditions;
	}

	public void setPreConditions(Set<String> preConditions) {
		this.preConditions = preConditions;
	}

	public Set<String> getPosConditions() {
		return posConditions;
	}

	public void setPosConditions(Set<String> posConditions) {
		this.posConditions = posConditions;
	}
}

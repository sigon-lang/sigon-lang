package br.ufsc.ine.context.plans;

import java.util.HashSet;
import java.util.Set;

public class Plan {

	private Set<String> preConditions = new HashSet<>();
	private Set<String> posConditions = new HashSet<>();
	private Set<Function> functions = new HashSet<>();

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

	public Set<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

}

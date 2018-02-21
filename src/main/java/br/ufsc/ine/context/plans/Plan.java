package br.ufsc.ine.context.plans;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;


public class Plan {

	private String somethingToBeTrue;
	private Set<String> preConditions = new HashSet<>();
	private Set<String> posConditions = new HashSet<>();
	private Set<Action> actions = new HashSet<>();


	public String getSomethingToBeTrue() {
		return somethingToBeTrue;
	}

	public void setSomethingToBeTrue(String somethingToBeTrue) {
		this.somethingToBeTrue = somethingToBeTrue;
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

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
}

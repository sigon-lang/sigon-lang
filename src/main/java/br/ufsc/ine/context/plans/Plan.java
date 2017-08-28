package br.ufsc.ine.context.plans;

import java.util.HashSet;
import java.util.Set;

public class Plan {

	public Set<String> preConditions = new HashSet<>();
	public Set<String> posConditions = new HashSet<>();
	public Set<Function> functions = new HashSet<>();
	
	

}

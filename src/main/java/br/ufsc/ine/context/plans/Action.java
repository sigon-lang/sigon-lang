package br.ufsc.ine.context.plans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Action {

	private String name;
	private String className;
	private List<Object> arguments = new ArrayList<>();
	private Set<String> preConditions = new HashSet<>();
	private Set<String> posConditions = new HashSet<>();
	
}

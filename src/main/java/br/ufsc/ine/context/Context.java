package br.ufsc.ine.context;

import java.util.ArrayList;
import java.util.List;

public class Context {

	private String name;
	private List<String> clauses = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<String> getClauses() {
		return clauses;
	}

	 

	public void addClause(String clause) {
		this.clauses.add(clause);
	}

}

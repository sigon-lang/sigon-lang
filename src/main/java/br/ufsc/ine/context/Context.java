package br.ufsc.ine.context;

import java.util.ArrayList;
import java.util.List;

public class Context {

	private ContextName name;
	private ContextType type;
	private List<String> clauses = new ArrayList<>();

	public ContextName getName() {
		return name;
	}

	public void setName(ContextName name) {
		this.name = name;
	}

	public ContextType getType() {
		return type;
	}

	public void setType(ContextType type) {
		this.type = type;
	}

	public List<String> getClauses() {
		return clauses;
	}

	 

	public void addClause(String clause) {
		this.clauses.add(clause);
	}

}

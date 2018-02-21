package br.ufsc.ine.agent.context;

public interface ContextService {

	public boolean verify(String fact);
	public void appendFact(String fact);
}

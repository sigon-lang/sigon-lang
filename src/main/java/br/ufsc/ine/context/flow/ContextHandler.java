package br.ufsc.ine.context.flow;

public abstract class ContextHandler {
	
    protected ContextHandler successor;
	
	public void setSuccessor(ContextHandler successor) {
		this.successor = successor;
	}
	
	public abstract void handleRequest(String literal);

}

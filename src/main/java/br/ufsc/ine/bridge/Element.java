package br.ufsc.ine.bridge;

import br.ufsc.ine.context.Context;

public class Element {

	private String value;
	private Context context;
	private String connector;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public String getConnector() {
		return connector;
	}
	public void setConnector(String connector) {
		this.connector = connector;
	}
	
	

}

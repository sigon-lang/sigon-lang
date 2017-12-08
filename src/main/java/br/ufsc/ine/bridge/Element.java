package br.ufsc.ine.bridge;

import lombok.Builder;
import lombok.Data;


public class Element {

	private String context;
	private String type;
	private Element and;
	private Element or;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Element getAnd() {
		return and;
	}

	public void setAnd(Element and) {
		this.and = and;
	}

	public Element getOr() {
		return or;
	}

	public void setOr(Element or) {
		this.or = or;
	}
}

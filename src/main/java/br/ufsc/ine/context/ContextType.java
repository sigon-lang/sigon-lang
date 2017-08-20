package br.ufsc.ine.context;

public enum ContextType {
	PROP, FOL, CUSTOM;

	public static ContextType getByName(String type) {
		if("prop".equals(type)){
			return PROP;
		} else if("fol".equals(type)){
			return FOL;
		}
		return CUSTOM;
	}
}

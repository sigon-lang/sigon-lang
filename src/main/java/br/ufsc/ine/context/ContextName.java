package br.ufsc.ine.context;

public enum ContextName {
	BELIEFS, DESIRES, INTENTIONS, CUSTOM;

	public static ContextName getByName(String name) {
		if("beliefs".equals(name)){
			return BELIEFS;
		} else if("desires".equals(name)){
			return DESIRES;
		} else if("intentions".equals(name)){
			return INTENTIONS;
		}
		return CUSTOM;
	}
}

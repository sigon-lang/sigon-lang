package br.ufsc.ine.agent.context.communication;

import java.util.List;

public abstract class Actuator {

    private String name;

    public abstract  void act(List<String> args);

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    /*public String getFactName() {
    	int index = name.indexOf("(");    	
    	return index != -1 ? name.substring(0, index) : name;
    }*/
}

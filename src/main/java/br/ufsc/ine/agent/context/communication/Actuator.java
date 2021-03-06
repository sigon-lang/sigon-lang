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
}

package br.ufsc.ine.agent;

import java.util.List;

import br.ufsc.ine.agent.context.communication.Actuator;

public class DummyActuator extends Actuator{

	@Override
	public void act(List<String> args) {
		System.out.println("Executing");
		
	}

}

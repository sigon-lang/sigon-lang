package integration;

import java.util.List;

import br.ufsc.ine.agent.context.communication.Actuator;

public class TextActuator extends Actuator{

	@Override
	public void act(List<String> args) {
		System.out.println(args);
		
		
	}
	

}

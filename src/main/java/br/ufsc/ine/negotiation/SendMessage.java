package br.ufsc.ine.negotiation;

import java.util.List;

import br.ufsc.ine.agent.context.communication.Actuator;


public class SendMessage extends Actuator{

	@Override
	public void act(List<String> args) {
		
		MainTrescak.sendPropose(args);
		
		
		// TODO Auto-generated method stub
		
		
	}
	
	
	  

}

package negotiation;

import java.util.List;

import br.ufsc.ine.agent.context.communication.Actuator;


public class SendMessage extends Actuator{

	@Override
	public void act(List<String> args) {
		System.out.println("args action "+ args.get(0));
		Main.sendPropose(args);
		
		
		// TODO Auto-generated method stub
		
		
	}
	
	public void sendPropose() {
		
		System.out.println("teste");
	}
	
	
	  

}

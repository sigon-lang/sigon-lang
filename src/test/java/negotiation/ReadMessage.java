package negotiation;

import br.ufsc.ine.agent.context.communication.Sensor;
import rx.subjects.PublishSubject;

public class ReadMessage extends Sensor{
	
	public static final PublishSubject<String> msg = PublishSubject.create();


    public void run() {
        msg.subscribe(super.publisher);


    }
	

}

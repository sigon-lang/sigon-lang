package cleaning;

import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.Actuator;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import javafx.application.Platform;
import cleaning.Main;

import java.util.List;

public class BurnGarbage extends Actuator {

	public void act(List<String> list) {

		Platform.runLater(new Runnable() {
			@Override
			public void run() {

				Main.burnGarbage();
			}
		});

	}
}
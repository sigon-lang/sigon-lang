package cleaning;

import java.util.List;

import br.ufsc.ine.agent.context.communication.Actuator;
import cleaning.Main;
import javafx.application.Platform;

public class NextSlot  extends Actuator {

    public void act(List<String> list) {



        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                Main.nextSlot();
            }
        });

    }
}
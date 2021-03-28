package integration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.ufsc.ine.agent.context.communication.Sensor;
import rx.subjects.PublishSubject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WebScraperPerception extends Sensor{
	
	public static final PublishSubject<String> msg = PublishSubject.create();


	@Override
	public void run() {
		// READ FROM A DIRECTORY the perception and process one by one?
		
		try {
			FileReader reader;
			reader = new FileReader("/home/rr/repositorios/sigon/sigon-lang/perception.json");
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(reader);
			 JSONArray perceptions = (JSONArray) obj;
			 for (Object object : perceptions) {
				System.out.println(((JSONObject) object).get("Title"));
			}
	         System.out.println(perceptions);
			
			System.out.println("Reading perceptions");
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        

		
		
		msg.subscribe(super.publisher);
		
		
		
	}

}

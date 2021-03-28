package integration;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.datavec.image.loader.ImageLoader;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.ContextService;



public class NeuralNetworkContext implements ContextService{
	private static NeuralNetworkContext instance = new NeuralNetworkContext();
	
	
	private MultiLayerNetwork model;
	private String emotion;
	
	public static NeuralNetworkContext getInstance() {
		return instance;
	}
	

	@Override
	public boolean verify(String fact) {
		return true;
	}

	@Override
	public void appendFact(String c) {
		

	}
	
	public String getCurrentEmotion() {
		return emotion;
	}
	
	public boolean checkEmotion(String e) {
		String em1 = e.substring(15, e.length()-1);
		return emotion.compareToIgnoreCase(em1) == 0;
	}

	@Override
	public void addInitialFact(String fact) throws InvalidTheoryException {
		
		
		try {
			System.out.println("Making prediction ");
			
			String modelJsonFilename = "/home/rr/eclipse-workspace/Keras/model.json";
			String weightsHdf5Filename = "/home/rr/eclipse-workspace/Keras/model_weights.h5";
			model = KerasModelImport.importKerasSequentialModelAndWeights(modelJsonFilename, weightsHdf5Filename);
			
	        BufferedImage img = ImageIO.read(new File("/home/rr/repositorios/sigon/sigon-lang/images/Training_1206.jpg"));
			ImageLoader loader = new ImageLoader(48, 48, 1);
			
			INDArray features = loader.asMatrix(img).reshape(1, 48, 48, 1);

			INDArray pred = model.output(features, false);
			switch (pred.argMax(1).toIntVector()[0]) {
			case 0:
				emotion = "angry";				
				break;
			case 1:
				emotion = "disgust";				
				break;
			case 2:
				emotion = "fear";				
				break; 
			case 3:
				emotion = "happy";				
				break;
			case 4:
				emotion = "sad";				
				break;
			case 5:
				emotion = "surprise";				
				break;
			default:
				emotion = "neutral";				
				break;
			}	
			//System.out.println("Current emotion "+emotion);
			
		} catch (InvalidKerasConfigurationException | UnsupportedKerasConfigurationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String getName() {
		return "neuralNetwork";
	}

	@Override
	public Theory getTheory() {		
		return null;
	}
	
	
	
}

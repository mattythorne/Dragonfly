/**
 * 
 */
import com.dragonfly.data.*;
import com.dragonfly.swarm.Engine;
import com.dragonfly.test.*;
/**
 * @author matt
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DataSet test = new DataSet();
		// TODO Auto-generated method stub
		
		// 1. create datasets
		// 2. add mutations
		DataSet dataSetA = new DataSet();
		dataSetA.setData(DataSets.testDataA(), 0.2);
		
		DataSet dataSetB = new DataSet();
		dataSetB.setData(DataSets.testDataA(), 0.4);
		
		dataSetA.addMutation(new Mutator(Mutator.Type.BELOW, 10.0));
		dataSetB.addMutation(new Mutator(Mutator.Type.ABOVE, 10.0));
		
		System.out.println(dataSetA.toString());
		System.out.println(dataSetB.toString());
		
		// 3. apply mutations
		dataSetA.mutate();
		dataSetB.mutate();
		
		System.out.println(dataSetA.toString());
		System.out.println(dataSetB.toString());
		// 4. add datasets to a layerstack
		
		LayerStack searchSpace = new LayerStack();
		searchSpace.addLayer(dataSetA);
		searchSpace.addLayer(dataSetB);
		
		System.out.println(searchSpace.toString());
		
		System.out.println(searchSpace.getWeightedValue(5, 5));
		// 5. create engine - Engine(layerStack, swarmSize)
		Engine engine = new Engine(searchSpace, 20);
		
		// 6. start engine
		engine.start(3);
		DataSets.outputSwarm(engine.getSwarm());
		System.out.println("done...");
	}

}

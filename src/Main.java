/**
 * 
 */
import java.util.ArrayList;

import com.dragonfly.data.*;
import com.dragonfly.satellite.LatLong;
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
		
		
		// TODO Auto-generated method stub
		
		// 1. create datasets
		// 2. add mutations
		DataSet dataSetA = new DataSet();
		dataSetA.setData(DataSets.randomDataSet(0, 20, 100, 100), 0.2);
		
		DataSet dataSetB = new DataSet();
		dataSetB.setData(DataSets.randomDataSet(40, 100, 100, 100), 0.4);
		
		DataSet dataSetC = new DataSet();
		dataSetC.setData(DataSets.randomDataSet(0, 20, 100, 100), 0.9);
		
		DataSet dataSetD = new DataSet();
		dataSetD.setData(DataSets.randomDataSet(60, 70, 100, 100), 0.1);
		
		dataSetA.addMutation(new Mutator(Mutator.Type.BELOW, 10.0));
		dataSetB.addMutation(new Mutator(Mutator.Type.ABOVE, 80.0));
		dataSetC.addMutation(new Mutator(Mutator.Type.ABOVE, 18.0));
		dataSetD.addMutation(new Mutator(Mutator.Type.BELOW, 65.0));
		
		System.out.println(dataSetA.toString());
		System.out.println(dataSetB.toString());
		
		// 3. apply mutations
		dataSetA.mutate();
		dataSetB.mutate();
		
		System.out.println(dataSetA.toString());
		System.out.println(dataSetB.toString());
		// 4. add datasets to a layerstack
		
		LatLong origin = new LatLong(-20.8125,22.640625); //Southwest boundary
		LatLong boundary = new LatLong(-20.25,23.484375); //Northeast boundary
		LayerStack searchSpace = new LayerStack(origin, boundary);
		searchSpace.addLayer(dataSetA);
		searchSpace.addLayer(dataSetB);
		
		System.out.println(searchSpace.toString());
		
		System.out.println(searchSpace.getWeightedValue(5, 5));
		// 5. create engine - Engine(layerStack, swarmSize)
		Engine engine = new Engine(searchSpace, 20);
		
		// 6. start engine
		engine.start(3);
		DataSets.outputSwarm(engine.getSwarm());
		ArrayList<LatLong> hotspots = engine.getHotspots();
		
		for(LatLong hotspot:hotspots) {
			System.out.println(hotspot.toString());
		}
		
		System.out.println("done...");
	}

}

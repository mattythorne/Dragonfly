package com.dragonfly.swarm;

import com.dragonfly.data.LayerStack;

/**
 * 1. Randomly initialise a swarm of insects at random positions in the search space
 * 2. evaluate all positions and update the global best position and personal best positions
 * 3. update each velocity based on the relative position of the global best position, 
 *    the current velocity of the insect, the personal best position of the insect and
 *    a random vector
 * 4. rinse and repeat
 * 
 * @author matt
 *
 */
public class Engine {
	private LayerStack layerStack;
	private int swarmSize;
	private int fieldWidth;
	private int fieldHeight;

	public Engine(LayerStack layerStack, int swarmSize) {
		super();
		this.layerStack = layerStack;
		this.swarmSize = swarmSize;
		this.fieldHeight = layerStack.getFieldHeight();
		this.fieldWidth = layerStack.getFieldWidth();
	}
	
	
}

package com.dragonfly.swarm;


import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.dragonfly.data.LayerStack;
import com.dragonfly.satellite.LatLong;
import com.dragonfly.swarm.Insect.Tendancy;

import java.util.Random;

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
	private Layer dataLayer = new Layer(); 
	private ArrayList<Insect> swarm = new ArrayList<Insect>(); 
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
	
	public void start(int iterations) {
		createDataLayer();
		System.out.println(dataLayer.toString());
		createInsects();
		
		for(int n = 0; n < iterations; n++) {
			System.out.println("\r\nIteration : " + n + "\r\n");
			iterateSwarm();
		}
	}
	
	
	private void createDataLayer() {
		this.dataLayer.setySize(this.fieldHeight);
		this.dataLayer.setxSize(this.fieldWidth);
		this.dataLayer.initialise();
		
		System.out.println("initialised");
		for(int y = 0; y < this.fieldHeight; y++) {
			for(int x = 0; x < this.fieldWidth; x++) {
				dataLayer.setDataAt(x, y, layerStack.getWeightedValue(x, y));
			}
		}
	}
	
	
	private void createInsects() {
		Random random = new Random();
		System.out.println("Insect Starting Positions : ");
		for(int n=0; n < this.swarmSize; n++) {
			int x = random.nextInt(this.fieldWidth);
			int y = random.nextInt(this.fieldHeight);
			swarm.add(new Insect(x, y, this.fieldWidth, this.fieldHeight, Tendancy.AUDACIOUS));
			
			
			System.out.println(x + ", " + y);
			
		}
	}
	
	// NEEDS HELP
	private void iterateSwarm() {
		
		for(Insect insect:this.swarm) insect.move(dataLayer.getDataAt(insect.getPosX(), insect.getPosY()), getGlobalBest());
	}
	
	private Best getGlobalBest(){
		Best globalBest = new Best(0.0, 0, 0);
		for(Insect insect:this.swarm) {
			if(insect.getPersonalBest().value > globalBest.value) globalBest = insect.getPersonalBest(); 
		}
		if(globalBest.value == 0.0) {
			globalBest.posX = this.fieldWidth/2;
			globalBest.posY = this.fieldHeight/2;
		}
		
		System.out.println("Global Best : " + globalBest.getPosX() + ", " + globalBest.getPosY() + " : " + globalBest.value);
		return globalBest;
	}

	public ArrayList<Insect> getSwarm() {
		return swarm;
	}

	public LinkedHashSet<LatLong> getHotspots() {
		LinkedHashSet<LatLong> hotspots = new LinkedHashSet<LatLong>();
		Best globalBest = getGlobalBest();
		hotspots.add(layerStack.convertDataPoint(globalBest.getPosX(), globalBest.getPosY()));
		for(Insect insect:this.swarm){
			hotspots.add(layerStack.convertDataPoint(insect.getPersonalBest().getPosX(), insect.getPersonalBest().getPosY()));
		}
		return hotspots;
	}
	
}

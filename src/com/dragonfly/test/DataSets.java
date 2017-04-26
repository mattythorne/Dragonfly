package com.dragonfly.test;

import java.util.ArrayList;
import java.util.Random;

import com.dragonfly.swarm.Insect;

public class DataSets {

	
	
	public static ArrayList<ArrayList<Double>> testDataA () {
		//10x10 random
		ArrayList<ArrayList<Double>> testData = new ArrayList<ArrayList<Double>>();
		Random random = new Random();
		
		for(int y = 0; y < 10; y++){
			testData.add(new ArrayList<Double>());
			for(int x = 0; x < 10; x++){
				double value = 0.0 + (20.0 - 0.0) * random.nextDouble();
				testData.get(y).add(value);
			}
		}
		
		
		return testData;
	}
	
	public static void outputSwarm(ArrayList<Insect> swarm){
		
		for(Insect insect:swarm){
			System.out.println(insect.getPosX() + ", " + insect.getPosY() + " ");
		}
		
		System.out.println("\r\n");
	}
}

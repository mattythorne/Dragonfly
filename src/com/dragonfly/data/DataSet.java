/**
 * 
 */
package com.dragonfly.data;

import java.util.ArrayList;


/**
 * @author matt
 *
 */
public class DataSet {
	
	private int xSize;
	private int ySize;
	private double weight;
	private ArrayList<Mutator> mutators = new ArrayList<Mutator>();
	private ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
	
	
	
	public DataSet() {
		super();
	}

	public DataSet(int xSize, int ySize, double weight, ArrayList<Mutator> mutators, ArrayList<ArrayList<Double>> data) {
		super();	
		setMutators(mutators);
		setData(data);
		setySize(data.size());
		setWeight(weight);
		ArrayList<Double> row = new ArrayList<Double>();
		row = data.get(0);
		setxSize(row.size());
		
	}
	
	public int getxSize() {
		return xSize;
	}
	private void setxSize(int xSize) {
		this.xSize = xSize;
	}
	public int getySize() {
		return ySize;
	}
	private void setySize(int ySize) {
		this.ySize = ySize;
	}
	public ArrayList<Mutator> getMutators() {
		return mutators;
	}
	private void setMutators(ArrayList<Mutator> mutators) {
		this.mutators = mutators;
	}
	public ArrayList<ArrayList<Double>> getData() {
		return data;
	}
	private void setData(ArrayList<ArrayList<Double>> data) {
		this.data = data;
	}
	
	public double getDataAt(int x, int y) {
		ArrayList<Double> row = new ArrayList<Double>();
		row = data.get(y);
		
		return row.get(x);
	}
	
	/**
	private void setDataAt(int x, int y, double value) {
		ArrayList<Double> row = new ArrayList<Double>();
		row = data.get(y);
		row.set(x, value);
	}
	*/
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void mutate() {
		
		for(ArrayList<Double> row:this.data){
			for(Double dataValue:row){
				for(Mutator mutator:this.mutators){
					row.set(row.indexOf(dataValue), mutator.mutate(dataValue));
				}
			}
		}
	}
	
	

}

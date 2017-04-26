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
		setData(data, weight);
		
		
		
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
	public void setData(ArrayList<ArrayList<Double>> data, Double weight) {
		this.data = data;
		setySize(data.size());
		ArrayList<Double> row = new ArrayList<Double>();
		row = data.get(0);
		setxSize(row.size());
		setWeight(weight);
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
		for(Mutator mutator:this.mutators){
		for(ArrayList<Double> row:this.data){
			for(Double dataValue:row){
				int column = row.indexOf(dataValue);
					row.set(column, mutator.mutate(dataValue));
				}
			}
		}
	}
	
	public void addMutation(Mutator mutator) {
		this.mutators.add(mutator);
		System.out.println(mutator.toString());
		
	}
	
	public String toString(){
		String result = "";
		
		for(ArrayList<Double> row:this.data){
			for(Double dataValue:row){
				result += dataValue.toString() + ", ";
			}
			result += "\r\n";
		}
		
		result += "\r\n";
		result += "Mutators : \r\n";
		
		for(Mutator mutator:this.mutators){
			result += mutator.toString() + "\r\n";
		}
		
		return result;
	}

}

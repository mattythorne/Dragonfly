package com.dragonfly.swarm;

import java.util.ArrayList;

import com.dragonfly.data.DataSet;

public class Layer {
	private int xSize;
	private int ySize;
	private ArrayList<ArrayList<Double>> map = new ArrayList<ArrayList<Double>>();
	
	public Layer() {
		super();
	}

	public Layer(ArrayList<ArrayList<Double>> map) {
		super();
		this.map = map;
		getDimensions(); 
	}
	
	public int getxSize() {
		return xSize;
	}
	
	public void setxSize(int xSize) {
		this.xSize = xSize;
	}
	
	public int getySize() {
		return ySize;
	}
	
	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	
	public ArrayList<ArrayList<Double>> getMap() {
		return map;
	}
	
	public void setMap(ArrayList<ArrayList<Double>> map) {
		this.map = map;
	}
	
	public Double getDataAt(int x, int y) {
		ArrayList<Double> row;
		row = map.get(y);
		return row.get(x);
	}
	
	public void setDataAt(int x, int y, double value) {
		ArrayList<Double> row;
		row = map.get(y);
		row.set(x, value);
	}
	
	private void getDimensions() {	
		this.ySize = this.map.size();
		for(ArrayList<Double> dataLayer:this.map) {
			this.xSize = dataLayer.size();
		}
	}
	
	public void initialise() {
		System.out.println(this.getxSize() + ", " + this.getySize());
		for(int y = 0; y < this.getySize(); y++) {
			ArrayList<Double> row = new ArrayList<Double>();
			map.add(row);
			for(int x = 0; x < this.getxSize(); x++) {
				row.add(0.0);
			}
		}
	}
	
	public String toString(){
		String result = "";
		
		for(ArrayList<Double> row:this.map){
			for(Double dataValue:row){
				result += dataValue.toString() + ", ";
			}
			result += "\r\n";
		}
		
		return result;
	}
	
}

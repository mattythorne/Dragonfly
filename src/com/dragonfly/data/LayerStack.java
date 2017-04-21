package com.dragonfly.data;

import java.util.ArrayList;

public class LayerStack {
	
	public ArrayList<DataSet> dataSets = new ArrayList<DataSet>();
	private int fieldWidth;
	private int fieldHeight;

	public LayerStack(ArrayList<DataSet> dataSets) {
		super();
		this.dataSets = dataSets;
		getFieldDimensions();
	}
	
	public int getFieldWidth() {
		return fieldWidth;
	}

	public int getFieldHeight() {
		return fieldHeight;
	}
	
	private void getFieldDimensions() {
		
		this.fieldWidth = Integer.MAX_VALUE;
		this.fieldHeight = Integer.MAX_VALUE;
		
		for(DataSet dataLayer:this.dataSets) {
			int x = dataLayer.getxSize();
			int y = dataLayer.getySize();
			if(x < fieldWidth) this.fieldWidth = x;
			if(y < fieldHeight) this.fieldHeight = y;
		}

	}

	
	// Needs improvement
	public Double getWeightedValue(int x, int y){
		
		Double weightedValue=0.0;
		
		for(DataSet dataLayer:this.dataSets) {
			Double dataValue = dataLayer.getDataAt(x, y);
			
			if(dataValue != 0.0) {
				dataValue = 1 + dataLayer.getWeight();
				weightedValue = weightedValue + dataValue;
			}
			
		}
		
		return weightedValue;
	}
	
}

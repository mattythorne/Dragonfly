package com.dragonfly.data;

import java.util.ArrayList;

public class LayerStack {
	public ArrayList<DataSet> dataSets = new ArrayList<DataSet>();

	public LayerStack(ArrayList<DataSet> dataSets) {
		super();
		this.dataSets = dataSets;
	}
	
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

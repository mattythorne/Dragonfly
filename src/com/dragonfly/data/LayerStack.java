package com.dragonfly.data;

import java.util.ArrayList;

import com.dragonfly.satellite.LatLong;

public class LayerStack {
	
	public ArrayList<DataSet> dataSets = new ArrayList<DataSet>();
	private int fieldWidth;
	private int fieldHeight;
	private LatLong origin = new LatLong();
	private LatLong boundary = new LatLong();

	public LayerStack() {
		super();
	}

	public LayerStack(LatLong origin, LatLong boundary) {
		super();
		
		this.origin = origin;
		this.boundary = boundary;
	}
	
	public LayerStack(ArrayList<DataSet> dataSets, LatLong origin, LatLong boundary) {
		super();
		this.dataSets = dataSets;
		getFieldDimensions();
		this.origin = origin;
		this.boundary = boundary;
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

	
	public LatLong getOrigin() {
		return origin;
	}

	//Origin is southwest point
	public void setOrigin(LatLong origin) {
		this.origin = origin;
	}

	public LatLong getBoundary() {
		return boundary;
	}

	//boundary is northeast point
	public void setBoundary(LatLong boundary) {
		this.boundary = boundary;
	}

	// Needs improvement
	public Double getWeightedValue(int x, int y){
		
		Double weightedValue=0.0;
		
		for(DataSet dataLayer:this.dataSets) {
			Double dataValue = dataLayer.getDataAt(x, y);
				
			if(dataValue != 0.0) {
				double weight = dataLayer.getWeight();
				
				weightedValue = (weightedValue + 1.0) * (weight * 10);
			}
				
		}
		
		
		return weightedValue;
	}
	
	public void addLayer(DataSet layer){
		this.dataSets.add(layer);
		getFieldDimensions();
	}
	
	public String toString(){
		return "Layers : " + dataSets.size() + "\r\n" + "Environment size : " + fieldWidth + ", " + fieldHeight + "\r\n";
	}
	
	public LatLong convertDataPoint(int x, int y){
		LatLong result = new LatLong();
		
		result.setLatitude(origin.latitude + ((origin.latitude - boundary.latitude)/fieldHeight));
		result.setLongitude(origin.longitude + ((boundary.longitude - origin.longitude)/fieldWidth));
		
		
		return result;
	}
	
}

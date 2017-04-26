package com.dragonfly.data;

public class Mutator {
	public static enum Type { BELOW, ABOVE, BETWEEN }
	
	private Type mutationType;
	private double lowValue;
	private double highValue;
	
	public Mutator(Type mutationType, double value) {
		super();
		this.setMutationType(mutationType);
		this.setLowValue(value);
	}

	public Mutator(Type between, double lowValue, double highValue) {
		super();
		this.setMutationType(Type.BETWEEN);
		this.setLowValue(lowValue);
		this.setHighValue(highValue);
	}
	
	public Type getMutationType() {
		return mutationType;
	}

	private void setMutationType(Type type) {
		this.mutationType = type;
	}

	public double getLowValue() {
		return lowValue;
	}

	private void setLowValue(double lowValue) {
		this.lowValue = lowValue;
	}

	public double getHighValue() {
		return highValue;
	}

	private void setHighValue(double highValue) {
		this.highValue = highValue;
	}

	public Double mutate(Double value){
		Double mutationResult=value;
		
		switch (mutationType) {
			case BELOW		:	if(value<lowValue) mutationResult=0.0;
								break;
								
			case ABOVE		:	if(value>lowValue) mutationResult=0.0;
								break;
								
			case BETWEEN	:	if((value>lowValue) && (value<highValue)) mutationResult=0.0;
								break;
				
			default			: 	mutationResult=value;
								break;
		}
		return mutationResult;
	}

	public String toString(){
		return "type : " + mutationType + "\r\n" + "lowValue : " + lowValue + "\r\n" + "highValue : " + highValue + "\r\n";
	}
	
}

package com.dragonfly.swarm;

public class Best {
	

	Double value;
	int posX;
	int posY;
	
	
	
	public Best() {
		super();
	}

	public Best(Double value, int posX, int posY) {
		super();
		this.value = value;
		this.posX = posX;
		this.posY = posY;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void set(int posX, int posY, Double value) {
		this.value = value;
		this.posX = posX;
		this.posY = posY;
	}
	
}

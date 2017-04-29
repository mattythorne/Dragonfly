package com.dragonfly.satellite;

public class LatLong {
	public Double latitude;
	public Double longitude;
	
	public LatLong() {
		super();
	}

	public LatLong(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String toString(){
		return this.latitude.toString() + ", " + this.longitude.toString();
	}
	
}

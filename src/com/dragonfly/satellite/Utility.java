package com.dragonfly.satellite;

public class Utility {
	
	public static String getDataURL(LatLong origin, LatLong boundary) {
		//https://search.earthdata.nasa.gov/search/collections?sb=22.640625%2C-20.8125%2C23.484375%2C-20.25
		String url = "https://search.earthdata.nasa.gov/search/collections?sb=" + origin.longitude.toString() + "%2C" + origin.latitude.toString() + "%2C" + boundary.longitude.toString() + "%2C" + boundary.latitude.toString();
		return url;
	}

}

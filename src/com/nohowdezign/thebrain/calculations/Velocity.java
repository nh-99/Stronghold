package com.nohowdezign.thebrain.calculations;

public class Velocity {
	
	public double getVelocityForDistance(double distance, double height, double time) {
		return Math.sqrt(Math.pow(distance, 2) - Math.pow(height, 2));
	}
	
}

package com.nohowdezign.thebrain.server.responses;

public class Target {
	private int targetID;
	private double distanceToTarget;
	
	public int getTargetID() {
		return targetID;
	}
	
	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}
	
	public double getDistanceToTarget() {
		return distanceToTarget;
	}
	
	public void setDistanceToTarget(double distanceToTarget) {
		this.distanceToTarget = distanceToTarget;
	}
}

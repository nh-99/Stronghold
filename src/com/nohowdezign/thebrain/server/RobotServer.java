package com.nohowdezign.thebrain.server;

import java.io.IOException;
import java.util.Arrays;

import com.alibaba.fastjson.JSON;
import com.nohowdezign.thebrain.server.responses.Distance;
import com.nohowdezign.thebrain.server.responses.Target;

public class RobotServer extends ServerFactory implements Runnable {
	private double distanceToGoal;
	private int goalId = -1;
	
	private float distanceToShoot; // Store the distance that the robot is going to take a shot at

	public void run() {
		try {
			super.runServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onMessage(String message) {
		Distance distance = JSON.parseObject(message, Distance.class);
		if(goalId != -1) {
			for(Target target : distance.getTargets()) {
				if(target.getTargetID() == this.goalId) {
					this.distanceToGoal = target.getDistanceToTarget();
				}
			}
		} else {
			double[] distances = {};
			for(Target target : distance.getTargets()) {
				distances = addElement(distances, target.getDistanceToTarget());
			}
			
			Arrays.sort(distances);
			
			for(Target target : distance.getTargets()) {
				if(target.getDistanceToTarget() == distances[0]) {
					this.goalId = target.getTargetID();
					this.distanceToGoal = target.getDistanceToTarget();
				}
			}
		}
	}

	public float getDistanceToShoot() {
		return distanceToShoot;
	}

	public void setDistanceToShoot(float distanceToShoot) {
		this.distanceToShoot = distanceToShoot;
	}

	public double getDistanceToGoal() {
		return distanceToGoal;
	}

	public int getGoalId() {
		return goalId;
	}
	
	private static double[] addElement(double[] a, double d) {
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = d;
	    return a;
	}

}

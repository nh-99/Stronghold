package com.nohowdezign.thebrain.server.responses;

import java.util.ArrayList;
import java.util.List;

public class Distance {
	private List<Target> targets = new ArrayList<Target>();

	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}
}

package com.nohowdezign.thebrain.server;

import java.io.IOException;

public class RobotServer extends ServerFactory implements Runnable {

	public void run() {
		try {
			super.runServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

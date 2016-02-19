package com.nohowdezign.thebrain.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	
	public void send(String message, String hostIp, int port) {
		DatagramSocket socket = null;

	    try {
	       InetAddress host = InetAddress.getByName(hostIp);
	       socket = new DatagramSocket();
           byte [] data = message.getBytes(); // To start the VT: "{\"command\":\"Autonomous\",\"image\":\"asdf\"}"
           DatagramPacket packet = new DatagramPacket(data, data.length, host, port);
	       socket.send(packet);
	    } catch(Exception e) {
	       System.out.println(e) ;
	    } finally {
	       if(socket != null)
	       socket.close();
	    }
	}

}

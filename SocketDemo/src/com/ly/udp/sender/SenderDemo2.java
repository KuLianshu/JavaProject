package com.ly.udp.sender;

import java.net.DatagramSocket;
import java.net.SocketException;

public class SenderDemo2 {

	public static void main(String[] args) {
		DatagramSocket datagramSocket=null;
		try {
			datagramSocket=new DatagramSocket();
			new Thread(new SenderRunnable(datagramSocket)).start();
			
		} catch (SocketException e) {
			e.printStackTrace();
		}

	}

}

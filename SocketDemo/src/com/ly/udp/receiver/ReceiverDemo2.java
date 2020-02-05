package com.ly.udp.receiver;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiverDemo2 {

	public static void main(String[] args) {
		DatagramSocket datagramSocket=null;
		try {
			datagramSocket=new DatagramSocket(8000);
			System.out.println("接收方数据报套接字实例化成功！");
			new Thread(new ReceiverRunnable(datagramSocket)).start();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		

	}

}

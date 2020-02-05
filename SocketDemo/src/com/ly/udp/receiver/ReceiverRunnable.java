package com.ly.udp.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiverRunnable implements Runnable{

	private DatagramSocket datagramSocket;

	public ReceiverRunnable(DatagramSocket datagramSocket) {
		this.datagramSocket=datagramSocket;
	}
	
	@Override
	public void run() {
		byte[]buffer=new byte[1024];
		int len=buffer.length;
		DatagramPacket datagramPacket=new DatagramPacket(buffer,len);
		try {
			while(true) {
				this.datagramSocket.receive(datagramPacket);
				byte[]dataBuffer=datagramPacket.getData();
				int length=datagramPacket.getLength();
				String content =new String(dataBuffer,0,length);
				String sendIP=datagramPacket.getAddress().getHostAddress();
				int sendPort=datagramPacket.getPort();
				if("over".equals(content)) {
					System.out.println("发送方"+sendIP+":"+sendPort+"离开聊天室！");
					continue;
				}
				System.out.println("发送方"+sendIP+":"+sendPort+"发送过来的数据为："+content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

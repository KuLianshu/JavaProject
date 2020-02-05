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
					System.out.println("���ͷ�"+sendIP+":"+sendPort+"�뿪�����ң�");
					continue;
				}
				System.out.println("���ͷ�"+sendIP+":"+sendPort+"���͹���������Ϊ��"+content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

package com.ly.udp.sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SenderRunnable implements Runnable{

	private DatagramSocket datagramSocket;
	private BufferedReader bufferedReader;
	public SenderRunnable(DatagramSocket datagramSocket) {
		this.datagramSocket=datagramSocket;
		this.bufferedReader=new BufferedReader(new InputStreamReader(System.in));	
	}
	
	
	@Override
	public void run() {
		
		try {
			while(true) {
				System.out.println("请输入发送到接收方的数据：");
				String line=bufferedReader.readLine();
				if(line!=null&&!"".equals(line)) {
					byte[]buffer=line.getBytes();
					int length=buffer.length;
					InetAddress inetAddress=InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
					int port=8000;
					DatagramPacket datagramPacket=new DatagramPacket(buffer,length,inetAddress,port);
					datagramSocket.send(datagramPacket);
					if("over".equals(line)) {
						break;
					}
					System.out.println("发送方发送数据成功！");
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

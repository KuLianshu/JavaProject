package com.ly.udp.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveLetterForLi implements Runnable{
	
	@Override
	public void run() {
		DatagramPacket pack=null;
		DatagramSocket postman=null;
		byte data[]=new byte[8192];
		pack=new DatagramPacket(data,data.length);
		try {
			postman=new DatagramSocket(666);
			while(true) {
				if(postman==null) {
					break;
				}else {
					postman.receive(pack);
					String message=new String(pack.getData(),0,pack.getLength());
					System.out.println("%25s\n"+" ’µΩ£∫"+message);
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

package com.ly.udp.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveLetterForZhang implements Runnable{

	@Override
	public void run() {
		DatagramPacket pack=null;
		DatagramSocket postman=null;
		byte data[]=new byte[8192];
		try {
			pack=new DatagramPacket(data,data.length);
			postman=new DatagramSocket(8000);
			while(true) {
				if(postman==null) {
					break;
				}else {
					postman.receive(pack);
					String message=new String(pack.getData(),0,pack.getLength());
					System.out.printf("%25s\n"," ’µΩ£∫"+message);
					
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
}

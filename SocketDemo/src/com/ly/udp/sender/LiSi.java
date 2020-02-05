package com.ly.udp.sender;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import com.ly.udp.receiver.ReceiveLetterForLi;

public class LiSi {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Thread readData;
		DatagramPacket dataPack=null;
		DatagramSocket postman=null;
		ReceiveLetterForLi receiver=new ReceiveLetterForLi();
		try {
			readData=new Thread(receiver);
			readData.start();
			byte[]buffer=new byte[1];
			InetAddress address=InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
			dataPack=new DatagramPacket(buffer,buffer.length,address,888);
			postman=new DatagramSocket();
			System.out.println("请输入发送给张三的信息：");
			while(scanner.hasNext()) {
				String mess=scanner.nextLine();
				buffer=mess.getBytes();
				if(mess.length()==0) {
					System.exit(0);
				}else {
					buffer=mess.getBytes();
					dataPack.setData(buffer);
					postman.send(dataPack);
					System.out.println("请继续输入发送给张三的信息：");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			scanner.close();
		}
		

	}

}

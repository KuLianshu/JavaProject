package com.ly.udp.sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.ly.udp.receiver.ReceiveLetterForZhang;

public class ZhangSan {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Thread readData;
		DatagramSocket postman=null;
		ReceiveLetterForZhang receiver=new ReceiveLetterForZhang();
		try {
			readData=new Thread(receiver);
			readData.start();
			byte[]buffer=new byte[1];
			InetAddress address=InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
			DatagramPacket dataPack=new DatagramPacket(buffer,buffer.length,address,666);
			postman=new DatagramSocket();
			System.out.println("输入发送给李四的信息：");
			while(scanner.hasNext()) {
				String mess=scanner.nextLine();
				buffer=mess.getBytes();
				if(mess.length()==0) {
					System.exit(0);
				}
				buffer=mess.getBytes();
				dataPack.setData(buffer);
				postman.send(dataPack);
				System.out.println("请继续输入发送给李四的信息：");
				
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(postman!=null) {
				postman.close();
				postman=null;
			}
			scanner.close();
		}
		

	}

}

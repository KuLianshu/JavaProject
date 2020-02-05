package com.ly.udp.sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SenderDemo1 {

	public static void main(String[] args) {
		DatagramSocket datagramSocket=null;

		try {
			//实例化数据报套接字对象，如果没有指定端口则会随机分配一个端口
			datagramSocket=new DatagramSocket();
			System.out.println("发送方数据报套接字实例化成功！");
			byte[]buffer="来自发送方的数据！".getBytes();
			int length=buffer.length;
			InetAddress inetAddress=InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
			int port=8000;
			DatagramPacket datagramPacket=new DatagramPacket(buffer,0,length,inetAddress,port);
			//使用数据报套接字发送数据报到接收方
			datagramSocket.send(datagramPacket);
			System.out.println("发送方发送数据成功！");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(datagramSocket!=null) {
				datagramSocket.close();
				datagramSocket=null;
			}
		}

	}

}

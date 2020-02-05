package com.ly.udp.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiverDemo1 {
	
	public static void main(String[] args) {
		
		DatagramSocket datagramSocket=null;
		try {
			datagramSocket=new DatagramSocket(8000);
			System.out.println("接收方数据报套接字实例化成功！");
			
			byte[]buffer=new byte[1024];
			int len=buffer.length;
			DatagramPacket datagramPacket=new DatagramPacket(buffer, len);
			//调用套接字的receive()方法接收发送方发送的数据
			datagramSocket.receive(datagramPacket);
			String sendIp=datagramPacket.getAddress().getHostAddress();
			int sendPort=datagramPacket.getPort();
			System.out.println("成功接收了发送方"+sendIp+":"+sendPort+"发送过来的数据");
			//得到本地接收方的IP地址
			//datagramSocket.getLocalAddress();
			//得到本地接收方的端口号
			//datagramSocket.getLocalPort();
			//解析发送方发送过来的字节数组并解码得到字符串
			byte[]dataBuffer=datagramPacket.getData();
			int length=datagramPacket.getLength();
			String content=new String(dataBuffer,0,length);
			System.out.println("content="+content);
			//如果发送方发送的数据远远小于接收方指定的字节数组的大小，则会产生大量空白，浪费控空间
			System.out.println("receiveData:"+new String(buffer,0,len));
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

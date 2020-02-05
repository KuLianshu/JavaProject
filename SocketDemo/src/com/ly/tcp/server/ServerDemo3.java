package com.ly.tcp.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo3 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket=null;
		Socket socket=null;
		try {
			serverSocket=new ServerSocket(8000);
			System.out.println("监听套接字实例化成功！");
			socket=serverSocket.accept();
			String clientIp=socket.getInetAddress().getHostAddress();
			int clientPort=socket.getPort();
			System.out.println("客户端"+clientIp+":"+clientPort+"连接成功！");
			InputStream inputStream=socket.getInputStream();
			byte[]buffer=new byte[1024];
			int len=0;
			StringBuilder sb=new StringBuilder();
			//如果客户端在数据发送完毕时调用了socket.shutdownOutput();，则read()方法返回-1，结束读取
			while((len=inputStream.read(buffer))!=-1) {
				String str=new String(buffer,0,len);
				sb.append(str);
			}
			System.out.println("客户端发送到服务器端的数据为："+sb.toString());
			System.out.println("读取客户端发送过来的数据完毕！");
			OutputStream out=socket.getOutputStream();
			out.write("你好呀哥们！".getBytes());
			System.out.println("向客户端回送数据完毕！");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(socket!=null) {
				try {
					socket.close();
					socket=null;
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			
			if(serverSocket!=null) {
				try {
					serverSocket.close();
					serverSocket=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

	}

}

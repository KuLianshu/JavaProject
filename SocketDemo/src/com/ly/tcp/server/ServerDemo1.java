package com.ly.tcp.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的服务器端程序编写
 * @author Weiliyuan
 *
 */
public class ServerDemo1 {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null;
		try {
			//实例化套接字并指定监听端口
			serverSocket=new ServerSocket(2019);
			System.out.println("监听套接字实例化成功！");
			//调用监听套接字的accept方法等待客户端的连接，如果没有客户端进行连接，则这个方法阻塞
			//直到有客户端连接过来，则阻塞解除并返回通讯套接字
			socket=serverSocket.accept();
			//获取连接过来的客户端的IP地址
			String clientIp=socket.getInetAddress().getHostAddress();
			//获取连接过来的客户端的端口号
			int clientPort=socket.getPort();
			System.out.println("客户端"+clientIp+":"+clientPort+"连接成功！");
			//根据同学套接字得到输入流和输出流用于读取客户端发送过来的数据或者向客户端发送数据
			InputStream inputStream =socket.getInputStream();
			byte[]buffer=new byte[1024];
			int len=0;
			while((len=inputStream.read(buffer))!=-1) {
				System.out.println(new String(buffer,0,len));
			}
			System.out.println("读取客户端发送过来的数据完毕！");
			
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

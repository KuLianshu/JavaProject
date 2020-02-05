package com.ly.tcp.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo2 {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null;
		Scanner scanner=new Scanner(System.in);
		try {
			serverSocket=new ServerSocket(8000);
			//在客户端连接进来之前，accept()方法一直处于阻塞状态
			System.out.println("服务器端开始监听！");
			socket=serverSocket.accept();
			String clientIp=socket.getInetAddress().getHostAddress();
			int clientPort=socket.getPort();
			System.out.println("客户端"+clientIp+":"+clientPort+"连接成功！");
			InputStream inputStream=socket.getInputStream();
			byte[]buffer=new byte[1024];
			int len=0;
			StringBuilder sb=new StringBuilder();
			//read()在没有读到数据之前也是处于阻塞状态的
			while((len=inputStream.read(buffer))!=-1) {
				String str=new String(buffer,0,len);
				sb.append(str);
				System.out.println("客户端发送的数据："+sb.toString());
				//客户端发送数据完毕的标记
				if(str.contains("over")) {
					break;
				}
			}
			
			System.out.println("读取客户端发送过来的数据完毕！");
			OutputStream outputStream=socket.getOutputStream();
			System.out.println("向客户端回传数据：");
			String content=scanner.nextLine();
			outputStream.write(content.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			scanner.close();
			scanner=null;
			
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

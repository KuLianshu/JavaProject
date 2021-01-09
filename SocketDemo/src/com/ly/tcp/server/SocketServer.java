package com.ly.tcp.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) {
		
		int port = 55533;
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("Server端等待连接到来");
			Socket socket = server.accept();
			InputStream inputStream = socket.getInputStream();
			byte [] bytes;
			while(true) {
				int first = inputStream.read();
				if(first == -1) {
					break;
				}
				int second = inputStream.read();
				int length = (first<<8)+second;
				bytes = new byte[length];
				inputStream.read(bytes);
				System.out.println("客户端发来的信息："+new String(bytes,"UTF-8"));
			}
			
			inputStream.close();
			socket.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}

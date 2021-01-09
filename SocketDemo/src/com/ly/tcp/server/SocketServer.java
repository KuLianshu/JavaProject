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
			System.out.println("Server�˵ȴ����ӵ���");
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
				System.out.println("�ͻ��˷�������Ϣ��"+new String(bytes,"UTF-8"));
			}
			
			inputStream.close();
			socket.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}

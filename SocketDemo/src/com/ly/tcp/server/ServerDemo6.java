package com.ly.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo6 {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			
			serverSocket = new ServerSocket(9999);
			while(true) {
				//waiting for client
				System.out.println("Waitting...");
				Socket socket = serverSocket.accept();
				System.out.println("connect success, ip:"+socket.getInetAddress().toString());
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(socket.getInputStream(),"UTF-8"));
				
				String str = null;
				while((str = bufferedReader.readLine())!=null) {
					System.out.println(str);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

package com.ly.tcp.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 55533;
		try {
			Socket socket = new Socket(host,port);
			OutputStream outputStream = socket.getOutputStream();
			String message = "ÄãºÃ£¡£¡hhhhh";
			byte[] sendBytes = message.getBytes("UTF-8");
			outputStream.write(sendBytes.length>>8);
			outputStream.write(sendBytes.length);
			outputStream.write(sendBytes);
			outputStream.flush();
			
			
			
			
			outputStream.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

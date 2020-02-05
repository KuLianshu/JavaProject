package com.ly.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.ly.tcp.servicer.Servicer1;

/**
 * 接收多人聊天
 * @author Weiliyuan
 *
 */
public class ServerDemo4 {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null;
		try {
			serverSocket=new ServerSocket(8000);
			System.out.println("服务器端开始监听！");
			
			//能够让多人同时连上服务器
			while(true) {
				//等待客户端的连接
				socket=serverSocket.accept();
				new Thread(new Servicer1(socket)).start();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

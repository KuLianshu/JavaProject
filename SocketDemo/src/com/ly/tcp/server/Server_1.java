package com.ly.tcp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_1 {

	public static void main(String[] args) {
		String [] answer= {"来自服务器的第一条消息","来自服务器的第二条消息","来自服务器的第三条消息"};
		ServerSocket serverForClient=null;
		Socket socketOnServer=null;
		DataOutputStream out=null;
		DataInputStream in=null;
		try {
			serverForClient=new ServerSocket(2010);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("");
			//阻塞状态，除非有客户呼叫
			socketOnServer=serverForClient.accept();
			System.out.println("address："+socketOnServer.getInetAddress().getHostAddress());
			out=new DataOutputStream(socketOnServer.getOutputStream());
			in=new DataInputStream(socketOnServer.getInputStream());
			for(int i=0;i<answer.length;i++) {
				//in 读取信息，阻塞状态
				String s=in.readUTF();
				System.out.println("服务器收到客户端的消息："+s);
				out.writeUTF(answer[i]);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端已断开"+e);
		}finally {
			if(socketOnServer!=null) {
				try {
					socketOnServer.close();
					socketOnServer=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if(serverForClient!=null) {
				try {
					serverForClient.close();
					serverForClient=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

package com.ly.tcp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_1 {

	public static void main(String[] args) {
		String [] answer= {"���Է������ĵ�һ����Ϣ","���Է������ĵڶ�����Ϣ","���Է������ĵ�������Ϣ"};
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
			//����״̬�������пͻ�����
			socketOnServer=serverForClient.accept();
			System.out.println("address��"+socketOnServer.getInetAddress().getHostAddress());
			out=new DataOutputStream(socketOnServer.getOutputStream());
			in=new DataInputStream(socketOnServer.getInputStream());
			for(int i=0;i<answer.length;i++) {
				//in ��ȡ��Ϣ������״̬
				String s=in.readUTF();
				System.out.println("�������յ��ͻ��˵���Ϣ��"+s);
				out.writeUTF(answer[i]);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ͻ����ѶϿ�"+e);
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

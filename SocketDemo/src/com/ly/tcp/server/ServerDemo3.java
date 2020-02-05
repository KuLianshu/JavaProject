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
			System.out.println("�����׽���ʵ�����ɹ���");
			socket=serverSocket.accept();
			String clientIp=socket.getInetAddress().getHostAddress();
			int clientPort=socket.getPort();
			System.out.println("�ͻ���"+clientIp+":"+clientPort+"���ӳɹ���");
			InputStream inputStream=socket.getInputStream();
			byte[]buffer=new byte[1024];
			int len=0;
			StringBuilder sb=new StringBuilder();
			//����ͻ��������ݷ������ʱ������socket.shutdownOutput();����read()��������-1��������ȡ
			while((len=inputStream.read(buffer))!=-1) {
				String str=new String(buffer,0,len);
				sb.append(str);
			}
			System.out.println("�ͻ��˷��͵��������˵�����Ϊ��"+sb.toString());
			System.out.println("��ȡ�ͻ��˷��͹�����������ϣ�");
			OutputStream out=socket.getOutputStream();
			out.write("���ѽ���ǣ�".getBytes());
			System.out.println("��ͻ��˻���������ϣ�");
			
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

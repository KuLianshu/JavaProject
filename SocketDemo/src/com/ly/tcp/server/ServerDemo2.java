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
			//�ڿͻ������ӽ���֮ǰ��accept()����һֱ��������״̬
			System.out.println("�������˿�ʼ������");
			socket=serverSocket.accept();
			String clientIp=socket.getInetAddress().getHostAddress();
			int clientPort=socket.getPort();
			System.out.println("�ͻ���"+clientIp+":"+clientPort+"���ӳɹ���");
			InputStream inputStream=socket.getInputStream();
			byte[]buffer=new byte[1024];
			int len=0;
			StringBuilder sb=new StringBuilder();
			//read()��û�ж�������֮ǰҲ�Ǵ�������״̬��
			while((len=inputStream.read(buffer))!=-1) {
				String str=new String(buffer,0,len);
				sb.append(str);
				System.out.println("�ͻ��˷��͵����ݣ�"+sb.toString());
				//�ͻ��˷���������ϵı��
				if(str.contains("over")) {
					break;
				}
			}
			
			System.out.println("��ȡ�ͻ��˷��͹�����������ϣ�");
			OutputStream outputStream=socket.getOutputStream();
			System.out.println("��ͻ��˻ش����ݣ�");
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

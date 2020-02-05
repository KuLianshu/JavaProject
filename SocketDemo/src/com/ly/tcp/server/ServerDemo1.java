package com.ly.tcp.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ��ķ������˳����д
 * @author Weiliyuan
 *
 */
public class ServerDemo1 {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null;
		try {
			//ʵ�����׽��ֲ�ָ�������˿�
			serverSocket=new ServerSocket(2019);
			System.out.println("�����׽���ʵ�����ɹ���");
			//���ü����׽��ֵ�accept�����ȴ��ͻ��˵����ӣ����û�пͻ��˽������ӣ��������������
			//ֱ���пͻ������ӹ��������������������ͨѶ�׽���
			socket=serverSocket.accept();
			//��ȡ���ӹ����Ŀͻ��˵�IP��ַ
			String clientIp=socket.getInetAddress().getHostAddress();
			//��ȡ���ӹ����Ŀͻ��˵Ķ˿ں�
			int clientPort=socket.getPort();
			System.out.println("�ͻ���"+clientIp+":"+clientPort+"���ӳɹ���");
			//����ͬѧ�׽��ֵõ�����������������ڶ�ȡ�ͻ��˷��͹��������ݻ�����ͻ��˷�������
			InputStream inputStream =socket.getInputStream();
			byte[]buffer=new byte[1024];
			int len=0;
			while((len=inputStream.read(buffer))!=-1) {
				System.out.println(new String(buffer,0,len));
			}
			System.out.println("��ȡ�ͻ��˷��͹�����������ϣ�");
			
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

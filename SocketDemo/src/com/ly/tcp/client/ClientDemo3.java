package com.ly.tcp.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo3 {

	public static void main(String[] args) {
		Socket socket=null;
		try {
			socket=new Socket(InetAddress.getLocalHost(),8000);
			OutputStream out=socket.getOutputStream();
			out.write("����ˣ����������ˣ�".getBytes());
			out.write("����ˣ������������ˣ�".getBytes());
			//�����������һ��������ǣ����߷����������Ѿ�д����
			socket.shutdownOutput();
			System.out.println("�ͻ�����������˷������ݳɹ���");
			InputStream in=socket.getInputStream();
			StringBuilder sb=new StringBuilder();
			byte []buffer=new byte[1024];
			int len=0;
			while((len=in.read(buffer))!=-1){
				sb.append(new String(buffer,0,len));
			}
			System.out.println("��ȡ�������˷��͹���������Ϊ��"+sb.toString());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
		}
		
	}

}

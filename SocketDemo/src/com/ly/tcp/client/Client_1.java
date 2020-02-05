package com.ly.tcp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client_1 {
	
	public static void main(String args[]) {
		String []mess= {"��һ����Ϣ","�ڶ�����Ϣ","��������Ϣ"};
		Socket mySocket=null;
		DataInputStream in=null;
		DataOutputStream out=null;
		
		try {
			//127.0.0.1�Ƿ�������IP��2010�Ƕ˿ں�
			mySocket=new Socket("127.0.0.1",2010);
			in=new DataInputStream(mySocket.getInputStream());
			out=new DataOutputStream(mySocket.getOutputStream());
			for(int i=0;i<mess.length;i++) {
				out.writeUTF(mess[i]);
				String s=in.readUTF();
				System.out.println("�ͻ����յ��������Ļش�"+s);
				Thread.sleep(500);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ѶϿ�"+e);
		}finally {
			if(mySocket!=null) {
				try {
					mySocket.close();
					mySocket=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}

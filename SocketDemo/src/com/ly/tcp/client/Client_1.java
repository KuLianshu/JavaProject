package com.ly.tcp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client_1 {
	
	public static void main(String args[]) {
		String []mess= {"第一条信息","第二条信息","第三条信息"};
		Socket mySocket=null;
		DataInputStream in=null;
		DataOutputStream out=null;
		
		try {
			//127.0.0.1是服务器的IP，2010是端口号
			mySocket=new Socket("127.0.0.1",2010);
			in=new DataInputStream(mySocket.getInputStream());
			out=new DataOutputStream(mySocket.getOutputStream());
			for(int i=0;i<mess.length;i++) {
				out.writeUTF(mess[i]);
				String s=in.readUTF();
				System.out.println("客户端收到服务器的回答："+s);
				Thread.sleep(500);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务器已断开"+e);
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

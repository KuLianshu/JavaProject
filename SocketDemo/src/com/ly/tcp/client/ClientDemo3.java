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
			out.write("服务端，哥们我来了！".getBytes());
			out.write("服务端，哥们我又来了！".getBytes());
			//向服务器发送一个结束标记，告诉服务器，我已经写完了
			socket.shutdownOutput();
			System.out.println("客户端向服务器端发送数据成功！");
			InputStream in=socket.getInputStream();
			StringBuilder sb=new StringBuilder();
			byte []buffer=new byte[1024];
			int len=0;
			while((len=in.read(buffer))!=-1){
				sb.append(new String(buffer,0,len));
			}
			System.out.println("读取服务器端发送过来的数据为："+sb.toString());
			
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

package com.ly.tcp.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo5 {
	
	private static ServerSocket server=null;
	private static Socket socket=null;
	private static InputStream in=null;
	private static OutputStream out=null;


	public static void main(String[] args) {
		try {
			server=new ServerSocket(8000);
			new Thread(new Runnable() {

				@Override
				public void run() {
					while(true) {
						try {
							System.out.println("服务端正在监听...");
							socket=server.accept();
							System.out.println("客户端"+socket.getRemoteSocketAddress().toString()+"成功连接！");
							new Thread(new Runnable() {

								@Override
								public void run() {
									try {
										in=socket.getInputStream();
										out=socket.getOutputStream();
										readData(in);
										writeData(out);
										
									} catch (IOException e) {
										e.printStackTrace();
										System.out.println("--------error--------");
									}finally {
										close(in,out,socket);
									}
								}}).start();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				
			}).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void readData(InputStream in) throws IOException{
		int len;
		byte[]buffer=new byte[1024];
		System.out.println("before read ...");
		while((len=in.read(buffer))!=-1) {
			System.out.println("content="+new String(buffer,0,len));
		}
		System.out.println("after read ...");
	}
	
	private static void writeData(OutputStream out) throws IOException{
		out.write("hello".getBytes());
	}
	
	
	private static void close(InputStream in,OutputStream out,Socket socket) {
		if(in!=null) {
			try {
				in.close();
				in=null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(out!=null) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------finally------");
	}
	

}

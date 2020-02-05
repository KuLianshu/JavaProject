package com.ly.tcp.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo5 {
	
	private static Socket socket;
	private static InputStream in=null;
	private static OutputStream out=null;
	private static Scanner scanner=null;
	
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					socket=new Socket("192.168.43.203",8000);
					in=socket.getInputStream();
					out=socket.getOutputStream();
					scanner= new Scanner(System.in);
					writeData(out);
					readData(in);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					close(in,out,socket);
				}
		}}).start();
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
	
	private static void writeData(OutputStream out) throws IOException {
		System.out.println("请输入数据，输入完成后按回车！");
		while (true) {
			String content = scanner.nextLine();
			out.write(content.getBytes());
			System.out.println("客户端向服务器发送数据成功！");
			// 数据发送完毕的标记
			if ("over".contains(content)) {
				break;
			}
		}
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
		
//		try {
//			socket.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("----------finally------");
	}

}

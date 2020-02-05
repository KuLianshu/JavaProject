package com.ly.tcp.servicer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 创建话务员
 * @author Weiliyuan
 *
 */
public class Servicer1 implements Runnable{
	
	private String clientIP;
	
	private int clientPort;
	
	/**
	 * 读取客户端发送过来的数据的缓存流对象
	 */
	private BufferedReader bufferReader_net_in;
	
	/**
	 * 声明打印流对象用来向客户端发送数据
	 */
	private PrintWriter printWriter_net_out;
	private BufferedReader bufferedReader_keyBoard=null;
	
	private Socket socket;
	
	public Servicer1(Socket socket) {
		if(socket!=null) {
			this.socket=socket;
			clientIP=socket.getInetAddress().getHostAddress();
			clientPort=socket.getPort();
			System.out.println("客户端"+clientIP+":"+clientPort+"进入聊天室！");
		}
		
	}
	

	@Override
	public void run() {
		String content=null;
		try {
			bufferedReader_keyBoard=new BufferedReader(new InputStreamReader(System.in));
			bufferReader_net_in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter_net_out=new PrintWriter(socket.getOutputStream());
			while((content=bufferReader_net_in.readLine())!=null) {
				if("over".contains(content)) {
					System.out.println("客户端"+clientIP+":"+clientPort+"离开聊天室！");
				}
				System.out.println("客户端发送过来的信息："+content);
				System.out.println("请输入向客户端发送的信息：");
				System.out.println("111111111------------");
//				String line=bufferedReader_keyBoard.readLine();
				System.out.println("-------------------------2");
				printWriter_net_out.println("你好！");
				System.out.println("-------------------------3");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedReader_keyBoard!=null) {
				try {
					bufferedReader_keyBoard.close();
					bufferedReader_keyBoard=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bufferReader_net_in!=null) {
				try {
					bufferReader_net_in.close();
					bufferReader_net_in=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
			
			if(printWriter_net_out!=null) {
				printWriter_net_out.close();
				printWriter_net_out=null;
			}
			
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

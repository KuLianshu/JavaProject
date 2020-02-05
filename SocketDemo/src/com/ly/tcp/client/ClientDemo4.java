package com.ly.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo4 {

	public static void main(String[] args) {
		BufferedReader bufferedReader_keyBoard=null;
		BufferedReader bufferedReader_net=null;
		PrintWriter printWriter_net_out=null;

		Socket socket=null;
		try {
			bufferedReader_keyBoard=new BufferedReader(new InputStreamReader(System.in));
			socket=new Socket(InetAddress.getLocalHost(),8000);
			printWriter_net_out=new PrintWriter(socket.getOutputStream(),true);
			bufferedReader_net=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line=null;
			do {
				System.out.println("请输入发送到服务器端的数据（退出请输入over）");
				line=bufferedReader_keyBoard.readLine();
				printWriter_net_out.println(line);
				if("over".contains(line)) {
					break;
				}
				System.out.println("------------------1");
				line=bufferedReader_net.readLine();
				System.out.println("服务器端发送过来的数据："+line);
				System.out.println("------------------2");
			}while(true);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
			
			if(bufferedReader_net!=null) {
				try {
					bufferedReader_net.close();
					bufferedReader_net=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(printWriter_net_out!=null) {
				if(printWriter_net_out!=null) {
					printWriter_net_out.close();
					printWriter_net_out=null;
				}
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

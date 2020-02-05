package com.ly.tcp.domain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo {
	
	
	
	public void main(String[] args) {
		
		MyThread myThread =new MyThread();
		myThread.start();
	}
	
	ServerSocket serverSocket=null;
	public volatile boolean exit=false;
	public class MyThread extends Thread{
		
		@Override
		public void run() {
			super.run();
			Thread thread=null;
			
			while(!exit) {
				try {
					serverSocket=new ServerSocket(8000);
					
					thread=new Thread(new Runnable() {

						@Override
						public void run() {
							Socket socket=null;
							try {
								socket=serverSocket.accept();
							} catch (IOException e) {
								e.printStackTrace();
							}finally {
								try {
									if(socket!=null) {
										socket.close();
										socket=null;
									}
									
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							
						}});
					thread.start();
				} catch (IOException e) {
					e.printStackTrace();
					try {
						if(serverSocket!=null) {
							serverSocket.close();
							serverSocket=null;
						}
						
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
				exit=true;
			}
			

			
		}
		
	}
	

}

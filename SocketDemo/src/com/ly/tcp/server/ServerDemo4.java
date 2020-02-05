package com.ly.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.ly.tcp.servicer.Servicer1;

/**
 * ���ն�������
 * @author Weiliyuan
 *
 */
public class ServerDemo4 {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null;
		try {
			serverSocket=new ServerSocket(8000);
			System.out.println("�������˿�ʼ������");
			
			//�ܹ��ö���ͬʱ���Ϸ�����
			while(true) {
				//�ȴ��ͻ��˵�����
				socket=serverSocket.accept();
				new Thread(new Servicer1(socket)).start();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

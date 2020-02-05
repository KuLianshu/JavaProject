package com.ly.tcp.servicer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * ��������Ա
 * @author Weiliyuan
 *
 */
public class Servicer1 implements Runnable{
	
	private String clientIP;
	
	private int clientPort;
	
	/**
	 * ��ȡ�ͻ��˷��͹��������ݵĻ���������
	 */
	private BufferedReader bufferReader_net_in;
	
	/**
	 * ������ӡ������������ͻ��˷�������
	 */
	private PrintWriter printWriter_net_out;
	private BufferedReader bufferedReader_keyBoard=null;
	
	private Socket socket;
	
	public Servicer1(Socket socket) {
		if(socket!=null) {
			this.socket=socket;
			clientIP=socket.getInetAddress().getHostAddress();
			clientPort=socket.getPort();
			System.out.println("�ͻ���"+clientIP+":"+clientPort+"���������ң�");
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
					System.out.println("�ͻ���"+clientIP+":"+clientPort+"�뿪�����ң�");
				}
				System.out.println("�ͻ��˷��͹�������Ϣ��"+content);
				System.out.println("��������ͻ��˷��͵���Ϣ��");
				System.out.println("111111111------------");
//				String line=bufferedReader_keyBoard.readLine();
				System.out.println("-------------------------2");
				printWriter_net_out.println("��ã�");
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

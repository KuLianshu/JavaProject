package com.ly.tcp.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * ����TCPЭ��Ŀͻ��˳����д
 * @author Weiliyuan
 *
 */

public class ClientDemo1 {

	public static void main(String[] args) {
		Socket socket=null;
		try {
			//ʵ����ͨѶ�׽��ֲ�ָ����������IP��ַ�ͷ��������ڼ����Ķ˿ں�
			socket=new Socket(InetAddress.getLocalHost(),2019);
			//ͨ��ͨѶ�׽��ֵõ�����������������Ӷ���ȡ�������˷��͹��������ݻ������������������
			OutputStream outputStream=socket.getOutputStream();
			outputStream.write("����ˣ��������ˣ�".getBytes());
			System.out.println("�ͻ��������˷������ݳɹ���");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(socket!=null) {
				try {
					//���һ��Ҫ�ǵùر��׽���
					socket.close();
					socket=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

package com.ly.tcp.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",9999);
			BufferedWriter bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in,"UTF-8"));
					
			while(true) {
//				String str = "hello, zhangsan!";
				String str = bufferedReader.readLine();
				bufferedWriter.write(str);
				bufferedWriter.write("\n");
				//�ǵ�ˢ�£����������յ��Ľ���null
				bufferedWriter.flush();
				if("over".equals(str)) {
					break;
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//����ͻ���û�������ر�socket�������˻ᱨ��
			//java.net.SocketException: Connection reset
			if(socket!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

	}

}

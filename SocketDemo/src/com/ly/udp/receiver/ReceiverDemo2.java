package com.ly.udp.receiver;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiverDemo2 {

	public static void main(String[] args) {
		DatagramSocket datagramSocket=null;
		try {
			datagramSocket=new DatagramSocket(8000);
			System.out.println("���շ����ݱ��׽���ʵ�����ɹ���");
			new Thread(new ReceiverRunnable(datagramSocket)).start();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		

	}

}

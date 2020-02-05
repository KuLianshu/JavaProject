package com.ly.udp.sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SenderDemo1 {

	public static void main(String[] args) {
		DatagramSocket datagramSocket=null;

		try {
			//ʵ�������ݱ��׽��ֶ������û��ָ���˿�����������һ���˿�
			datagramSocket=new DatagramSocket();
			System.out.println("���ͷ����ݱ��׽���ʵ�����ɹ���");
			byte[]buffer="���Է��ͷ������ݣ�".getBytes();
			int length=buffer.length;
			InetAddress inetAddress=InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
			int port=8000;
			DatagramPacket datagramPacket=new DatagramPacket(buffer,0,length,inetAddress,port);
			//ʹ�����ݱ��׽��ַ������ݱ������շ�
			datagramSocket.send(datagramPacket);
			System.out.println("���ͷ��������ݳɹ���");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(datagramSocket!=null) {
				datagramSocket.close();
				datagramSocket=null;
			}
		}

	}

}

package com.ly.udp.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiverDemo1 {
	
	public static void main(String[] args) {
		
		DatagramSocket datagramSocket=null;
		try {
			datagramSocket=new DatagramSocket(8000);
			System.out.println("���շ����ݱ��׽���ʵ�����ɹ���");
			
			byte[]buffer=new byte[1024];
			int len=buffer.length;
			DatagramPacket datagramPacket=new DatagramPacket(buffer, len);
			//�����׽��ֵ�receive()�������շ��ͷ����͵�����
			datagramSocket.receive(datagramPacket);
			String sendIp=datagramPacket.getAddress().getHostAddress();
			int sendPort=datagramPacket.getPort();
			System.out.println("�ɹ������˷��ͷ�"+sendIp+":"+sendPort+"���͹���������");
			//�õ����ؽ��շ���IP��ַ
			//datagramSocket.getLocalAddress();
			//�õ����ؽ��շ��Ķ˿ں�
			//datagramSocket.getLocalPort();
			//�������ͷ����͹������ֽ����鲢����õ��ַ���
			byte[]dataBuffer=datagramPacket.getData();
			int length=datagramPacket.getLength();
			String content=new String(dataBuffer,0,length);
			System.out.println("content="+content);
			//������ͷ����͵�����ԶԶС�ڽ��շ�ָ�����ֽ�����Ĵ�С�������������հף��˷ѿؿռ�
			System.out.println("receiveData:"+new String(buffer,0,len));
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

package com.ly.inet_address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo1 {

	public static void main(String[] args) {
		
		try {
			
			//��ȡ����IP��ַ��װ�Ķ���
			InetAddress inetAddress=InetAddress.getLocalHost();
			System.out.println("inetAddress="+inetAddress.toString());
			String ip=inetAddress.getHostAddress();
			System.out.println("ip="+ip);
			String hostName=inetAddress.getHostName();
			System.out.println("hostName="+hostName);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}

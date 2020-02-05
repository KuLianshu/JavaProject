package com.ly.inet_address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo2 {

	public static void main(String[] args) {
		
		
		try {
			
			//根据主机名称返回InetAddress对象
			InetAddress inetAddress=InetAddress.getByName("10.10.156.61");
			System.out.println("inetAddress="+inetAddress);
			String ip=inetAddress.getHostAddress();
			System.out.println("ip="+ip);
			String hostName=inetAddress.getHostName();
			System.out.println("hostName="+hostName);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}

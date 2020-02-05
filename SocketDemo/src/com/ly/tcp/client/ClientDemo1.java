package com.ly.tcp.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 基于TCP协议的客户端程序编写
 * @author Weiliyuan
 *
 */

public class ClientDemo1 {

	public static void main(String[] args) {
		Socket socket=null;
		try {
			//实例化通讯套接字并指定服务器的IP地址和服务器正在监听的端口号
			socket=new Socket(InetAddress.getLocalHost(),2019);
			//通过通讯套接字得到输入流和输出流，从而读取服务器端发送过来的数据或者向服务器发送数据
			OutputStream outputStream=socket.getOutputStream();
			outputStream.write("服务端，哥们来了！".getBytes());
			System.out.println("客户端向服务端发送数据成功！");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(socket!=null) {
				try {
					//最后一定要记得关闭套接字
					socket.close();
					socket=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

package com.ly.tcp.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo2 {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket(InetAddress.getLocalHost(), 8000);
			OutputStream outputStream = socket.getOutputStream();
			System.out.println("请输入数据，输入完成后按回车！");
			while (true) {
				String content = scanner.nextLine();
				outputStream.write(content.getBytes());
				System.out.println("客户端向服务器发送数据成功！");
				// 数据发送完毕的标记
				if ("over".contains(content)) {
					break;
				}
			}
			InputStream inputStream = socket.getInputStream();
			StringBuilder sb = new StringBuilder();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buffer)) != -1) {
				sb.append(new String(buffer, 0, len));
			}
			System.out.println("服务器发送过来的数据：" + sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			if (socket != null) {
				try {
					socket.close();
					socket = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

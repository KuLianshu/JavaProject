package com.ly.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {

	public static void main(String[] args) {
		String path="http://www.hsj.com:80/wcf/qq/index.html?userName=admin&pwd=123#wcf";
		try {
			URL url=new URL(path);
			//�õ�Э��http
			String protocol=url.getProtocol();
			System.out.println("protocol="+protocol);
			//�õ�����www.hsj.com
			String host=url.getHost();
			System.out.println("host="+host);
			//�õ��˿ں�80
			int port=url.getPort();
			System.out.println("port="+port);
			//�õ�·��/wcf/qq/index.html
			String localPath=url.getPath();
			System.out.println("localPath="+localPath);
			//�õ�File /wcf/qq/index.html?userName=admin&pwd=123
			String file=url.getFile();
			System.out.println("file="+file);
			//�õ�ê��wcf
			String ref=url.getRef();
			System.out.println("ref="+ref);
			//�õ�ѯ��userName=admin&pwd=123
			String query=url.getQuery();
			System.out.println("query="+query);
			
			
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}

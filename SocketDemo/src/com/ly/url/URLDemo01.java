package com.ly.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {

	public static void main(String[] args) {
		String path="http://www.hsj.com:80/wcf/qq/index.html?userName=admin&pwd=123#wcf";
		try {
			URL url=new URL(path);
			//得到协议http
			String protocol=url.getProtocol();
			System.out.println("protocol="+protocol);
			//得到域名www.hsj.com
			String host=url.getHost();
			System.out.println("host="+host);
			//得到端口号80
			int port=url.getPort();
			System.out.println("port="+port);
			//得到路径/wcf/qq/index.html
			String localPath=url.getPath();
			System.out.println("localPath="+localPath);
			//得到File /wcf/qq/index.html?userName=admin&pwd=123
			String file=url.getFile();
			System.out.println("file="+file);
			//得到锚点wcf
			String ref=url.getRef();
			System.out.println("ref="+ref);
			//得到询问userName=admin&pwd=123
			String query=url.getQuery();
			System.out.println("query="+query);
			
			
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}

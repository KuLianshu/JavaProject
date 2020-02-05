package com.ly.url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo02 {

	public static void main(String[] args) {
		String path="https://www.baidu.com/img/bd_logo1.png";
		try {
			//实例化URL对象并指定网址
			URL url=new URL(path);
			//获取URLConnection对象
			URLConnection urlConnection=url.openConnection();
			HttpURLConnection httpURLConnection=(HttpURLConnection)urlConnection;
			//设置相关参数
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.setRequestMethod("GET");
			//将用户的请求提交到服务器，同时得到服务器端发送回来的数据
			int responseCode=httpURLConnection.getResponseCode();
			System.out.println("responseCode="+responseCode);
			//表示本次访问服务器并且得到服务器端发送回来的数据
			if(responseCode==200) {
				InputStream inputStream=null;
				OutputStream outputStream=null;
				inputStream=httpURLConnection.getInputStream();
				outputStream=new FileOutputStream("D:\\"+File.separator+"img.png");
				byte[]buffer=new byte[1024];
				int len=0;
				while((len=inputStream.read(buffer))!=-1) {
					outputStream.write(buffer,0,len);
				}
				System.out.println("下载完毕！");
				
				if(inputStream!=null) {
					inputStream.close();
					inputStream=null;
				}
				if(outputStream!=null) {
					outputStream.close();
					outputStream=null;
				}
			}
			
			
	
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

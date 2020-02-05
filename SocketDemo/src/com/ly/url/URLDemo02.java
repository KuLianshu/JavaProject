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
			//ʵ����URL����ָ����ַ
			URL url=new URL(path);
			//��ȡURLConnection����
			URLConnection urlConnection=url.openConnection();
			HttpURLConnection httpURLConnection=(HttpURLConnection)urlConnection;
			//������ز���
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.setRequestMethod("GET");
			//���û��������ύ����������ͬʱ�õ��������˷��ͻ���������
			int responseCode=httpURLConnection.getResponseCode();
			System.out.println("responseCode="+responseCode);
			//��ʾ���η��ʷ��������ҵõ��������˷��ͻ���������
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
				System.out.println("������ϣ�");
				
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

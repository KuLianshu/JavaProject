package com.ly.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SourceCodeViewerDemo {

	public static void main(String[] args) {
		String path="https://www.baidu.com";
		BufferedReader bufferedReader=null;
		
		try {
			URL url=new URL(path);
			InputStream inputStream=url.openStream();
			bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
			String line=null;
			while((line=bufferedReader.readLine())!=null) {
				System.out.println("line="+line);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedReader!=null) {
				try {
					bufferedReader.close();
					bufferedReader=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}

	}

}

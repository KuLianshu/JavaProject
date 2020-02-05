package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamDemo02 {
	
	public static void read() {
		InputStream inputStream=null;
		StringBuilder sb=new StringBuilder();
		try {
			inputStream =new FileInputStream(Constants.path);
			byte[]buffer=new byte[1024];
			int len=0;
			while((len=inputStream.read(buffer))!=-1) {
				sb.append(new String(buffer,0,len));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(inputStream !=null) {
				try {
					inputStream.close();
					inputStream=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("content = "+sb.toString());
		
	}
	
	public static void write() {
		OutputStream outputStream=null;
		try {
			outputStream=new FileOutputStream(Constants.path);
			byte[]buffer="张三".getBytes();
			outputStream.write(buffer);
			System.out.println("数据写入完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(outputStream !=null) {
				try {
					outputStream.close();
					outputStream=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	

}

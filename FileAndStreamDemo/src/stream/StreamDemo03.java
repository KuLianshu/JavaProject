package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamDemo03 {
	
	public static void read() {
		InputStream inputStream =null;
		StringBuilder sb=new StringBuilder();
		try {
			inputStream =new FileInputStream(Constants.path);
			//返回实际需要读取文件的大小，以字节为单位
			int size=inputStream.available();
			System.out.println("size = "+size);
			int len;
			byte[]buffer=new byte[1024];
			while ((len=inputStream.read(buffer))!=-1) {
				sb.append(new String(buffer,0,len));
				sb.append("\n");
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
			//第二个参数代表是否对已经存在的文件进行续写（每次写入数据都在原文件基础上进行添加）
			outputStream=new FileOutputStream(Constants.path,true);
			outputStream.write("你好呀".getBytes());
			outputStream.write("兄弟".getBytes());
			
			System.out.println("数据写入完毕！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(outputStream!=null) {
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

package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamDemo01 {
	
	
	public static void write() {
		byte[]buffer="hello world!".getBytes();
		File file=new File(Constants.path);
		if(file.exists()) {
			file.delete();
		}
		boolean createResult=false;
		try {
			createResult=file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		OutputStream outputStream=null;
		if(createResult) {
			try {
				outputStream=new FileOutputStream(file);
				outputStream.write(buffer);
				System.out.println("数据写入成功！");
				
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
	
	
	public static void read() {
		
		File file=new File(Constants.path);
		StringBuilder sb=new StringBuilder();
		
		if(file.exists()) {
			InputStream inputStream=null;
			try {
				inputStream=new FileInputStream(file);
				
				int i=0;
				while((i=inputStream.read())!=-1) {
					sb.append((char)i);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(inputStream!=null) {
					try {
						inputStream.close();
						inputStream=null;
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
			
		}
		
		System.out.println("content = "+sb.toString());
		
	}
	

}

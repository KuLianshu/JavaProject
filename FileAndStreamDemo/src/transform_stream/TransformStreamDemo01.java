package transform_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import stream.Constants;

/**
 * 
 * @author KuLianshu
 *
 */
public class TransformStreamDemo01 {

	public static void write() {
		
		OutputStreamWriter outputStreamWriter=null;
		try {
			outputStreamWriter=new OutputStreamWriter(new FileOutputStream(Constants.path));
			//获取当前转换流的编码表
			String encoding=outputStreamWriter.getEncoding();
			System.out.println("encoding = "+encoding);
			outputStreamWriter.write("你好呀！");
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(outputStreamWriter!=null) {
				try {
					/*
					 * 如果高级流对低级流进行了包装，则只需要关闭最顶端的高级流，
					 * 其他低级流会自动关闭
					 * 
					 */
					outputStreamWriter.close();
					outputStreamWriter=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	
	public static void read() {
		InputStreamReader inputStreamReader=null;
		try {
			inputStreamReader=new InputStreamReader(new FileInputStream(Constants.path));
//			//获取当前转换流的解码表
//			String decoding=inputStreamReader.getEncoding();
//			System.out.println("encoding = "+decoding);
			int len;
			char[]buffer=new char[1024];
			while((len=inputStreamReader.read(buffer))!=-1) {
				System.out.println(new String(buffer,0,len));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//关闭最高级别的流即可
			if(inputStreamReader !=null) {
				try {
					inputStreamReader.close();
					inputStreamReader=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		
	}
	

}

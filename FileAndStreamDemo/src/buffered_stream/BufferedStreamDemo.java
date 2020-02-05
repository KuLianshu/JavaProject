package buffered_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import stream.Constants;

/**
 *  缓冲流：对现有的流进行封装，并增加了缓冲流的功能，可以提高读写效率
 *  
 * @author KuLianshu
 *
 */
public class BufferedStreamDemo {

	public static void main(String[] args) {
		write();
		read();

	}
	
	private static void read() {
		BufferedInputStream bufferedInputStream=null;
		try {
			bufferedInputStream=new BufferedInputStream(new FileInputStream(Constants.path));
			byte[]buffer=new byte[1024];
			int len;
			while((len=bufferedInputStream.read(buffer))!=-1) {
				System.out.println(new String(buffer,0,len));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedInputStream!=null) {
				try {
					bufferedInputStream.close();
					bufferedInputStream=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void write() {
		BufferedOutputStream bufferedOutputStream=null;
		try {
			bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(Constants.path));
			bufferedOutputStream.write("你好呀！".getBytes());
			bufferedOutputStream.write("虎鲸你好！".getBytes());
			bufferedOutputStream.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedOutputStream!=null) {
				try {
					bufferedOutputStream.close();
					bufferedOutputStream=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	

}

package memory_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 1、内存流
 * 
 * ByteArrayInputStream：从内存中读取数据到程序
 * 
 * ByteArrayOutputStream：将程序分钟的数据写出到内存中
 * 
 * 2、注意：关闭内存流是无效的，因为内存流根本没有调用操作系统的底层功能
 * 
 * 
 * @author KuLianshu
 *
 */
public class MemoryStreamDemo01 {

	public static void main(String[] args) {
		
		read();
		
		
		write();

	}
	
	private static void write() {
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		try {
			//写出数据到内存，其实是写入到了ByteArrayOutputStream类中的一个字节数组中
			byteArrayOutputStream.write("早上好，虎鲸！".getBytes());
			byteArrayOutputStream.write("好想去大海看看虎鲸！".getBytes());
			
			/*
			 * 得到内存中的数据
			 */
			
			//方法一：得到ByteArrayOutputStream 内部的含有写出内容的字节数组并返回
			byte[]buffer=byteArrayOutputStream.toByteArray();
			System.out.println(new String(buffer));
			
			//方法二：使用了默认的编码表，如果读取的内容是图片，这产生乱码，所以
			//使用这种方式必须保证操作的对象是文本数据
			//byteArrayOutputStream.toString(charset):使用指定的编码表将字节数组进行了解码
			String data=byteArrayOutputStream.toString();
			System.out.println("data = "+data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void read() {
		
		byte[]buffer="胖虎，你真的好胖呀".getBytes();
		ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(buffer);
		byte[]buffer_local=new byte[1024];
		int len;
		try {
			while((len=byteArrayInputStream.read(buffer_local))!=-1) {
				System.out.println(new String(buffer_local,0,len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

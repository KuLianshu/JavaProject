package radom_access_file_demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import stream.Constants;

/**
 * 元数据：描述其他数据的数据
 * RandomAccessFile类的使用：这个类可以对指定文件进行随机的读取和写出
 * 1、这个类可以冲文件中读取数据，也可以向文件中写出数据，因为这个类同时实现了DataOutput，DataInput接口
 * 2、使用这个类可以完成对文件的随机读取和写入，因为这类中有以下方法：
 * seek(position)、skipBytes(count)
 * @author KuLianshu
 *
 */
public class RandomAccessFileDemo {

	public static void main(String[] args) {
		
		write();
		
		read();
		
	}
	
	private static void read() {
		String name=null;
		int age=0;
		RandomAccessFile randomAccessFile=null;
		try {
			randomAccessFile=new RandomAccessFile(Constants.path,"r");
			byte[] buffer=new byte[8];
			int len=randomAccessFile.read(buffer);
			name=new String(buffer,0,len);
			age=randomAccessFile.readInt();
			System.out.println("第一个人的信息:"+name+", age:"+age);
			
			//读取第二个人的信息
			buffer=new byte[4];
			len=randomAccessFile.read(buffer);
			name=new String(buffer,0,len);
			age=randomAccessFile.readInt();
			System.out.println("第二个人的信息："+name+","+age);
			
			//读取第三个人的信息
			buffer=new byte[4];
			len=randomAccessFile.read(buffer);
			name=new String(buffer,0,len);
			age=randomAccessFile.readInt();
			System.out.println("第三个人的信息："+name+","+age);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(randomAccessFile!=null) {
				try {
					randomAccessFile.close();
					randomAccessFile=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	private static void write() {
		RandomAccessFile randomAccessFile=null;
		try {
			
			/*
			 * 			 * 1.实例化随机访问文件对象，第一个参数是文件的路径，第二个参数是文件的操作模式：
			 * 		r:以只读模式打开，试图进行任何的写入操作都会报IOException
			 * 		rw:以读写模式打开，如果需要操作的文件不存在，则会自动创建新文件.
			 * 		rws:以读写模式打开文件，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备
			 * 		rwd：以读写模式打开文件，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。
			 */
			randomAccessFile=new RandomAccessFile(Constants.path,"rw");			
			
			//2.执行随机写入操作
			//写出第一人的信息
			//在当前文件中以gbk编码的形式写出字符串,在gbk编码中一个字母占用一个字节，一个汉字占用两个字节
			randomAccessFile.writeBytes("zhangsan");
			randomAccessFile.writeInt(20);
			
			//写出第二个人的信息
			randomAccessFile.writeBytes("lisi");
			randomAccessFile.writeInt(25);
			
			//写出第三个人的信息
			randomAccessFile.write("王五".getBytes());
			randomAccessFile.writeInt(30);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(randomAccessFile!=null) {
				try {
					randomAccessFile.close();
					randomAccessFile=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

}

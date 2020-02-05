package radom_access_file_demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 定位到第几个人的信息其实有公式可代：
 *   第几个人的起始位置：每个人的信息占用的字节数的总长*(第几个人-1);
 * @author dell
 *
 */
public class RandomAccessFileDemo02 {

	public static void main(String[] args) {
		String name=null;
		int age=0;
		RandomAccessFile randomAccessFile=null;
		try {
			//1.实例化随机访问文件对象
			randomAccessFile=new RandomAccessFile("hsj.bak","rw");
			
			//2.写出数据
			/*
			 * 当使用randomAccessFile.writeUTF(数据)写出数据时，采用的编码表是utf-8,在utf-8编码中，一个汉字占3个字节，一个字母占一个字节
			 * 在写出时首先会写出一个unshort（2）数据类型的值，表示将要写出的字符串的长度，后面才是真正字符串的长度
			 * 
			 * 2(表示将要写出字符串长度的unshort数据类型占用的字节数)+utf-8编码的数据的字节长度,
			 * randomAccessFile.writeUTF("张三");其实写出了2+6=8个字节
			 */
			randomAccessFile.writeUTF("张三");//8
			randomAccessFile.writeInt(20);//4
			
			randomAccessFile.writeUTF("lisi");//2+4=6
			randomAccessFile.writeInt(25);//4
			
			randomAccessFile.writeUTF("王五");//2+6=8
			randomAccessFile.writeInt(30);//4
			long filePointer=randomAccessFile.getFilePointer();
			System.out.println("filePointer="+filePointer);
			
			
			//读取第三个人的信息
			randomAccessFile.seek(22);
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			
			System.out.println("第三个人的信息："+name+","+age);
			
			//读取第一个人的信息
			randomAccessFile.seek(0);
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			System.out.println("第一个人的信息："+name+","+age);
			
			//读取第二个人的信息
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			System.out.println("第二个人的信息："+name+","+age);
			
			//修改第三个人的信息
			randomAccessFile.writeUTF("小丽");
			randomAccessFile.writeInt(18);
			
			//读取第二个人的信息
			randomAccessFile.seek(12);
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			System.out.println("第二个人的信息："+name+","+age);
			//读取第三个人的信息
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			System.out.println("第三个人的信息："+name+","+age);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(randomAccessFile!=null){
					//3.关闭随机访问文件对象并释放底层资源
					randomAccessFile.close();
					randomAccessFile=null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

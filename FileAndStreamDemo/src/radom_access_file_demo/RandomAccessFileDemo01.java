package radom_access_file_demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import stream.Constants;

/**
 * randomAccessFile=new RandomAccessFile("hsj.bak","r");
   randomAccessFile.writeBytes("zhangsan");
   以上代码会报如下异常：java.io.IOException: 拒绝访问。
   原因：以只读模式打开的随机访问文件，只能读取，不能写入，否则就会报上面的异常.
   
   
   RandomAccessFile的:
   seek(long pos):
   		A:表示将文件指针定位到pos的指针，需要注意的是：pos是绝对位置，永远从0开始算起.
   		B:文件指针可以向前定位或者向后定位都没有问题，因为它永远相对于0开始计算位置
   
   randomAccessFile.skipBytes(int n):
   	  A:表示跳过的字节数，n是相对于当前位置开始跳过的字节数,
   	  	n为正数表示实际跳过的字节数， 如果为0或者负数表示不跳过任何字节
   	  B:文件指针只能向后跳，不能向前跳

 *
 */
public class RandomAccessFileDemo01 {

	public static void main(String[] args) {
		
		RandomAccessFile randomAccessFile=null;
		try {
			//1.实例化随机访问文件对象
			randomAccessFile=new RandomAccessFile(Constants.path,"rw");
			//将文件指针定位到需要写入内容的位置.
			randomAccessFile.seek(12);
			//写入第二个人的信息
			randomAccessFile.writeBytes("lisi");
			randomAccessFile.writeInt(25);
			long filePointer=randomAccessFile.getFilePointer();
			System.out.println("第二个人的信息写入完毕,当前文件指针为："+filePointer);
			
			//将文件指针定位到文件的开头
			randomAccessFile.seek(0);
			//写入第一个人的信息
			randomAccessFile.writeBytes("zhangsan");
			randomAccessFile.writeInt(20);
			filePointer=randomAccessFile.getFilePointer();
			System.out.println("第一个人的信息写入完毕,当前文件指针为："+filePointer);
			
			//将文件指针定位到第三个人的信息的位置
			randomAccessFile.skipBytes(8);//randomAccessFile.skipBytes(n):如果n为正数，则表示跳过的字节数,如果为0或者负数，表示不跳过任何字节
			//randomAccessFile.seek(20);
			randomAccessFile.write("王五".getBytes());
			randomAccessFile.writeInt(30);
			filePointer=randomAccessFile.getFilePointer();
			System.out.println("第三个人的信息写入完毕,当前文件指针为："+filePointer);
			
			//修改第二个人的信息
			randomAccessFile.seek(12);
			randomAccessFile.writeBytes("xixi");
			randomAccessFile.writeInt(22);
			//读取第二个人的信息
			randomAccessFile.seek(12);
			byte[] buffer=new byte[4];
			int len=randomAccessFile.read(buffer);
			String name=new String(buffer);
			int age=randomAccessFile.readInt();
			System.out.println("name="+name+",age="+age);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(randomAccessFile!=null){
				try {
					//关闭随机访问文件对象并释放底层资源
					randomAccessFile.close();
					randomAccessFile=null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

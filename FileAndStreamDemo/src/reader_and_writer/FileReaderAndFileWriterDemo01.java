package reader_and_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import stream.Constants;

/**
 * 文件流
 * @author KuLianshu
 *
 */
public class FileReaderAndFileWriterDemo01 {
	
	
	public static void read() {
		Reader reader=null;
		try {
			reader=new FileReader(Constants.path);
			
			//一次读取一个字符并返回这个字符对应的数字，可以将这个数字转化成字符，当读取到文件末尾时返回-1
			int ch;
			while((ch=reader.read())!=-1) {
				System.out.println((char)ch);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
					reader=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	public static void write() {
		Writer writer=null;
		try {
			//实例化
//			writer=new FileWriter(Constants.path);
			//第二个参数代表是否对已经存在的文件进行续写（每次写入数据都在原文件基础上进行添加）
			writer=new FileWriter(Constants.path,true);
			/*
			 * 2.将指定的字符串写入到指定文件中，但需要注意的是：内容并没有直接写入到目标设备中，而是先写入到了缓冲区中,
			 * 当缓冲区中被写满后会自动将数据写入到目标设备中，单有时候我们的数据并没有那么多，这是可能随时会需要将缓冲区
			 * 中的数据写入到目标设备中，这是必须手工调用flush():显式刷新缓冲区。马上将缓存区中的数据写入到目标设备中
			 */
			writer.write("去玩吧");
			writer.flush();
			writer.write("今天一起玩");
			writer.flush();
			writer.write("打会儿游戏去");
			
			/*
			 * 总结：
			 * writer.flush()和writer.close()的区别：
			 * 相同点：都会刷新缓冲区
			 * 不同点：
			 * 	A:flush()只刷新缓冲区,close():先刷新缓冲区，然后关闭流对象，释放相关资源
			 *  B:flush()可以被多次调用，实现多次写入数据多次刷新缓冲区的功能，而close():刷新缓冲区后会立即关闭流对象，释放相关资源，之后
			 *  就不能继续写入数据了，否则报异常：java.io.IOException: Stream closed
			 *  
			 */
			
			System.out.println("数据写入成功！");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
					writer=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
	}
	

}







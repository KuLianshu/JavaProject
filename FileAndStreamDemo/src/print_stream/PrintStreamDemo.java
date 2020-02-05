  package print_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import stream.Constants;

/**
 * 打印流的使用：为了能够自动刷新缓冲区，必须使用PrintStream
 * @author KuLianshu
 *
 */
public class PrintStreamDemo {

	public static void main(String[] args) {
//		writePrintStreamWriter();
		writePrintStream();

	}

	/**
	 * 使用printWriter输出数据，如果启用了自动刷新缓存功能，则只有调用了
	 * println、printf或format的其中一个方法时才可能完成此操作
	 */
	private static void writePrintStreamWriter() {
		PrintWriter printWriter=null;
		try {
			
			//实例化对象并管理文件输出流对象，此时这个流不会自动刷新缓冲区
			//printWriter=new PrintWriter(new FileOutputStream(path));
			//实例化对象并关联文件输出流对象
			//第二个参数为true说明启用自动刷新缓冲区功能，false表示禁用自动刷新缓冲区功能
			printWriter=new PrintWriter(new FileOutputStream(Constants.path),true);
			printWriter.println("张三");
			printWriter.print(20);
			printWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(printWriter!=null) {
				printWriter.close();
				printWriter=null;
			}
		}
	}
	
	
	/**
	 * 默认情况下这个流会自动刷新缓冲区
	 */
	private static void writePrintStream() {
		PrintStream printStream=null;
		try {
			printStream=new PrintStream(new FileOutputStream(Constants.path));
			printStream.println("张三");
			printStream.print("来宾");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(printStream!=null) {
				//关闭流并释放底层资源
				printStream.close();
				printStream=null;
			}
		}
	}
	
	
}

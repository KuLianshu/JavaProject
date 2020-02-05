package print_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import stream.Constants;

public class SystemInOutDemo {

	public static void main(String[] args) {
		
		//System.out 默认情况下对应的输出设备是控制台
		//实例化打印流对象并关联上输出设备，当前是控制台
		PrintStream consolePrintStream=new PrintStream(System.out);
		try {
			PrintStream filePrintStream=new PrintStream(new FileOutputStream(Constants.path));
			//重定向输出，将输出流由控制台重定向到文件
			System.setOut(filePrintStream);
			System.out.println("hello world!");
			System.out.println("welcome!");
			System.setOut(consolePrintStream);
			//将输出流由文件重定向到控制台
			System.out.println("end...");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}

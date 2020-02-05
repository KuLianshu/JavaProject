package print_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import stream.Constants;

public class SystemInDemo {

	public static void main(String[] args) {
		
		/*
		 * 将默认情况下对应用户键盘的输入流对象进行保存，方便后续重定向回来，
		 * 如果没有保存，则无法重定向回来
		 */
		InputStream rawInputStream=System.in;
		Scanner scanner=new Scanner(System.in);
		do {
			System.out.print("请输入信息：");
			String name=scanner.next();
			if("quit".equals(name)) {
				break;
			}
			System.out.println("name = "+name);
			
		}while(true);
		
		try {
			FileInputStream fileInputStream=new FileInputStream(Constants.path);
			//重定向输入，将输入设备由用户键盘重定向到了文件输入流
			System.setIn(fileInputStream);
			//当用户重定向输入后需要重新实例化扫描对象
			scanner=new Scanner(System.in);
			//将扫描器的结束符改为换行符
			scanner.useDelimiter("\n");
			while(scanner.hasNext()) {
				String name=scanner.next();
				System.out.println("name = "+name);
			}
			
			System.out.println("================");
			//将输入流由文件输入流重定向回用户键盘
			System.setIn(rawInputStream);
			scanner=new Scanner(System.in);
			do {
				System.out.print("请输入信息：");
				String name=scanner.next();
				if("quit".equals(name)) {
					break;
				}
				System.out.println("name = "+name);
			}while(true);
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		

	}

}

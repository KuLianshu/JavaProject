package print_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import stream.Constants;

public class SystemInOutDemo {

	public static void main(String[] args) {
		
		//System.out Ĭ������¶�Ӧ������豸�ǿ���̨
		//ʵ������ӡ�����󲢹���������豸����ǰ�ǿ���̨
		PrintStream consolePrintStream=new PrintStream(System.out);
		try {
			PrintStream filePrintStream=new PrintStream(new FileOutputStream(Constants.path));
			//�ض����������������ɿ���̨�ض����ļ�
			System.setOut(filePrintStream);
			System.out.println("hello world!");
			System.out.println("welcome!");
			System.setOut(consolePrintStream);
			//����������ļ��ض��򵽿���̨
			System.out.println("end...");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}

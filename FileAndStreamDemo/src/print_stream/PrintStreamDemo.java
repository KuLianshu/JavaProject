  package print_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import stream.Constants;

/**
 * ��ӡ����ʹ�ã�Ϊ���ܹ��Զ�ˢ�»�����������ʹ��PrintStream
 * @author KuLianshu
 *
 */
public class PrintStreamDemo {

	public static void main(String[] args) {
//		writePrintStreamWriter();
		writePrintStream();

	}

	/**
	 * ʹ��printWriter������ݣ�����������Զ�ˢ�»��湦�ܣ���ֻ�е�����
	 * println��printf��format������һ������ʱ�ſ�����ɴ˲���
	 */
	private static void writePrintStreamWriter() {
		PrintWriter printWriter=null;
		try {
			
			//ʵ�������󲢹����ļ���������󣬴�ʱ����������Զ�ˢ�»�����
			//printWriter=new PrintWriter(new FileOutputStream(path));
			//ʵ�������󲢹����ļ����������
			//�ڶ�������Ϊtrue˵�������Զ�ˢ�»��������ܣ�false��ʾ�����Զ�ˢ�»���������
			printWriter=new PrintWriter(new FileOutputStream(Constants.path),true);
			printWriter.println("����");
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
	 * Ĭ���������������Զ�ˢ�»�����
	 */
	private static void writePrintStream() {
		PrintStream printStream=null;
		try {
			printStream=new PrintStream(new FileOutputStream(Constants.path));
			printStream.println("����");
			printStream.print("����");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(printStream!=null) {
				//�ر������ͷŵײ���Դ
				printStream.close();
				printStream=null;
			}
		}
	}
	
	
}

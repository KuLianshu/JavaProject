package print_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import stream.Constants;

public class SystemInDemo {

	public static void main(String[] args) {
		
		/*
		 * ��Ĭ������¶�Ӧ�û����̵�������������б��棬��������ض��������
		 * ���û�б��棬���޷��ض������
		 */
		InputStream rawInputStream=System.in;
		Scanner scanner=new Scanner(System.in);
		do {
			System.out.print("��������Ϣ��");
			String name=scanner.next();
			if("quit".equals(name)) {
				break;
			}
			System.out.println("name = "+name);
			
		}while(true);
		
		try {
			FileInputStream fileInputStream=new FileInputStream(Constants.path);
			//�ض������룬�������豸���û������ض������ļ�������
			System.setIn(fileInputStream);
			//���û��ض����������Ҫ����ʵ����ɨ�����
			scanner=new Scanner(System.in);
			//��ɨ�����Ľ�������Ϊ���з�
			scanner.useDelimiter("\n");
			while(scanner.hasNext()) {
				String name=scanner.next();
				System.out.println("name = "+name);
			}
			
			System.out.println("================");
			//�����������ļ��������ض�����û�����
			System.setIn(rawInputStream);
			scanner=new Scanner(System.in);
			do {
				System.out.print("��������Ϣ��");
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

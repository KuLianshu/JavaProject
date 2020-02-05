package buffered_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import stream.Constants;

public class BufferedStreamDemo01 {

	public static void main(String[] args) {

		write();
		read();

	}
	
	private static void read() {
		BufferedReader bufferedReader=null;
		try {
			bufferedReader=new BufferedReader(new FileReader(Constants.path));
			String str=null;
			while((str=bufferedReader.readLine())!=null) {
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedReader!=null) {
				try {
					bufferedReader.close();
					bufferedReader=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private static void write() {
		BufferedWriter bufferedWriter=null;
		try {
			bufferedWriter=new BufferedWriter(new FileWriter(Constants.path));
			bufferedWriter.write("������ã�");
			//����ݲ���ϵͳ�Ĳ�ͬ���Զ�ѡ���з�����windows��ʹ��\r\n���л��У���Unix����Linux��ʹ��\n����
			bufferedWriter.newLine();
			bufferedWriter.write("�ֻ���ã�");
			//ˢ�»�����
			bufferedWriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedWriter!=null) {
				try {
					bufferedWriter.close();
					bufferedWriter=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	

}

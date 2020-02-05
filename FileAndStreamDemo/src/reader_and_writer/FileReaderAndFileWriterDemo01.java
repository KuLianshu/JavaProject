package reader_and_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import stream.Constants;

/**
 * �ļ���
 * @author KuLianshu
 *
 */
public class FileReaderAndFileWriterDemo01 {
	
	
	public static void read() {
		Reader reader=null;
		try {
			reader=new FileReader(Constants.path);
			
			//һ�ζ�ȡһ���ַ�����������ַ���Ӧ�����֣����Խ��������ת�����ַ�������ȡ���ļ�ĩβʱ����-1
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
			//ʵ����
//			writer=new FileWriter(Constants.path);
			//�ڶ������������Ƿ���Ѿ����ڵ��ļ�������д��ÿ��д�����ݶ���ԭ�ļ������Ͻ�����ӣ�
			writer=new FileWriter(Constants.path,true);
			/*
			 * 2.��ָ�����ַ���д�뵽ָ���ļ��У�����Ҫע����ǣ����ݲ�û��ֱ��д�뵽Ŀ���豸�У�������д�뵽�˻�������,
			 * ���������б�д������Զ�������д�뵽Ŀ���豸�У�����ʱ�����ǵ����ݲ�û����ô�࣬���ǿ�����ʱ����Ҫ��������
			 * �е�����д�뵽Ŀ���豸�У����Ǳ����ֹ�����flush():��ʽˢ�»����������Ͻ��������е�����д�뵽Ŀ���豸��
			 */
			writer.write("ȥ���");
			writer.flush();
			writer.write("����һ����");
			writer.flush();
			writer.write("������Ϸȥ");
			
			/*
			 * �ܽ᣺
			 * writer.flush()��writer.close()������
			 * ��ͬ�㣺����ˢ�»�����
			 * ��ͬ�㣺
			 * 	A:flush()ֻˢ�»�����,close():��ˢ�»�������Ȼ��ر��������ͷ������Դ
			 *  B:flush()���Ա���ε��ã�ʵ�ֶ��д�����ݶ��ˢ�»������Ĺ��ܣ���close():ˢ�»�������������ر��������ͷ������Դ��֮��
			 *  �Ͳ��ܼ���д�������ˣ������쳣��java.io.IOException: Stream closed
			 *  
			 */
			
			System.out.println("����д��ɹ���");
			
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







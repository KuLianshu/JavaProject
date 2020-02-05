package transform_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import stream.Constants;

/**
 * 
 * @author KuLianshu
 *
 */
public class TransformStreamDemo01 {

	public static void write() {
		
		OutputStreamWriter outputStreamWriter=null;
		try {
			outputStreamWriter=new OutputStreamWriter(new FileOutputStream(Constants.path));
			//��ȡ��ǰת�����ı����
			String encoding=outputStreamWriter.getEncoding();
			System.out.println("encoding = "+encoding);
			outputStreamWriter.write("���ѽ��");
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(outputStreamWriter!=null) {
				try {
					/*
					 * ����߼����Եͼ��������˰�װ����ֻ��Ҫ�ر���˵ĸ߼�����
					 * �����ͼ������Զ��ر�
					 * 
					 */
					outputStreamWriter.close();
					outputStreamWriter=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	
	public static void read() {
		InputStreamReader inputStreamReader=null;
		try {
			inputStreamReader=new InputStreamReader(new FileInputStream(Constants.path));
//			//��ȡ��ǰת�����Ľ����
//			String decoding=inputStreamReader.getEncoding();
//			System.out.println("encoding = "+decoding);
			int len;
			char[]buffer=new char[1024];
			while((len=inputStreamReader.read(buffer))!=-1) {
				System.out.println(new String(buffer,0,len));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//�ر���߼����������
			if(inputStreamReader !=null) {
				try {
					inputStreamReader.close();
					inputStreamReader=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		
	}
	

}

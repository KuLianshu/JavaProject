package memory_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 1���ڴ���
 * 
 * ByteArrayInputStream�����ڴ��ж�ȡ���ݵ�����
 * 
 * ByteArrayOutputStream����������ӵ�����д�����ڴ���
 * 
 * 2��ע�⣺�ر��ڴ�������Ч�ģ���Ϊ�ڴ�������û�е��ò���ϵͳ�ĵײ㹦��
 * 
 * 
 * @author KuLianshu
 *
 */
public class MemoryStreamDemo01 {

	public static void main(String[] args) {
		
		read();
		
		
		write();

	}
	
	private static void write() {
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		try {
			//д�����ݵ��ڴ棬��ʵ��д�뵽��ByteArrayOutputStream���е�һ���ֽ�������
			byteArrayOutputStream.write("���Ϻã�������".getBytes());
			byteArrayOutputStream.write("����ȥ�󺣿���������".getBytes());
			
			/*
			 * �õ��ڴ��е�����
			 */
			
			//����һ���õ�ByteArrayOutputStream �ڲ��ĺ���д�����ݵ��ֽ����鲢����
			byte[]buffer=byteArrayOutputStream.toByteArray();
			System.out.println(new String(buffer));
			
			//��������ʹ����Ĭ�ϵı���������ȡ��������ͼƬ����������룬����
			//ʹ�����ַ�ʽ���뱣֤�����Ķ������ı�����
			//byteArrayOutputStream.toString(charset):ʹ��ָ���ı�����ֽ���������˽���
			String data=byteArrayOutputStream.toString();
			System.out.println("data = "+data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void read() {
		
		byte[]buffer="�ֻ�������ĺ���ѽ".getBytes();
		ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(buffer);
		byte[]buffer_local=new byte[1024];
		int len;
		try {
			while((len=byteArrayInputStream.read(buffer_local))!=-1) {
				System.out.println(new String(buffer_local,0,len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

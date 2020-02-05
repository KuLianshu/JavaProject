package radom_access_file_demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import stream.Constants;

/**
 * Ԫ���ݣ������������ݵ�����
 * RandomAccessFile���ʹ�ã��������Զ�ָ���ļ���������Ķ�ȡ��д��
 * 1���������Գ��ļ��ж�ȡ���ݣ�Ҳ�������ļ���д�����ݣ���Ϊ�����ͬʱʵ����DataOutput��DataInput�ӿ�
 * 2��ʹ������������ɶ��ļ��������ȡ��д�룬��Ϊ�����������·�����
 * seek(position)��skipBytes(count)
 * @author KuLianshu
 *
 */
public class RandomAccessFileDemo {

	public static void main(String[] args) {
		
		write();
		
		read();
		
	}
	
	private static void read() {
		String name=null;
		int age=0;
		RandomAccessFile randomAccessFile=null;
		try {
			randomAccessFile=new RandomAccessFile(Constants.path,"r");
			byte[] buffer=new byte[8];
			int len=randomAccessFile.read(buffer);
			name=new String(buffer,0,len);
			age=randomAccessFile.readInt();
			System.out.println("��һ���˵���Ϣ:"+name+", age:"+age);
			
			//��ȡ�ڶ����˵���Ϣ
			buffer=new byte[4];
			len=randomAccessFile.read(buffer);
			name=new String(buffer,0,len);
			age=randomAccessFile.readInt();
			System.out.println("�ڶ����˵���Ϣ��"+name+","+age);
			
			//��ȡ�������˵���Ϣ
			buffer=new byte[4];
			len=randomAccessFile.read(buffer);
			name=new String(buffer,0,len);
			age=randomAccessFile.readInt();
			System.out.println("�������˵���Ϣ��"+name+","+age);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(randomAccessFile!=null) {
				try {
					randomAccessFile.close();
					randomAccessFile=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	private static void write() {
		RandomAccessFile randomAccessFile=null;
		try {
			
			/*
			 * 			 * 1.ʵ������������ļ����󣬵�һ���������ļ���·�����ڶ����������ļ��Ĳ���ģʽ��
			 * 		r:��ֻ��ģʽ�򿪣���ͼ�����κε�д��������ᱨIOException
			 * 		rw:�Զ�дģʽ�򿪣������Ҫ�������ļ������ڣ�����Զ��������ļ�.
			 * 		rws:�Զ�дģʽ���ļ������� "rw"����Ҫ����ļ������ݻ�Ԫ���ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸
			 * 		rwd���Զ�дģʽ���ļ������� "rw"����Ҫ����ļ����ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸��
			 */
			randomAccessFile=new RandomAccessFile(Constants.path,"rw");			
			
			//2.ִ�����д�����
			//д����һ�˵���Ϣ
			//�ڵ�ǰ�ļ�����gbk�������ʽд���ַ���,��gbk������һ����ĸռ��һ���ֽڣ�һ������ռ�������ֽ�
			randomAccessFile.writeBytes("zhangsan");
			randomAccessFile.writeInt(20);
			
			//д���ڶ����˵���Ϣ
			randomAccessFile.writeBytes("lisi");
			randomAccessFile.writeInt(25);
			
			//д���������˵���Ϣ
			randomAccessFile.write("����".getBytes());
			randomAccessFile.writeInt(30);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(randomAccessFile!=null) {
				try {
					randomAccessFile.close();
					randomAccessFile=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

}

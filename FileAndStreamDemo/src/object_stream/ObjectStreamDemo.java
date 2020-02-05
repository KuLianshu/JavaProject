package object_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import entity.Person;
import stream.Constants;

/**
 * �õ�ǰ��ʵ��Serializable�ӿڣ�Ŀ����Ϊ�˽������Ķ���������л�.
 * ���л������ڴ��еĶ��󱣴浽�洢����(Ӳ��)���߽������紫����Ĺ���
 *  �����л������洢�����еĶ������¼��ص��ڴ�Ĺ���
 * @author KuLianshu
 * 
 * �����ܹ��������л����ֶα�����ʵ������
 * ��̬�ı������������л�
 * transient�ؼ������ε�ʵ������Ҳ���������л�
 *
 */
public class ObjectStreamDemo {

	public static void main(String[] args) {
		
		write();
		read();

	}
	
	private static void read() {
		ObjectInputStream objectInputStream=null;
		try {
			objectInputStream=new ObjectInputStream(new FileInputStream(Constants.path));
			String name=(String)objectInputStream.readObject();
			Date date=(Date)objectInputStream.readObject();
			Person p=(Person)objectInputStream.readObject();
			System.out.println("name="+name+", date="+date+", p="+p.toString());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(objectInputStream!=null) {
				try {
					objectInputStream.close();
					objectInputStream=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void write() {
		ObjectOutputStream objectOutputStream=null;
		try {
			objectOutputStream=new ObjectOutputStream(new FileOutputStream(Constants.path));
			objectOutputStream.writeObject("����");
			objectOutputStream.writeObject(new Date());
			/*
			 * ���Personδ���л������쳣��java.io.NotSerializableException
			 * ԭ�򣺽��ڴ��ж��󱣴浽�洢����(Ӳ��)�Ĺ��̽������л�,һ��������������л�������������ʵ��Serialiazable�ӿ�
			 */
			objectOutputStream.writeObject(new Person("С��"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(objectOutputStream!=null) {
				try {
					objectOutputStream.close();
					objectOutputStream=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

}

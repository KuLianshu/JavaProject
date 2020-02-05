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
 * 让当前类实现Serializable接口，目的是为了将这个类的对象进行序列化.
 * 序列化：将内存中的对象保存到存储介质(硬盘)或者进行网络传输则的过程
 *  反序列化：将存储介质中的对象重新加载到内存的过程
 * @author KuLianshu
 * 
 * 所有能够参与序列化的字段必须是实例变量
 * 静态的变量不参与序列化
 * transient关键字修饰的实例变量也不参与序列化
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
			objectOutputStream.writeObject("张三");
			objectOutputStream.writeObject(new Date());
			/*
			 * 如果Person未序列化，则报异常：java.io.NotSerializableException
			 * 原因：将内存中对象保存到存储介质(硬盘)的过程叫做序列化,一个对象如果想序列化则这个对象必须实现Serialiazable接口
			 */
			objectOutputStream.writeObject(new Person("小丽"));
			
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

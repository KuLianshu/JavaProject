package data_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import stream.Constants;

/**
 * DataInputStream����������������Ҫ�������ṩ�˶�ȡjava�����������ͼ�String�������ݵ�����
 * DataOutputStream���������������Ҫ�������ṩ����Ŀ���豸д��java�����������ͼ���String�������͵�����
 * @author KuLianshu
 * ע��㣺ʹ��DataInputStream ��DataOutputStream���ж�дʱһ��Ҫע����ǣ�
 * ��ȡ��˳������д����˳��һ�£��������ݷ�������
 */
public class DataStreamDemo {

	public static void main(String[] args) {
		
		write();
		read();
		
	}
	
	
	private static void read() {
		DataInputStream dataInputStream=null;
		try {
			dataInputStream=new DataInputStream(new FileInputStream(Constants.path));
			byte b=dataInputStream.readByte();
			short s=dataInputStream.readShort();
			int i=dataInputStream.readInt();
			String str=dataInputStream.readUTF();
			System.out.println("b="+b+", s="+s+", i="+i+" str="+str);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(dataInputStream!=null) {
				try {
					dataInputStream.close();
					dataInputStream=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	private static void write() {
		DataOutputStream dataOutputStream=null;
		try {
			dataOutputStream=new DataOutputStream(new FileOutputStream(Constants.path));
			dataOutputStream.write(5);
			dataOutputStream.writeShort(10);
			dataOutputStream.writeInt(15);
			dataOutputStream.writeUTF("������ĳ��ɰ���");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(dataOutputStream!=null) {
				try {
					dataOutputStream.close();
					dataOutputStream=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	

}

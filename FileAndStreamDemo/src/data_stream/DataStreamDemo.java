package data_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import stream.Constants;

/**
 * DataInputStream：数据输入流，主要给我们提供了读取java基本数据类型及String类型数据的能力
 * DataOutputStream：数据输出流，主要给我们提供了向目标设备写出java基本数据类型及其String数据类型的能力
 * @author KuLianshu
 * 注意点：使用DataInputStream 和DataOutputStream进行读写时一定要注意的是，
 * 读取的顺序必须和写出的顺序一致，否则数据发生错乱
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
			dataOutputStream.writeUTF("虎鲸真的超可爱！");
			
			
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

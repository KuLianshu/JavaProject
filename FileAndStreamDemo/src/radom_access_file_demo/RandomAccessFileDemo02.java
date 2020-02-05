package radom_access_file_demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��λ���ڼ����˵���Ϣ��ʵ�й�ʽ�ɴ���
 *   �ڼ����˵���ʼλ�ã�ÿ���˵���Ϣռ�õ��ֽ������ܳ�*(�ڼ�����-1);
 * @author dell
 *
 */
public class RandomAccessFileDemo02 {

	public static void main(String[] args) {
		String name=null;
		int age=0;
		RandomAccessFile randomAccessFile=null;
		try {
			//1.ʵ������������ļ�����
			randomAccessFile=new RandomAccessFile("hsj.bak","rw");
			
			//2.д������
			/*
			 * ��ʹ��randomAccessFile.writeUTF(����)д������ʱ�����õı������utf-8,��utf-8�����У�һ������ռ3���ֽڣ�һ����ĸռһ���ֽ�
			 * ��д��ʱ���Ȼ�д��һ��unshort��2���������͵�ֵ����ʾ��Ҫд�����ַ����ĳ��ȣ�������������ַ����ĳ���
			 * 
			 * 2(��ʾ��Ҫд���ַ������ȵ�unshort��������ռ�õ��ֽ���)+utf-8��������ݵ��ֽڳ���,
			 * randomAccessFile.writeUTF("����");��ʵд����2+6=8���ֽ�
			 */
			randomAccessFile.writeUTF("����");//8
			randomAccessFile.writeInt(20);//4
			
			randomAccessFile.writeUTF("lisi");//2+4=6
			randomAccessFile.writeInt(25);//4
			
			randomAccessFile.writeUTF("����");//2+6=8
			randomAccessFile.writeInt(30);//4
			long filePointer=randomAccessFile.getFilePointer();
			System.out.println("filePointer="+filePointer);
			
			
			//��ȡ�������˵���Ϣ
			randomAccessFile.seek(22);
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			
			System.out.println("�������˵���Ϣ��"+name+","+age);
			
			//��ȡ��һ���˵���Ϣ
			randomAccessFile.seek(0);
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			System.out.println("��һ���˵���Ϣ��"+name+","+age);
			
			//��ȡ�ڶ����˵���Ϣ
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			System.out.println("�ڶ����˵���Ϣ��"+name+","+age);
			
			//�޸ĵ������˵���Ϣ
			randomAccessFile.writeUTF("С��");
			randomAccessFile.writeInt(18);
			
			//��ȡ�ڶ����˵���Ϣ
			randomAccessFile.seek(12);
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			System.out.println("�ڶ����˵���Ϣ��"+name+","+age);
			//��ȡ�������˵���Ϣ
			name=randomAccessFile.readUTF();
			age=randomAccessFile.readInt();
			System.out.println("�������˵���Ϣ��"+name+","+age);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(randomAccessFile!=null){
					//3.�ر���������ļ������ͷŵײ���Դ
					randomAccessFile.close();
					randomAccessFile=null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

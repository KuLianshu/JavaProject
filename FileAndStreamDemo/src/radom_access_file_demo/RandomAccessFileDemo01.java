package radom_access_file_demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import stream.Constants;

/**
 * randomAccessFile=new RandomAccessFile("hsj.bak","r");
   randomAccessFile.writeBytes("zhangsan");
   ���ϴ���ᱨ�����쳣��java.io.IOException: �ܾ����ʡ�
   ԭ����ֻ��ģʽ�򿪵���������ļ���ֻ�ܶ�ȡ������д�룬����ͻᱨ������쳣.
   
   
   RandomAccessFile��:
   seek(long pos):
   		A:��ʾ���ļ�ָ�붨λ��pos��ָ�룬��Ҫע����ǣ�pos�Ǿ���λ�ã���Զ��0��ʼ����.
   		B:�ļ�ָ�������ǰ��λ�������λ��û�����⣬��Ϊ����Զ�����0��ʼ����λ��
   
   randomAccessFile.skipBytes(int n):
   	  A:��ʾ�������ֽ�����n������ڵ�ǰλ�ÿ�ʼ�������ֽ���,
   	  	nΪ������ʾʵ���������ֽ����� ���Ϊ0���߸�����ʾ�������κ��ֽ�
   	  B:�ļ�ָ��ֻ���������������ǰ��

 *
 */
public class RandomAccessFileDemo01 {

	public static void main(String[] args) {
		
		RandomAccessFile randomAccessFile=null;
		try {
			//1.ʵ������������ļ�����
			randomAccessFile=new RandomAccessFile(Constants.path,"rw");
			//���ļ�ָ�붨λ����Ҫд�����ݵ�λ��.
			randomAccessFile.seek(12);
			//д��ڶ����˵���Ϣ
			randomAccessFile.writeBytes("lisi");
			randomAccessFile.writeInt(25);
			long filePointer=randomAccessFile.getFilePointer();
			System.out.println("�ڶ����˵���Ϣд�����,��ǰ�ļ�ָ��Ϊ��"+filePointer);
			
			//���ļ�ָ�붨λ���ļ��Ŀ�ͷ
			randomAccessFile.seek(0);
			//д���һ���˵���Ϣ
			randomAccessFile.writeBytes("zhangsan");
			randomAccessFile.writeInt(20);
			filePointer=randomAccessFile.getFilePointer();
			System.out.println("��һ���˵���Ϣд�����,��ǰ�ļ�ָ��Ϊ��"+filePointer);
			
			//���ļ�ָ�붨λ���������˵���Ϣ��λ��
			randomAccessFile.skipBytes(8);//randomAccessFile.skipBytes(n):���nΪ���������ʾ�������ֽ���,���Ϊ0���߸�������ʾ�������κ��ֽ�
			//randomAccessFile.seek(20);
			randomAccessFile.write("����".getBytes());
			randomAccessFile.writeInt(30);
			filePointer=randomAccessFile.getFilePointer();
			System.out.println("�������˵���Ϣд�����,��ǰ�ļ�ָ��Ϊ��"+filePointer);
			
			//�޸ĵڶ����˵���Ϣ
			randomAccessFile.seek(12);
			randomAccessFile.writeBytes("xixi");
			randomAccessFile.writeInt(22);
			//��ȡ�ڶ����˵���Ϣ
			randomAccessFile.seek(12);
			byte[] buffer=new byte[4];
			int len=randomAccessFile.read(buffer);
			String name=new String(buffer);
			int age=randomAccessFile.readInt();
			System.out.println("name="+name+",age="+age);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(randomAccessFile!=null){
				try {
					//�ر���������ļ������ͷŵײ���Դ
					randomAccessFile.close();
					randomAccessFile=null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

package buffered_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �����û�����¼��
 * @author KuLianshu
 *
 */
public class BufferedStreamDemo02 {

	public static void main(String[] args) {
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		
		String str=null;
		do {
			System.out.println("��������Ϣ��");
			//����ʽ���������û�н��յ����ݣ�����������ᴦ������״̬��ֱ���յ����ݺ�Ż���������������
			try {
				str=bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if("exit".equals(str)) {
				break;
			}
			System.out.println("content = "+str);
			
		}while(true);
		

	}
	
	

}

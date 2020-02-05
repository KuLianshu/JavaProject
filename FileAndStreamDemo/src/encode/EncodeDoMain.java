package encode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * �ַ�= �ֽ�+�����
 * 
 * ���룺���ַ�ת�����ֽڵĹ���
 * ���룺���ֽ�ת�����ַ��Ĺ���
 * 
 * ���������ԭ�򣺱���ͽ��������ʹ�õĲ���ͬһ�������
 * @author KuLianshu
 *
 */
public class EncodeDoMain {

	public static void main(String[] args) {
		encode();

	}
	
	
	public static void encode() {
		String str="������ͽ����������";
		//�Ը������ַ����б��룻str.getBytes()ʹ�õ���Ĭ�ϱ��룬��ǰ�����Ļ���������ʹ�õ���GBK�����
		byte[]buffer=str.getBytes();
		System.out.println("buffer = "+Arrays.toString(buffer));
		try {
		    //ʹ��utf-8����
			buffer=str.getBytes("utf-8");
			System.out.println("buffer = "+Arrays.toString(buffer));
			//�Եõ����ֽ��н��룬ͬʱָ�������
			String newStr=new String(buffer,"utf-8");
			System.out.println("newStr = "+newStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}

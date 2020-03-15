package domain;

import entity.Person;

/**
 * ���Ը�����ģ��ʵ��������Object obj=��ģ�����.newInstance();
 * ��ģ���Ӧ�Ķ�����ֽ����ļ��б������޲ι��캯���������쳣��
 * @author KuLianshu
 *
 */
public class ReflectDemo02 {

	public static void main(String[] args) {
		try {
			Class clz=Class.forName("entity.Person");
			System.out.println("clz = "+clz);
			Object obj=clz.newInstance();
			System.out.println("obj = "+obj);
			System.out.println(obj instanceof Person);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		

	}

}

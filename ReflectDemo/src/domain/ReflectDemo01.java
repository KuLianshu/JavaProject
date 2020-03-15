package domain;

import entity.Person;

/**
 * 
/**
 * ��ȡ��ģ��ķ�����
 * 	1. Class cls=������.getClass();//ʹ�����ַ�ʽ��ȡ��ģ���о����ԣ��������ж�����ܵõ���ģ�����
 *  2.Class cls=Class.forName(����+�������ַ���);//��õģ�ֻҪ֪����ȫ�޶���(����+����)�ַ������ɻ�ȡ��ģ�����
 *  3.Class cls=����.class;//���,Ҳ�Ƚϳ��ã�������ָ���������ܻ�ȡ��ģ�����
 *  
 *  ע�⣺
 * ����1��ͬһ�����͵Ķ����ȡ����ģ�������ͬһ������
 * ����2�����ֻ�ȡ��ģ��ķ�ʽ��ͬ����ͬ��ͬһ���͵Ķ����ȡ����ģ����ͬһ������.
 * 
 * ���� ������=new ����();
 * 
 * Person p=new Person();
 * @author KuLianshu
 *
 */
public class ReflectDemo01 {

	public static void main(String[] args) {
		Person p1=new Person();
		Class clz1=p1.getClass();
		System.out.println(clz1);
		try {
			Class clz11=Class.forName("entity.Person");
			System.out.println(clz11);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class clz111=Person.class;
		System.out.println(clz111);
		
		Person p2=new Person();
		Class clz2=p2.getClass();
		System.out.println(clz1);
		try {
			Class clz22=Class.forName("entity.Person");
			System.out.println(clz22);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class clz222=Person.class;
		System.out.println(clz222);
	}

}

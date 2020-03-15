package domain;

import entity.Person;

/**
 * 
/**
 * 获取类模板的方法：
 * 	1. Class cls=对象名.getClass();//使用这种方式获取类模板有局限性：必须现有对象才能得到类模板对象
 *  2.Class cls=Class.forName(包名+类名的字符串);//最常用的，只要知道完全限定名(包名+类名)字符串即可获取类模板对象
 *  3.Class cls=类名.class;//最简单,也比较常用，但必须指定类名才能获取类模板对象
 *  
 *  注意：
 * 结论1：同一种类型的对象获取的类模板对象是同一个对象
 * 结论2：三种获取类模板的方式不同，但同于同一类型的对象获取的类模板是同一个对象.
 * 
 * 类名 对象名=new 类名();
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

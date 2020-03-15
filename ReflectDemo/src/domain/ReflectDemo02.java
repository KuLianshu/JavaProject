package domain;

import entity.Person;

/**
 * 可以根据类模板实例化对象：Object obj=类模板对象.newInstance();
 * 类模板对应的对象的字节码文件中必须有无参构造函数，否则报异常。
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

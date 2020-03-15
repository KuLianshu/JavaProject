package domain;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import entity.Person;

/**
 * 根据类模板对象获取类中指定参数的构造函数
 * @author KuLianshu
 *
 */
public class ReflectDemo07 {

	public static void main(String[] args) {
		Class clz=Person.class;
		try {
			//根据类模板实例化对象
			//调用的是无参构造
			Object obj=clz.newInstance();
			System.out.println("obj = "+obj);
			//得到类中所有的构造函数
			Constructor[]constructors=clz.getConstructors();
			for(Constructor constructor:constructors) {
				int modifier=constructor.getModifiers();
				String strModifier=Modifier.toString(modifier);
				String methodName=constructor.getName();
				Class[]paramTypes=constructor.getParameterTypes();
				System.out.println(strModifier+" "+methodName+" "+paramTypes);
				
			}
			
			//得到带有一个String数据类型参数的构造函数
			Constructor constructor=clz.getConstructor(String.class);
			//调用构造函数
			Object con_obj=constructor.newInstance("Hello");
			Object con_obj2=clz.newInstance();
			System.out.println("con_obj = "+con_obj);
			System.out.println("con_obj2 = "+con_obj2);
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		

	}

}

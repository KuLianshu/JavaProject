package domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.Student;

/**
 * 根据类模板对象获取类中所有的方法（不限属性）
 * @author KuLianshu
 *
 */
public class ReflectDemo06 {

	public static void main(String[] args) {
		
		Class clz=Student.class;
		
		//根据类模板获取本类中所有权限的方法
		Method[] methods=clz.getDeclaredMethods();
		for(Method method:methods) {
			//获取方法的访问修饰符
			int modifer=method.getModifiers();
			String strModifier=Modifier.toString(modifer);
			//获取方法的返回值的数据类型对应的模板对象
			Class returnType=method.getReturnType();
			//获取方法名
			String methodName=method.getName();
			//获取方法参数列表对应的模板类型的对象数组
			Class[] parameterTypes=method.getParameterTypes();
			System.out.println(strModifier+" "+returnType+" "+methodName+" "+parameterTypes);
			
		}
		
		System.out.println("=====================");
		try {
			//第一个参数是方法名，第二个参数是方法参数的数据类型对应的类模板对象的变长数组
			Method method=clz.getDeclaredMethod("printStudent", String.class,int.class);
			Object obj=clz.newInstance();
			//取消java的语法检查
			method.setAccessible(true);
			Object returnType=method.invoke(obj, "Hello",6);
			System.out.println("returnType = "+returnType);
			
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		

	}

}

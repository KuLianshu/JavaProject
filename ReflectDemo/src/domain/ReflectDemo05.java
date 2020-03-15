package domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.Student;

/**
 * 根据类模板对象获取类中所有的方法
 * @author KuLianshu
 *
 */
public class ReflectDemo05 {

	public static void main(String[] args) {
		try {
			Class clz=Class.forName("entity.Student");
			
			//根据类模板获取本类及其父类中所有的公共访问权限的方法
			Method[] methods=clz.getMethods();
			for(Method method:methods) {
				//获取方法的访问修饰符
				int modifer=method.getModifiers();
				String strModifier=Modifier.toString(modifer);
				//获取方法返回值所对应数据类型的模板对象
				Class returnType=method.getReturnType();
				//获取方法名
				String methodName=method.getName();
				//获取方法参数列表所对应模板类型的对象数组
				Class[] parameterTypes=method.getParameterTypes();
				System.out.println(strModifier+" "+returnType+" "+methodName+" "+parameterTypes);
			}
			System.out.println("=====================");
			//第一个参数是方法名，第二个参数是方法参数数据类型所对应的类模板对象数组
			//Method method=clz.getMethod("getMsgStudent", null);
			//所以第二个参数要传String.class
			Method method=clz.getMethod("getMsgStudent", String.class);
			Object obj=clz.newInstance();
			//调用指定的方法
			//在反射中调用方法的格式为：方法对象.invoke(对象名,实际参数值列表);
			Object returnType=method.invoke(obj, "Hello");
			//returnType即为方法返回值
			System.out.println("returnType = "+returnType);
			
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}

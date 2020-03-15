package domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.Student;

/**
 * ������ģ������ȡ�������еķ������������ԣ�
 * @author KuLianshu
 *
 */
public class ReflectDemo06 {

	public static void main(String[] args) {
		
		Class clz=Student.class;
		
		//������ģ���ȡ����������Ȩ�޵ķ���
		Method[] methods=clz.getDeclaredMethods();
		for(Method method:methods) {
			//��ȡ�����ķ������η�
			int modifer=method.getModifiers();
			String strModifier=Modifier.toString(modifer);
			//��ȡ�����ķ���ֵ���������Ͷ�Ӧ��ģ�����
			Class returnType=method.getReturnType();
			//��ȡ������
			String methodName=method.getName();
			//��ȡ���������б��Ӧ��ģ�����͵Ķ�������
			Class[] parameterTypes=method.getParameterTypes();
			System.out.println(strModifier+" "+returnType+" "+methodName+" "+parameterTypes);
			
		}
		
		System.out.println("=====================");
		try {
			//��һ�������Ƿ��������ڶ��������Ƿ����������������Ͷ�Ӧ����ģ�����ı䳤����
			Method method=clz.getDeclaredMethod("printStudent", String.class,int.class);
			Object obj=clz.newInstance();
			//ȡ��java���﷨���
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

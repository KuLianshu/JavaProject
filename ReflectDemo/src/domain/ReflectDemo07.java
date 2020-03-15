package domain;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import entity.Person;

/**
 * ������ģ������ȡ����ָ�������Ĺ��캯��
 * @author KuLianshu
 *
 */
public class ReflectDemo07 {

	public static void main(String[] args) {
		Class clz=Person.class;
		try {
			//������ģ��ʵ��������
			//���õ����޲ι���
			Object obj=clz.newInstance();
			System.out.println("obj = "+obj);
			//�õ��������еĹ��캯��
			Constructor[]constructors=clz.getConstructors();
			for(Constructor constructor:constructors) {
				int modifier=constructor.getModifiers();
				String strModifier=Modifier.toString(modifier);
				String methodName=constructor.getName();
				Class[]paramTypes=constructor.getParameterTypes();
				System.out.println(strModifier+" "+methodName+" "+paramTypes);
				
			}
			
			//�õ�����һ��String�������Ͳ����Ĺ��캯��
			Constructor constructor=clz.getConstructor(String.class);
			//���ù��캯��
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

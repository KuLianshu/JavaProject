package domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.Student;

/**
 * ������ģ������ȡ�������еķ���
 * @author KuLianshu
 *
 */
public class ReflectDemo05 {

	public static void main(String[] args) {
		try {
			Class clz=Class.forName("entity.Student");
			
			//������ģ���ȡ���༰�丸�������еĹ�������Ȩ�޵ķ���
			Method[] methods=clz.getMethods();
			for(Method method:methods) {
				//��ȡ�����ķ������η�
				int modifer=method.getModifiers();
				String strModifier=Modifier.toString(modifer);
				//��ȡ��������ֵ����Ӧ�������͵�ģ�����
				Class returnType=method.getReturnType();
				//��ȡ������
				String methodName=method.getName();
				//��ȡ���������б�����Ӧģ�����͵Ķ�������
				Class[] parameterTypes=method.getParameterTypes();
				System.out.println(strModifier+" "+returnType+" "+methodName+" "+parameterTypes);
			}
			System.out.println("=====================");
			//��һ�������Ƿ��������ڶ��������Ƿ�������������������Ӧ����ģ���������
			//Method method=clz.getMethod("getMsgStudent", null);
			//���Եڶ�������Ҫ��String.class
			Method method=clz.getMethod("getMsgStudent", String.class);
			Object obj=clz.newInstance();
			//����ָ���ķ���
			//�ڷ����е��÷����ĸ�ʽΪ����������.invoke(������,ʵ�ʲ���ֵ�б�);
			Object returnType=method.invoke(obj, "Hello");
			//returnType��Ϊ��������ֵ
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

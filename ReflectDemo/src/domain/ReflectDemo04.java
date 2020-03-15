package domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * ������ģ������ȡ������ֶ���Ϣ
 * @author KuLianshu
 *��ȡ������ԣ�
 Filed��----c.getFiled(String pname)  ���ָ�����ԣ������ֶΣ�
 Filed��----c.getDeclearedFiled(String pname)  ���ָ�����ԣ������е�����Ȩ���ֶ�,�����������е��ֶ���Ϣ��
 Filed[]----c.getFileds()  ����������ԣ������ֶ�)�������༰�丸���е����й����ֶ���Ϣ
 Filed[]----c.getDeclearedFileds()  ����������ԣ�����Ȩ���ֶ�)ֻ���������е��ֶ���Ϣ�������������е��ֶ���Ϣ.
 */
public class ReflectDemo04 {

	public static void main(String[] args) {
		try {
			Class clz=Class.forName("entity.Student");
			//ֻ��ȡ�����������ֶΣ�����Ȩ�ޣ�
			Field[]fields=clz.getDeclaredFields();
			for(Field field:fields) {
				int modifier=field.getModifiers();
				//������Ȩ�޶�Ӧ�����ֻ�ԭ�ɶ�Ӧ���ַ���
				String strModifier=Modifier.toString(modifier);
				Class type_clz=field.getType();
				String fieldName=field.getName();
				System.out.println(strModifier+", "+type_clz+", "+fieldName);
				
			}
			System.out.println("======================");
			//��ȡ������ָ���ֶ������ֶζ���
			Field field=clz.getDeclaredField("stuNo");
			Object obj=clz.newInstance();
			//��ΪstuNo��private���Σ����Ա���ȡ��Java���Ե��﷨��飬��Ȼ����ֵʧ��
			field.setAccessible(true);
			field.set(obj, "007");
			//��ȡ�ֶε�ֵ
			Object fieldValue=field.get(obj);
			System.out.println("fieldValue="+fieldValue);
			System.out.println(Arrays.toString(fields));
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}

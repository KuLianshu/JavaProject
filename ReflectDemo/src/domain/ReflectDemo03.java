package domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectDemo03 {

	public static void main(String[] args) {
		try {
			Class clz=Class.forName("entity.Student");
			//��ȡ���༰�丸�������е�publicȨ�޵��ֶβ��������
			Field []fields=clz.getFields();
			for(Field field:fields) {
				int modifier =field.getModifiers();
				//������Ȩ�޶�Ӧ�����ֻ�ԭ�ɶ�Ӧ���ַ���
				String strModifier=Modifier.toString(modifier);
				//�ֶ�����
				Class type_clz=field.getType();
				//�ֶ�����
				String fieldName=field.getName();
				System.out.println(strModifier+", "+type_clz+", "+fieldName);
			}
			System.out.println("============");
			//�����ֶ�����ȡ�ֶζ���
			Field field=clz.getField("master");
			//��ȡ����
			Object obj=clz.newInstance();
			//���ֶθ�ֵ 
			field.set(obj, "����ʯ");
			//�����ֶλ�ȡָ��������ֶ�ֵ����ȡobj�����е�master�ֶε�ֵ��
			Object fieldValue=field.get(obj);
			System.out.println("fieldValue = "+fieldValue);
			
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

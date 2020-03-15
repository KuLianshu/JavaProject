package domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectDemo03 {

	public static void main(String[] args) {
		try {
			Class clz=Class.forName("entity.Student");
			//获取本类及其父类中所有的public权限的字段并组成数组
			Field []fields=clz.getFields();
			for(Field field:fields) {
				int modifier =field.getModifiers();
				//将访问权限对应的数字还原成对应的字符串
				String strModifier=Modifier.toString(modifier);
				//字段类型
				Class type_clz=field.getType();
				//字段名称
				String fieldName=field.getName();
				System.out.println(strModifier+", "+type_clz+", "+fieldName);
			}
			System.out.println("============");
			//根据字段名获取字段对象
			Field field=clz.getField("master");
			//获取对象
			Object obj=clz.newInstance();
			//给字段赋值 
			field.set(obj, "蒋介石");
			//根据字段获取指定对象的字段值（获取obj对象中的master字段的值）
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

package domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 根据类模板对象获取对象的字段信息
 * @author KuLianshu
 *获取类的属性：
 Filed类----c.getFiled(String pname)  获得指定属性（公共字段）
 Filed类----c.getDeclearedFiled(String pname)  获得指定属性（本类中的所有权限字段,不包括父类中的字段信息）
 Filed[]----c.getFileds()  获得所有属性（公共字段)包括本类及其父类中的所有公有字段信息
 Filed[]----c.getDeclearedFileds()  获得所有属性（所有权限字段)只包括本类中的字段信息，不包括父类中的字段信息.
 */
public class ReflectDemo04 {

	public static void main(String[] args) {
		try {
			Class clz=Class.forName("entity.Student");
			//只获取本类中所有字段（不限权限）
			Field[]fields=clz.getDeclaredFields();
			for(Field field:fields) {
				int modifier=field.getModifiers();
				//将访问权限对应的数字还原成对应的字符串
				String strModifier=Modifier.toString(modifier);
				Class type_clz=field.getType();
				String fieldName=field.getName();
				System.out.println(strModifier+", "+type_clz+", "+fieldName);
				
			}
			System.out.println("======================");
			//获取本类中指定字段名的字段对象
			Field field=clz.getDeclaredField("stuNo");
			Object obj=clz.newInstance();
			//因为stuNo被private修饰，所以必须取消Java语言的语法检查，不然将赋值失败
			field.setAccessible(true);
			field.set(obj, "007");
			//获取字段的值
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

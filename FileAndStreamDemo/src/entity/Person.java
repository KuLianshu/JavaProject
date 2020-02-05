package entity;

import java.io.Serializable;

/**
 * 
 * @author KuLianshu
 *
 */
public class Person implements Serializable{
	
	private String name;
	
	 /* 
	  * transient:͸���ģ����һ��ʵ����������������л��ͷ����еĹ��̣������ʹ������ؼ��ֽ�������
	 */
	private transient String addr;
	
	public Person() {
		
	}
	
	public Person(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	

}

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
	  * transient:透明的，如果一个实例变量不想参与序列化和反序列的过程，则可以使用这个关键字进行修饰
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

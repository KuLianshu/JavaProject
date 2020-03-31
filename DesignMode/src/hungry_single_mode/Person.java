package hungry_single_mode;

/**
 * 单例设计模式中饿汉式的编写步骤：
 * 1、声明一个私有、静态、最终、返回本类类型的对象并实例化
 * 2、构造函数私有化
 * 3、通过公有的静态方法返回本类类型的对象
 * 
 * @author KuLianshu
 *
 */
public class Person {
	
	//声明对象并实例化
	private static final Person instance=new Person();
	
	//构造函数私有化
	private Person() {
		System.out.println("=======Person()======");
	}
	
	//返回对象
	public static Person getInstance() {
		return instance;
	}
	

}

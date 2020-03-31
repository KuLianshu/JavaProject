package hungry_single_mode;

/**
 * 设计模式：解决固定问题的固定方法
 * 单例设计模式：对外只能获取一个对象的设计模式
 * @author KuLianshu
 *
 */
public class TestSingleInstanceDemo01 {

	public static void main(String[] args) {
		
		Person p1=Person.getInstance();
		
		Person p2=Person.getInstance();
		
		System.out.println("p1==p2的值："+(p1==p2));

	}

}

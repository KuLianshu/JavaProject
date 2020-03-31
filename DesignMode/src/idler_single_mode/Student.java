package idler_single_mode;

/**
 * 懒汉式的单例设计模式的编写步骤：
 * 1、声明一个私有、静态、返回本类型的对象
 * 2、构造函数私有化
 * 3、通过公有的静态方法返回本类类型的对象，在返回之前需要判断这个对象是不是
 * 实例化过，如果没有实例化则实例化，否则直接返回
 * @author KuLianshu
 *
 */
public class Student {
	
	//声明一个对象
	private static Student instance;
	
	private Student() {
		System.out.println("======Student()=====");
	}
	
	/**
	 * 
	 * 
	 *
	 *  通过分析：发现这部分代码在多线程条件下会有安全隐患，可以通过给方法加上synchronized来解决安全隐患，但这样一来，
	 *  
	 *  每个线程在调用这个方法是都会先判断当前的锁是不是开着，这样会降低效率.
	 *  发现操作的代码块比较大，怎么想办法既能解决安全问题又能提高效率呢？
	 *  可以尝试使用同步代码块来试试看看。发现只进行一次判断还是不能提高效率，通过研究发现可以通过双重判断来到达目的：即解决安全性问题又提高效率
	 * 
	 */
	//通过公有的静态方法返回本类类型的对象，在返回之前需要判断这个对象是不是实例化过，如果没有实例化过则实例化，实例化过后就直接返回
	public static  /*synchronized*/ Student getInstance() {
		if(instance==null) {
			synchronized(Student.class) {
				if(instance==null) {
					try {
						Thread.sleep(10);
						instance=new Student();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return instance;
	}

}

package my_thread;


/**
 * 
 * @author KuLianshu
 * 在程序开始运行时，JVM会自动帮我们创建一个线程，用来执行我们编写的代码，这个线程叫做主线程。
 * 线程是程序中代码的执行者
 */
public class ThreadDemo01 {

	public static void main(String[] args) {

		Thread currentThread=Thread.currentThread();
		//返回该线程的字符串表示形式，包括线程名称、优先级和线程组:Thread[main,5,main]
		System.out.println("currentThread = "+currentThread);
		System.out.println("currenThreadName = "+currentThread.getName());
		//设置线程名称
		currentThread.setName("主线程");
		
		System.out.println("currenThreadName = "+currentThread.getName());

	}

}

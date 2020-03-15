package my_thread;

/**
 * 
 * @author KuLianshu
 * 
 *  *  多线程的运行具有不确定性:多次运行相同的代码可能得到的执行结果不一样.这是由CPU的切换造成的
 *  
 *  
 *  既然开启子线程有两种方式：继承Thread类和实现Runnable接口，那么这两种方式有什么区别呢？
 *  	相同点：都能开启子线程
 *  	不同点：
 *  		1.如果采用继承Thread类开启子线程，那么由于java对类的单根继承，那么这个类就不能在继承其它类了;
 *  			如果采用实现Runnable接口的方式开启子线程，那么这个类还可以继承其它类.
 *  		2.如果想让多线程访问共享资源，这时如果采用继承Thread类来完成，则会造成多线程无法访问共享资源，因为
 *  		  实例化多个线程时共享资源也被复制了多份，造成不再是共享资源，为了解决这个问题，需要将共享资源静态化，
 *  		 这样一来，虽然能够让多线程访问共享资源了，但共享资源的生命周期被延长了.
 *  		如果采用实现Runnable接口的方式来完成资源共享最好的方式，因为我们只要实例化一个实现了Runnable接口的对象即可，
 *  		多线程实例化时将同一个实现了Runnable接口的对象传递给多个线程即可.
 *  
 *  		综上所述：如果多线程访问共享资源，建议使用实现Runnable接口的方式来完成，因为这是最好的方式.
 *
 */
public class ThreadDemo04 {

	public static void main(String[] args) {
		
		MyRunnable myRunnable=new MyRunnable();
		Thread thread=new Thread(myRunnable);
		thread.start();
		
		String mainThreadName=Thread.currentThread().getName();
		for(int i=0;i<10;i++) {
			System.out.println("main:线程名称为"+mainThreadName+"线程正在输出i="+i);
		}
		

	}
	

	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			String childThreadName=Thread.currentThread().getName();
			for(int i=0;i<10;i++) {
				System.out.println("child:线程名称为"+childThreadName+"线程正在输出i="+i);
			}
			
		}
		
	}

}

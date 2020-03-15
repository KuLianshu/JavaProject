package my_thread;

public class ThreadDemo03 {

	public static void main(String[] args) {
		
		MyThread myThread=new MyThread();
		
		/*
		 *调用myThread对象的start()开启子线程，此时这个线程处于可运行状态（临时阻塞状态），
		 *特点：具有执行资格，但没有执行权。当这个线程被CPU选中并正在执行这个线程run()方法
		 *中的代码时，这个线程处于运行状态，运行状态的特点：具有执行资格，也有执行权。
		 *
		 *在某一个时刻，只有一个线程处于运行状态。
		 *
		 *开启子线程的时候必须调用线程对象的start()方法，不能调用对象的run()方法，因为如果调用
		 *对象的run()方法，因为如果调用线程对象的run()方法就成了普通的方法调用，不会产生子线程
		 *进行运行。
		 *原因是：因为开启子线程需要调用操作系统底层的功能，这部分代码都被封装到了线程对象的start()
		 *方法中，开启子线程需要首先调用操作系统底层的功能。
		 *
		 * 
		 */
		
		//开启子线程；调用run()方法
		myThread.start();
		
		String mainThreadName=Thread.currentThread().getName();
		for(int i=0;i<10;i++) {
			System.out.println("main:线程名称为"+mainThreadName+"线程正在输出i="+i);
		}

	}
	
	
	static class MyThread extends Thread{
		@Override
		public void run() {
			super.run();
			String childThreadName=Thread.currentThread().getName();
			for(int i=0;i<10;i++) {
				System.out.println("chidl:线程名称为"+childThreadName+"线程正在输出="+i);
			}
			
		}
	}

}

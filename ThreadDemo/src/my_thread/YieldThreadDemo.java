package my_thread;

/**
 * 线程的调度
 * 1、线程睡眠：
 * Thread.sleep()：使线程转到阻塞状态，当睡眠结束后，就转为就绪（Runnable）状态
 * 2、线程让步
 * Thread.yield()：暂停当前正在执行的线程对象，把执行机会让给相同或者更高优先级的线程。
 * 3、线程加入
 * join()：在当前线程中调用另一个线程的join()方法，则当前线程转入waiting状态，
 * 直到另一个线程运行结束，则当前线程再由阻塞转为就绪状态
 * 
 * @author KuLianshu
 *
 */
public class YieldThreadDemo {

	public static void main(String[] args) {
		
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"正在输出i="+i);
					//当前线程主动让出CPU使用权，给和它具有相同优先级或者比它优先级更高的线程运行
					Thread.yield();
				}
				
			}
			
		});
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					//当前线程主动让出CPU使用权，给和它具有相同优先级或者比它优先级更高的线程运行
					System.out.println(Thread.currentThread().getName()+"正在输出i="+i);
					Thread.yield();
				}
			}
			
		});
		
		t1.setName("线程一号");
		t2.setName("线程二号");
		
		t1.start();
		t2.start();

	}

}

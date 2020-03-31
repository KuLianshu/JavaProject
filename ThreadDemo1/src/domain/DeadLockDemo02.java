package domain;

/**
 * 
 * 死锁的原因：
 * 线程1锁住资源A等待资源B，线程2锁住资源B等待资源A，
 * 两个线程都在等待自己需要的资源，而这些资源被另外的
 * 线程锁住，这些线程你等我，我等你，谁也不愿意让出资源，
 * 这样死锁就产生了。
 * 
 * 解决死锁的办法之一就是：加大锁的粒度。
 * 
 * 
 * 死锁演示
 * @author KuLianshu
 *
 */
public class DeadLockDemo02 {

	public static void main(String[] args) {
		
		MyRunnable myRunnableA=new MyRunnable();
		MyRunnable myRunnableB=new MyRunnable();
		myRunnableB.flag=false;
		
		Thread t1=new Thread(myRunnableA,"Thread1");
		Thread t2=new Thread(myRunnableB,"Thread2");
		
		t1.start();
		t2.start();
		

	}
	
	static class MyRunnable implements Runnable{
		
		boolean flag=true;
		
		private static Object lockA=new Object();
		private static Object lockB=new Object();
		

		@Override
		public void run() {
			if(flag) {
				synchronized(lockA) {
					System.out.println(Thread.currentThread().getName()+", if......lockA");
					
					try {
						Thread.sleep(1000);
						synchronized(lockB) {
							System.out.println(Thread.currentThread().getName()+", if......lockB");
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}else {
				synchronized(lockB) {
					System.out.println(Thread.currentThread().getName()+", else......lockB");
					try {
						Thread.sleep(1000);
						synchronized(lockA) {
							System.out.println(Thread.currentThread().getName()+", else......lockA");
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
		
	
	

}

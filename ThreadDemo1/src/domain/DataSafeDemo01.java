package domain;

/**
 * 多线程访问共享数据不安全的原因：一个线程还没有执行完自己的代码
 * 就被另一个线程打断造成的（CPU发生了切换）
 * 解决方案：当一个线程还没有执行完自己的代码时另一个线程不能执行
 * 和第一个线程相同的代码。
 * 
 * 实现方式：
 * 		A：同步代码块
 * 			synchronized(监视哨(obj)\锁旗标\锁){
 * 				//写在synchronized所在的花括号中的代码在某一个时刻只能有一个线程进入
 * 			}
 * 
 * 		B：同步函数
 * 			方法修饰符 synchroinze 方法返回值的数据类型 方法名(参数列表){
 * 					//同步函数中的代码,在某一个时刻只能有一个线程进入这个函数执行
 * 				}
 * 
 * 并不是只要给需要同步的代码加上synchronize同步代码块就一定能解决安全性问题，
 * 因为同步是有前提的。
 * 同步的前提：
 * 		A:共享资源是不是被两个或者两个以上的线程访问
 * 		B:多个线程访问共享资源时加上同步后需要保证多个线程使用的是同一把锁
 * 
 * 
 * @author KuLianshu
 *
 */
public class DataSafeDemo01 {

	public static void main(String[] args) {
		
		SellTickets sellTickets=new SellTickets();
		Thread thread_beijing=new Thread(sellTickets);
		thread_beijing.setName("北京站");
		Thread thread_shanghai=new Thread(sellTickets);
		thread_shanghai.setName("上海");
		Thread thread_guangzhou=new Thread(sellTickets);
		thread_guangzhou.setName("广州");
		Thread thread_shenzhen=new Thread(sellTickets);
		thread_shenzhen.setName("深圳");
		
		thread_beijing.start();
		thread_shanghai.start();
		thread_guangzhou.start();
		thread_shenzhen.start();
		

	}
	
	static class SellTickets implements Runnable{
		/**
		 * 100张票就是我们的共享资源，多个线程都要访问的数据
		 */
		private int tickets =100;
		private Object obj=new Object();

		@Override
		public void run() {
			while(true) {
				//synchronized (new Object()) {//不安全，因为多个线程使用的
				//synchronized ("abc") {
				//synchronized (new String("abc")) {//不安全，因为多个线程使用的不是同一把锁
				synchronized(obj) {
					if(tickets>0) {
						try {
							Thread.sleep(10);
							System.out.println(Thread.currentThread().getName()
									+"正在卖第"+tickets+"张票");
							tickets--;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else {
						break;
					}
				}
				
			}
			
		}
		
	}
	

}

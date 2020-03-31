package domain;

import domain.DataSafeDemo02.SellTickets;

/**
 *  * 同步代码和同步函数都能保证数据的安全性，有什么区别呢？
 * 		1.语法格式不同：
 * 			synchronized(监视哨){
 * 
 * 			}
 * 
 * 			public synchronized void func(){
 * 
 * 			}
 * 
 * 		2.使用的锁不同
 * 			同步代码块可以使用任意对象作为锁
 * 			实例方法使用的锁是this.
 * 			如何证明？
 * 			当同步方法和同步函数使用的是同一把锁则能数据数据安全性，如果不是则不能保证数据的安全性，
 * 			可以通过证明同步函数和同步代码块使用的是同一把锁来间接证明同步函数使用的锁是什么。
 * 
 * @author KuLianshu
 *
 */
public class SynchronizeFunctionDemo03 {

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
		
		private int tickets=100;
		private Object obj=new Object();

		@Override
		public void run() {
			int i=0;
			while(true) {
				if(i==0) {
					//使用同步代码块卖票，当锁为obj的时候出现了脏数据
//					synchronized (obj) {
					//当锁为this时没有出现脏数据
					//证明同步方法和同步函数使用的是同一把锁，即this
					synchronized(this) {
						if(tickets>0) {
							try {
								Thread.sleep(10);
								System.out.println(Thread.currentThread().getName()+"正在卖第"+tickets--+"张票");
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}else {
					//使用同步函数卖票
					sell();
				}
				i=(i+1)%2;
				if(tickets==0) {
					break;
				}
			}
		
		}
		
		/**
		 * 使用同步函数卖票
		 */
		private synchronized void sell() {
			if(tickets>0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName()
							+"正在卖第"+tickets+"张票");
					tickets--;
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}




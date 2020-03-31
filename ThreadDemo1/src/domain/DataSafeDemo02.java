package domain;

import domain.DataSafeDemo01.SellTickets;

public class DataSafeDemo02 {

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
		private int tickets=100;
		private Object obj=new Object();
		

		@Override
		public void run() {
			
			while(true) {
				sell();
				if(tickets==0) {
					break;
				}
			}
		}
		
		/**
		 * 在方法返回值数据类型的前面加上synchronized关键字后这个方法就叫同步方法，同步
		 * 方法中的代码值某一时刻只能有一个线程进行执行其中的代码
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







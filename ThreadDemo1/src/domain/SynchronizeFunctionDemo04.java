package domain;

/**
 * 静态方法使用的锁是静态方法所在的类的字节码文件对象，即类名.class
 * @author KuLianshu
 *
 */
public class SynchronizeFunctionDemo04 {

	public static void main(String[] args) {
		
		SellTickets sellTickets=new SellTickets();
		Thread thread_beijing=new Thread(sellTickets,"北京");
		Thread thread_shanghai=new Thread(sellTickets,"上海");
		Thread thread_guangzhou=new Thread(sellTickets,"广州");
		Thread thread_shenzhen=new Thread(sellTickets,"深圳");
		
		thread_beijing.start();
		thread_shanghai.start();
		thread_shenzhen.start();
		thread_guangzhou.start();

	}
	
	static class SellTickets implements Runnable{
		
		private static int tickets=100;
		

		@Override
		public void run() {
			int i=0;
			while(true) {
				if(i==0) {
					synchronized(SellTickets.class) {
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
					//使用同步函卖票
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
		private static synchronized void sell() {
			if(tickets>0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName()+"正在卖第"+tickets--+"张票");
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}

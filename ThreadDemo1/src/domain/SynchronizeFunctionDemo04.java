package domain;

/**
 * ��̬����ʹ�õ����Ǿ�̬�������ڵ�����ֽ����ļ����󣬼�����.class
 * @author KuLianshu
 *
 */
public class SynchronizeFunctionDemo04 {

	public static void main(String[] args) {
		
		SellTickets sellTickets=new SellTickets();
		Thread thread_beijing=new Thread(sellTickets,"����");
		Thread thread_shanghai=new Thread(sellTickets,"�Ϻ�");
		Thread thread_guangzhou=new Thread(sellTickets,"����");
		Thread thread_shenzhen=new Thread(sellTickets,"����");
		
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
								System.out.println(Thread.currentThread().getName()+"��������"+tickets--+"��Ʊ");
								
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					
					}
				}else {
					//ʹ��ͬ������Ʊ
					sell();
				}
				i=(i+1)%2;
				
				if(tickets==0) {
					break;
				}
			}
			
		}
		
		/**
		 * ʹ��ͬ��������Ʊ
		 */
		private static synchronized void sell() {
			if(tickets>0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName()+"��������"+tickets--+"��Ʊ");
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}

package domain;

import domain.DataSafeDemo01.SellTickets;

public class DataSafeDemo02 {

	public static void main(String[] args) {
		
		SellTickets sellTickets=new SellTickets();
		Thread thread_beijing=new Thread(sellTickets);
		thread_beijing.setName("����վ");
		Thread thread_shanghai=new Thread(sellTickets);
		thread_shanghai.setName("�Ϻ�");
		Thread thread_guangzhou=new Thread(sellTickets);
		thread_guangzhou.setName("����");
		Thread thread_shenzhen=new Thread(sellTickets);
		thread_shenzhen.setName("����");
		
		thread_beijing.start();
		thread_shanghai.start();
		thread_guangzhou.start();
		thread_shenzhen.start();
		
	}
	
	static class SellTickets implements Runnable{
		
		/**
		 * 100��Ʊ�������ǵĹ�����Դ������̶߳�Ҫ���ʵ�����
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
		 * �ڷ�������ֵ�������͵�ǰ�����synchronized�ؼ��ֺ���������ͽ�ͬ��������ͬ��
		 * �����еĴ���ֵĳһʱ��ֻ����һ���߳̽���ִ�����еĴ���
		 */
		private synchronized void sell() {
			if(tickets>0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName()
							+"��������"+tickets+"��Ʊ");
					tickets--;
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}







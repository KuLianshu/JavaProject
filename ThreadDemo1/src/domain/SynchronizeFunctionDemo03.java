package domain;

import domain.DataSafeDemo02.SellTickets;

/**
 *  * ͬ�������ͬ���������ܱ�֤���ݵİ�ȫ�ԣ���ʲô�����أ�
 * 		1.�﷨��ʽ��ͬ��
 * 			synchronized(������){
 * 
 * 			}
 * 
 * 			public synchronized void func(){
 * 
 * 			}
 * 
 * 		2.ʹ�õ�����ͬ
 * 			ͬ����������ʹ�����������Ϊ��
 * 			ʵ������ʹ�õ�����this.
 * 			���֤����
 * 			��ͬ��������ͬ������ʹ�õ���ͬһ���������������ݰ�ȫ�ԣ�����������ܱ�֤���ݵİ�ȫ�ԣ�
 * 			����ͨ��֤��ͬ��������ͬ�������ʹ�õ���ͬһ���������֤��ͬ������ʹ�õ�����ʲô��
 * 
 * @author KuLianshu
 *
 */
public class SynchronizeFunctionDemo03 {

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
		
		private int tickets=100;
		private Object obj=new Object();

		@Override
		public void run() {
			int i=0;
			while(true) {
				if(i==0) {
					//ʹ��ͬ���������Ʊ������Ϊobj��ʱ�������������
//					synchronized (obj) {
					//����Ϊthisʱû�г���������
					//֤��ͬ��������ͬ������ʹ�õ���ͬһ��������this
					synchronized(this) {
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
					//ʹ��ͬ��������Ʊ
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




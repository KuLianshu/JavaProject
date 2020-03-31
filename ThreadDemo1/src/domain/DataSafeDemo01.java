package domain;

/**
 * ���̷߳��ʹ������ݲ���ȫ��ԭ��һ���̻߳�û��ִ�����Լ��Ĵ���
 * �ͱ���һ���̴߳����ɵģ�CPU�������л���
 * �����������һ���̻߳�û��ִ�����Լ��Ĵ���ʱ��һ���̲߳���ִ��
 * �͵�һ���߳���ͬ�Ĵ��롣
 * 
 * ʵ�ַ�ʽ��
 * 		A��ͬ�������
 * 			synchronized(������(obj)\�����\��){
 * 				//д��synchronized���ڵĻ������еĴ�����ĳһ��ʱ��ֻ����һ���߳̽���
 * 			}
 * 
 * 		B��ͬ������
 * 			�������η� synchroinze ��������ֵ���������� ������(�����б�){
 * 					//ͬ�������еĴ���,��ĳһ��ʱ��ֻ����һ���߳̽����������ִ��
 * 				}
 * 
 * ������ֻҪ����Ҫͬ���Ĵ������synchronizeͬ��������һ���ܽ����ȫ�����⣬
 * ��Ϊͬ������ǰ��ġ�
 * ͬ����ǰ�᣺
 * 		A:������Դ�ǲ��Ǳ����������������ϵ��̷߳���
 * 		B:����̷߳��ʹ�����Դʱ����ͬ������Ҫ��֤����߳�ʹ�õ���ͬһ����
 * 
 * 
 * @author KuLianshu
 *
 */
public class DataSafeDemo01 {

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
		private int tickets =100;
		private Object obj=new Object();

		@Override
		public void run() {
			while(true) {
				//synchronized (new Object()) {//����ȫ����Ϊ����߳�ʹ�õ�
				//synchronized ("abc") {
				//synchronized (new String("abc")) {//����ȫ����Ϊ����߳�ʹ�õĲ���ͬһ����
				synchronized(obj) {
					if(tickets>0) {
						try {
							Thread.sleep(10);
							System.out.println(Thread.currentThread().getName()
									+"��������"+tickets+"��Ʊ");
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

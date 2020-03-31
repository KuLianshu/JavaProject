package domain;

/**
 * ���������ͻ�ȥ���д�Ǯ��ÿ�δ�3��
 * @author KuLianshu
 *
 */
public class BankMoneyDemo05 {

	public static void main(String[] args) {
		MyRunnable myRunnable=new MyRunnable();
		Thread thread_zhangsan=new Thread(myRunnable);
		Thread thread_lisi=new Thread(myRunnable);
		
		thread_zhangsan.start();
		thread_lisi.start();

	}
	
	static class Bank{
		private int sum;
		
		public synchronized void add(int money) {
			sum+=money;
			System.out.println("sum = "+sum);
		}
	}
	
	static class MyRunnable implements Runnable{
		
		private Bank bank=new Bank();

		@Override
		public void run() {
			for(int i=0;i<3;i++) {
				bank.add(100);
			}
			
		}
		
	}

}

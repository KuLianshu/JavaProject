package domain;

/**
 * 
 * ������ԭ��
 * �߳�1��ס��ԴA�ȴ���ԴB���߳�2��ס��ԴB�ȴ���ԴA��
 * �����̶߳��ڵȴ��Լ���Ҫ����Դ������Щ��Դ�������
 * �߳���ס����Щ�߳�����ң��ҵ��㣬˭Ҳ��Ը���ó���Դ��
 * ���������Ͳ����ˡ�
 * 
 * ��������İ취֮һ���ǣ��Ӵ��������ȡ�
 * 
 * 
 * ������ʾ
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

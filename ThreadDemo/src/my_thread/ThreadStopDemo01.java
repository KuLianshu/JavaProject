package my_thread;

/**
 * 1���̵߳ȴ�
 * Object���е�wait()����������ʹ��ǰ���̵߳ȴ���ֱ������
 * �̵߳��ô˶����notify()��������notifyAll()�������ѡ�
 * 2���̻߳���
 * ��1��Object���е�notify()�����������ڴ˶���������ϵȴ��ĵ����̣߳�
 * ��������̶߳��ڴ˶����ϵȴ������ѡ��������һ���̡߳�ѡ��������ġ�
 * ��2��Object���е�notifyAll()�����������ڴ˶���������ϵȴ��������̡߳�
 * 
 * ע�⣺����������ֻ���ڱ�ͬ������synchronized���ķ����������е��á�
 * 
 * @author KuLianshu
 *
 */
public class ThreadStopDemo01 {

	public static void main(String[] args) {
		
		MyRunnable myRunnable=new MyRunnable();
		Thread t1=new Thread(myRunnable);
		t1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			myRunnable.ternimal();
		}
		
		

	}
	
	/**
	 * �̵߳�ֹͣ
	 * ��1������̵߳�run()������ִ�е���һ���ظ�ִ�е�ѭ����
	 * �����ṩһ����������ƺ�ʱ����ѭ����
	 * ��2������߳���Ϊִ��sleep()����wait()������������״̬��
	 * ��ʱ��Ҫֹͣ��������ʹ��interrupt()��������׳�InterruptException�쳣
	 * ��3�����������Ϊ����/����ĵȴ��������������ϱ���ȴ���������Ķ�����ɲ����뿪����״̬��
	 * �޷���interrupt()������ʹ���߳��뿪run()������Ҫ���뿪��ֻ��ͨ������һ���쳣�ķ�ʽ���뿪��
	 * @author KuLianshu
	 *
	 */
	static class MyRunnable implements Runnable{
		
		private boolean isStop=false;
		
		/**
		 * �õ�ǰ�߳�ֹͣ���У�ͨ����ѭ����־��Ϊtrue�����
		 */
		public void ternimal() {
			isStop=true;
		}
		

		@Override
		public void run() {
			while(!isStop) {
				System.out.println("run ......");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}

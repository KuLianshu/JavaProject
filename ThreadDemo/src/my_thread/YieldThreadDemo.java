package my_thread;

public class YieldThreadDemo {

	public static void main(String[] args) {
		
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"�������i="+i);
					//��ǰ�߳������ó�CPUʹ��Ȩ��������������ͬ���ȼ����߱������ȼ����ߵ��߳�����
					Thread.yield();
				}
				
			}
			
		});
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					//��ǰ�߳������ó�CPUʹ��Ȩ��������������ͬ���ȼ����߱������ȼ����ߵ��߳�����
					System.out.println(Thread.currentThread().getName()+"�������i="+i);
					Thread.yield();
				}
			}
			
		});
		
		t1.setName("�߳�һ��");
		t2.setName("�̶߳���");
		
		t1.start();
		t2.start();

	}

}

package my_thread;


public class JoinThreadDemo {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<300;i++) {
					System.out.println("�߳�"+Thread.currentThread().getName()+"�������"+i);
					
				}
				
			}
			
		});
		t1.setName("1");
		t1.start();
		
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					System.out.println("�߳�"+Thread.currentThread().getName()+"�������"+i);
				}
				
			}
			
		});
		t2.setName("2");
		t2.start();
		
		
		for(int i=0;i<10;i++) {
			System.out.println("�߳�"+Thread.currentThread().getName()+"�������"+i);
			if(i==5) {
				try {
					/*
					 *��ǰ�߳�main�߳�����������̶߳���t1��join()��������ǰ�߳�main��ת��waiting״̬��ָ��t1�߳�������Ϻ�
					 * ��ǰ�̲߳Ż���wating״̬�Զ�ת��ΪRunnable״̬. 
					 */
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

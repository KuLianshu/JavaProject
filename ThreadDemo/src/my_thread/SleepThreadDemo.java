package my_thread;

public class SleepThreadDemo {

	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			try {
				//�õ�ǰ�̣߳�main��˯��ָ��ʱ�䣬��ʱ����̴߳���waiting״̬��
				//ʱ���Ѻ���Ϊ��λ��ָ��ʱ�䵽��������߳���waiting״̬תΪRunnable״̬
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+"�������"+i);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}

}

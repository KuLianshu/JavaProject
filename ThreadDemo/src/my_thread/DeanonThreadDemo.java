package my_thread;

/**
 *1����̨�߳���Ϊǰ̨�̷߳���ģ�һ�����е�ǰ̨�̶߳��Ѿ����������̨�߳�Ҳ��������
 *2����һ�������У����û���κ�ǰ̨�߳������У���������̾ͽ�������Ȼ������������еĺ�̨�߳�Ҳ����֮������
 * @author KuLianshu
 *
 */
public class DeanonThreadDemo {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"�������i="+i);
				}
			}
			
		});

		t1.setName("�߳�һ��");
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"�������i="+i);
				}
			}
		});
		
		t2.setName("�̶߳���");
		
	
		//��t1�߳�����Ϊ��̨�̣߳��ػ��̡߳��û��̡߳������̣߳�
		//��������������߳�����֮ǰ���ã����򱨷Ƿ��߳�״̬�쳣
		t1.setDaemon(true);
		t1.start();
		
		t2.setDaemon(true);
		t2.start();
		

		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"�������i="+i);
		}
		
		
	}
	

}

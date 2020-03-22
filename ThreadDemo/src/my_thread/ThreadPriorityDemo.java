package my_thread;

import java.lang.Thread.State;

/**
 * ���ȼ��ߵ��̲߳���һ�����������У���ֻ�Ǳ�CPUѡ�еļ��ʱȽϴ����
 * @author KuLianshu
 *
 */
public class ThreadPriorityDemo {

	public static void main(String[] args) {
		
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()
							+"���i="+i);
				}
				
			}
		});
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"���i="+i);
					
				}
				
			}
		});
		
		//�����߳�t1�����ȼ�Ϊ������ȼ�10
		t1.setPriority(Thread.MAX_PRIORITY);
		//�����߳�t2�����ȼ�Ϊ������ȼ�1
		t2.setPriority(Thread.MIN_PRIORITY);
		
		int priority=t1.getPriority();
        System.out.println("��ȡt1�̵߳����ȼ���"+priority);
		
		priority=t2.getPriority();
		System.out.println("��ȡt2�̵߳����ȼ���"+priority);
		
		//�жϵ�ǰ�߳��Ƿ���
		System.out.println("t1.isAlive()1:"+t1.isAlive());
		
		//�����̵߳�״̬
		State state=t1.getState();
		//state=NEW
	    System.out.println("state="+state);
	    
	    t1.start();
		//RUNNABLE
		state=t1.getState();
		System.out.println("state="+state);
		System.out.println("t1.isAlive()2:"+t1.isAlive());
		t2.start();
		
	}

}

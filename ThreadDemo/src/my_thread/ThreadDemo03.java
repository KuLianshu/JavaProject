package my_thread;

public class ThreadDemo03 {

	public static void main(String[] args) {
		
		MyThread myThread=new MyThread();
		
		/*
		 *����myThread�����start()�������̣߳���ʱ����̴߳��ڿ�����״̬����ʱ����״̬����
		 *�ص㣺����ִ���ʸ񣬵�û��ִ��Ȩ��������̱߳�CPUѡ�в�����ִ������߳�run()����
		 *�еĴ���ʱ������̴߳�������״̬������״̬���ص㣺����ִ���ʸ�Ҳ��ִ��Ȩ��
		 *
		 *��ĳһ��ʱ�̣�ֻ��һ���̴߳�������״̬��
		 *
		 *�������̵߳�ʱ���������̶߳����start()���������ܵ��ö����run()��������Ϊ�������
		 *�����run()��������Ϊ��������̶߳����run()�����ͳ�����ͨ�ķ������ã�����������߳�
		 *�������С�
		 *ԭ���ǣ���Ϊ�������߳���Ҫ���ò���ϵͳ�ײ�Ĺ��ܣ��ⲿ�ִ��붼����װ�����̶߳����start()
		 *�����У��������߳���Ҫ���ȵ��ò���ϵͳ�ײ�Ĺ��ܡ�
		 *
		 * 
		 */
		
		//�������̣߳�����run()����
		myThread.start();
		
		String mainThreadName=Thread.currentThread().getName();
		for(int i=0;i<10;i++) {
			System.out.println("main:�߳�����Ϊ"+mainThreadName+"�߳��������i="+i);
		}

	}
	
	
	static class MyThread extends Thread{
		@Override
		public void run() {
			super.run();
			String childThreadName=Thread.currentThread().getName();
			for(int i=0;i<10;i++) {
				System.out.println("chidl:�߳�����Ϊ"+childThreadName+"�߳��������="+i);
			}
			
		}
	}

}

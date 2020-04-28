package com.wly.domain;

public class ThreadDemo01 {

	public static void main(String[] args) {
		MyRunnable myRunnable=new MyRunnable();
		Thread t1=new Thread(myRunnable);
		t1.start();
		
		Thread t2=new Thread(myRunnable);
//		t2.start();
		
		try {
			
			Thread.sleep(10);
			
			//ǿ����t1�߳��ɵȴ�״̬ת���ɿ�����״̬
			t1.interrupt();
//			t2.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("====Main.InterruptedException===");
		}
		

	}
	
	static class MyRunnable implements Runnable{
		
		private boolean isStop;
		
		public void setTerminal() {
			this.isStop=true;
		}

		@Override
		public synchronized void run() {
			while(!isStop) {
				try {
					//һ�����ڵȴ�״̬���̱߳�ǿ�ƻ���,��������λ�÷����쳣��
					//���������catch������
					this.wait();
					
				} catch (InterruptedException e) {
					System.out.println("===MyRunnable.run()=====");
					setTerminal();
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"===MyRunnable=====");
			}
			
		}
		
	}

}

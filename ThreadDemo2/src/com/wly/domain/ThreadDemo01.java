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
			
			//强制让t1线程由等待状态转换成可运行状态
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
					//一旦处于等待状态的线程被强制唤醒,则会在这个位置发生异常，
					//进入下面的catch语句块中
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

package my_thread;

public class JoinThreadDemo {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("线程"+Thread.currentThread().getName()+"正在输出"+i);
				}
				
			}
			
		});
		t1.setName("1");
		t1.start();
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("线程"+Thread.currentThread().getName()+"正在输出"+i);
				}
				
			}
			
		});
		t2.setName("2");
		t2.start();

		for(int i=0;i<10;i++) {
			System.out.println("线程"+Thread.currentThread().getName()+"线程正在输出"+i);
			if(i==5) {
				try {
					/*
					 *当前线程main如果调用了线程对象t1的join()方法，则
					 *当前线程main会转入waiting状态，指定t1线程运行完
					 *毕后，当前线程才会有waiting状态转化为Runnable状态
					 */
					//线程的归并
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

package my_thread;

public class YieldThreadDemo {

	public static void main(String[] args) {
		
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"正在输出i="+i);
					//当前线程主动让出CPU使用权，给和它具有相同优先级或者比它优先级更高的线程运行
					Thread.yield();
				}
				
			}
			
		});
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					//当前线程主动让出CPU使用权，给和它具有相同优先级或者比它优先级更高的线程运行
					System.out.println(Thread.currentThread().getName()+"正在输出i="+i);
					Thread.yield();
				}
			}
			
		});
		
		t1.setName("线程一号");
		t2.setName("线程二号");
		
		t1.start();
		t2.start();

	}

}

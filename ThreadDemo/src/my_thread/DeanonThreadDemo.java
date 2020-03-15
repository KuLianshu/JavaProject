package my_thread;

public class DeanonThreadDemo {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"正在输出i="+i);
				}
			}
			
		});

		t1.setName("线程一号");
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"正在输出i="+i);
				}
			}
		});
		
		t2.setName("线程二号");
		
	
		//将t1线程设置为后台线程（守护线程、用户线程、精灵线程）
		//这个操作必须在线程启动之前调用，否则报非法线程异常
		t1.setDaemon(true);
		t1.start();
		
		t2.setDaemon(true);
		t2.start();
		

		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"正在输出i="+i);
		}
		
		
	}
	

}

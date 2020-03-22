package my_thread;

/**
 *1、后台线程是为前台线程服务的，一旦所有的前台线程都已经死亡，则后台线程也就死亡了
 *2、在一个进程中，如果没有任何前台线程在运行，则这个进程就结束，当然这个进程中所有的后台线程也会随之死亡。
 * @author KuLianshu
 *
 */
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
		//这个操作必须在线程启动之前调用，否则报非法线程状态异常
		t1.setDaemon(true);
		t1.start();
		
		t2.setDaemon(true);
		t2.start();
		

		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"正在输出i="+i);
		}
		
		
	}
	

}

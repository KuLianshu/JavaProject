package my_thread;

import java.lang.Thread.State;

/**
 * 优先级高的线程并不一定会优先运行，它只是被CPU选中的几率比较大而已
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
							+"输出i="+i);
				}
				
			}
		});
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+"输出i="+i);
					
				}
				
			}
		});
		
		//设置线程t1的优先级为最高优先级10
		t1.setPriority(Thread.MAX_PRIORITY);
		//设置线程t2的优先级为最低优先级1
		t2.setPriority(Thread.MIN_PRIORITY);
		
		int priority=t1.getPriority();
        System.out.println("获取t1线程的优先级："+priority);
		
		priority=t2.getPriority();
		System.out.println("获取t2线程的优先级："+priority);
		
		//判断当前线程是否存活
		System.out.println("t1.isAlive()1:"+t1.isAlive());
		
		//返回线程的状态
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

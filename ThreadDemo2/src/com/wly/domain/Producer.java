package com.wly.domain;

import com.wly.domain.entity.Resource;

/**
 * 自定义生产者对象
 * @author KuLianshu
 *
 */
public class Producer implements Runnable{
	
	Resource resource;
	
	public Producer(Resource resource) {
		this.resource=resource;
	}
	

	/**
	 * 生产者对象，不停的进行生产
	 */
	@Override
	public void run() {
		int i=0;
		while(true) {
			synchronized(resource){
				
				//生产过
				if(resource.isProduce) {
					try {
						/*
						 * 让当前线程等待，调用锁对象的wait()方法，
						 * 产生的效果为：
						 * 当前线程（生产者线程）被放到当前锁对象的
						 * 等待池中，并释放所有的锁对象。
						 */
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(i==0) {
					resource.name="张三";
					resource.sex='男';
				}else {
					resource.name="小倩";
					resource.sex='女';
				}
				
				//将是否生成过的标志置为true，表示已经生产过了
				resource.isProduce=true;
				
				/*
				 * 当前环境下是通知消费者线程进行消费
				 * 
				 * 唤醒由于调用了resource对象的wait()方法而处于
				 * 等待状态的线程，让这个线程由等待状态转为可运行
				 * 状态。
				 * 
				 * 需要注意的是：如果持有resource锁的线程处于等待
				 * 状态，则随机唤醒一个，如果没有，则没有任何效果。
				 * 
				 */
				resource.notify();
			}
			
			i=(i+1)%2;
		}
		
		
	}

}

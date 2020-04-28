package com.wly.domain;

import com.wly.domain.entity.Resource;

/**
 * 自定义消费者对象
 * @author KuLianshu
 *
 */
public class Consumer implements Runnable{
	
	Resource resource;
	
	public Consumer(Resource resource) {
		this.resource=resource;
	}

	/**
	 * 消费对象，不停的消费
	 */
	@Override
	public void run() {
		while(true) {
			synchronized(resource) {
				//表示没有生成过
				if(!resource.isProduce) {
					try {
						/*
						 * 当前线程(消费者线程)被放到resource对象的等待池中，并且释放锁
						 */
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(resource.name+":"+resource.sex);
				
				//将是否生成过的标志置为false,表示没有生成过
				resource.isProduce=false;
				
				/*
				 * 当前环境下是唤醒生成者线程
				 * 
				 * 唤醒由于调用了resource对象的wait()方法而处于等待状态的线程,如果没有由于调用resouce对象的wait()方法
				 * 而处于等待状态的线程，则没有任何效果
				 */
				resource.notify();
			}
		}
		
	}

}

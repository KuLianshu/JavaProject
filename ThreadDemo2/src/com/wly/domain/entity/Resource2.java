package com.wly.domain.entity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源
 * @author KuLianshu
 *
 */
public class Resource2 {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private char sex;
	
	/**
	 * 是否生成过对象的标志,生成过了标志为true,没有生成标志位false
	 */
	private boolean isProduce;
	
	/**
	 * 实例化锁对象
	 */
	private Lock lock=new ReentrantLock();
	
	//根据锁对象获取监视哨对象
	private Condition condition_produce=lock.newCondition();
	private Condition condition_consumer=lock.newCondition();
	
	
	/**
	 * 让生产者生产资源时调用的方法
	 */
	public void set(String name,char sex) {
		
		//显式获取锁
		lock.lock();
		
		try {
			try {
				while(this.isProduce) {
					//让生产者线程等待
					condition_produce.await();
				}
			}catch (InterruptedException  e) {
				e.printStackTrace();
			}
			
			this.name=name;
			this.sex=sex;
			
			System.out.println(Thread.currentThread().getName()+"生产了====>"+this.name+":"+this.sex);
			
			this.isProduce=true;
			
			//唤醒消费者线程
			condition_consumer.signal();
			
		}finally {
			//显示释放锁，必须放在finally 语句中，否则可能出现锁没有释放的情况
			lock.unlock();
		}

		
	}
	
	/**
	 * 专门给消费者线程消费使用的
	 */
	public void out(){
		
		//显式获取锁
		lock.lock();
		
		try {
			while(!this.isProduce) {
				try {
					condition_consumer.await();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName()+"消费了====>"+this.name+":"+this.sex);
			//将是否生成过的标志置为false,表示没有生成过
			this.isProduce=false;
			    
			//唤醒生产者线程
			condition_produce.signal();
			
		}finally {
			//释放锁
			lock.unlock();
			
		}
		
	}
	
	
	
	

}

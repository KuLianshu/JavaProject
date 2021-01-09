package com.wly.domain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors提供的创建线程池的便捷方法都不支持使用，
 * 因为会有OOM的风险
 * 
 * 
 * @author KuLianshu
 *
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		
		//创建一个固定长度为5的线程池
		ExecutorService executor=Executors.newFixedThreadPool(5);
		
		//创建单一线程的线程池
//		ExecutorService executor=Executors.newSingleThreadExecutor();
		
		
		for(int i=0;i<10;i++) {
			executor.submit(new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("thread id is :"+Thread.currentThread().getId());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}));
		}
		
	}
	
	

}

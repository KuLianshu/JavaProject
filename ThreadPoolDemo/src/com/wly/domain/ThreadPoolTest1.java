package com.wly.domain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 推荐使用ThreadPoolExecutor的构造方法创建线程池
 * @author KuLianshu
 *
 */
public class ThreadPoolTest1 {

	public static void main(String[] args) {
		
		
		int corePoolSize=Runtime.getRuntime().availableProcessors()*2;
		int maximumPoolSize=corePoolSize;
		long keepAliveTime=0;
		BlockingQueue<Runnable>queue=new ArrayBlockingQueue<>(512);
		RejectedExecutionHandler policy=new ThreadPoolExecutor.DiscardPolicy();
		ExecutorService executorService=new ThreadPoolExecutor(
				//线程池长期维持的线程数，即使线程处于Idle状态，也不会回收。
				corePoolSize,
				//线程数的上限
				maximumPoolSize,
				// 超过corePoolSize的线程的idle时长，
				// 超过这个时间，多余的线程会被回收。
				keepAliveTime,
				TimeUnit.SECONDS,
				// 任务的排队队列
				queue,
//				//新线程的产生方式(非必须)
//			    new ThreadFactory() {
//
//					@Override
//					public Thread newThread(Runnable r) {
//						
//						return null;
//					}
//					
//				},
				// 拒绝策略
				policy);
		
		//提交任务
		executorService.execute(new Runnable() {

			@Override
			public void run() {
				//执行耗时操作
				
			}
			
		});
		

	}

}

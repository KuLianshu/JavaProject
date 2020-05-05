package com.wly.domain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �Ƽ�ʹ��ThreadPoolExecutor�Ĺ��췽�������̳߳�
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
				//�̳߳س���ά�ֵ��߳�������ʹ�̴߳���Idle״̬��Ҳ������ա�
				corePoolSize,
				//�߳���������
				maximumPoolSize,
				// ����corePoolSize���̵߳�idleʱ����
				// �������ʱ�䣬������̻߳ᱻ���ա�
				keepAliveTime,
				TimeUnit.SECONDS,
				// ������ŶӶ���
				queue,
//				//���̵߳Ĳ�����ʽ(�Ǳ���)
//			    new ThreadFactory() {
//
//					@Override
//					public Thread newThread(Runnable r) {
//						
//						return null;
//					}
//					
//				},
				// �ܾ�����
				policy);
		
		//�ύ����
		executorService.execute(new Runnable() {

			@Override
			public void run() {
				//ִ�к�ʱ����
				
			}
			
		});
		

	}

}

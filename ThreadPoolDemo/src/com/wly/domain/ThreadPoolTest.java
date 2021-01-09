package com.wly.domain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors�ṩ�Ĵ����̳߳صı�ݷ�������֧��ʹ�ã�
 * ��Ϊ����OOM�ķ���
 * 
 * 
 * @author KuLianshu
 *
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		
		//����һ���̶�����Ϊ5���̳߳�
		ExecutorService executor=Executors.newFixedThreadPool(5);
		
		//������һ�̵߳��̳߳�
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

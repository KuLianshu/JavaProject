package com.wly.domain;

import com.wly.domain.entity.Resource1;

/**
 * �������ߺ������߲���һ�������
 * @author KuLianshu
 *
 */
public class ProducerAndConsumer3 {

	public static void main(String[] args) {
		Resource1 resource=new Resource1();
		Producer2 producer=new Producer2(resource);
		Consumer2 consumer=new Consumer2(resource);
		
		new Thread(producer,"������1").start();
		new Thread(producer,"������2").start();
		
		new Thread(consumer,"������1").start();
		new Thread(consumer,"������2").start();

	}

}

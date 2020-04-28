package com.wly.domain;

import com.wly.domain.entity.Resource1;

/**
 * 当生产者和消费者不是一个的情况
 * @author KuLianshu
 *
 */
public class ProducerAndConsumer3 {

	public static void main(String[] args) {
		Resource1 resource=new Resource1();
		Producer2 producer=new Producer2(resource);
		Consumer2 consumer=new Consumer2(resource);
		
		new Thread(producer,"生产者1").start();
		new Thread(producer,"生产者2").start();
		
		new Thread(consumer,"消费者1").start();
		new Thread(consumer,"消费者2").start();

	}

}

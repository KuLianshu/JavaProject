package com.wly.domain;

import com.wly.domain.entity.Resource;

/**
 * 当生产者和消费者不是一个的情况
 * @author KuLianshu
 *
 */
public class ProducerAndConsumerDemo03 {

	public static void main(String[] args) {
		Resource resource=new Resource();
		Producer1 producer=new Producer1(resource);
		Consumer1 consumer=new Consumer1(resource);
		
		new Thread(producer).start();
		new Thread(producer).start();
		
		new Thread(consumer).start();
		new Thread(consumer).start();

	}

}

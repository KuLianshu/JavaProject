package com.wly.domain;

import com.wly.domain.entity.Resource2;

public class ProducerAndConsumer04 {

	public static void main(String[] args) {
		Resource2 resource=new Resource2();
		Producer3 producer=new Producer3(resource);
		Consumer3 consumer=new Consumer3(resource);
		new Thread(producer,"������1").start();
		new Thread(producer,"������2").start();
		
		new Thread(consumer,"������1").start();
		new Thread(consumer,"������2").start();
		

	}

}

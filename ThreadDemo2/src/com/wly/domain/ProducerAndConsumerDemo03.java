package com.wly.domain;

import com.wly.domain.entity.Resource;

/**
 * �������ߺ������߲���һ�������
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

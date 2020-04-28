package com.wly.domain;

import com.wly.domain.entity.Resource1;

public class Consumer2 implements Runnable{
	
	Resource1 resource;
	
	public Consumer2(Resource1 resource){
		this.resource=resource;
	}
	
	/**
	 * 消费对象,不停的消费
	 */
	@Override
	public void run() {
		while(true){
			resource.out();
		}
		
	}

}

package com.wly.domain;

import com.wly.domain.entity.Resource;

public class Consumer1 implements Runnable{
	
	Resource resource;
	
	public Consumer1(Resource resource) {
		this.resource=resource;
	}

	@Override
	public void run() {
		while(true) {
			resource.out();
		}
		
	}

}

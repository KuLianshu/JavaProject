package com.wly.domain;

import com.wly.domain.entity.Resource2;

public class Consumer3 implements Runnable{
	
	Resource2 resource;
	
	public Consumer3(Resource2 resource){
		this.resource=resource;
	}

	@Override
	public void run() {
		while(true) {
			resource.out();
		}
		
	}

}

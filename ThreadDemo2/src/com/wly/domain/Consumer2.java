package com.wly.domain;

import com.wly.domain.entity.Resource1;

public class Consumer2 implements Runnable{
	
	Resource1 resource;
	
	public Consumer2(Resource1 resource){
		this.resource=resource;
	}
	
	/**
	 * ���Ѷ���,��ͣ������
	 */
	@Override
	public void run() {
		while(true){
			resource.out();
		}
		
	}

}

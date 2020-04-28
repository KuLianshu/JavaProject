package com.wly.domain;

import com.wly.domain.entity.Resource;

public class Producer1 implements Runnable{
	
	Resource resource;
	
	public Producer1(Resource resource) {
		this.resource=resource;
	}
	

	@Override
	public void run() {
		int i=0;
		while(true) {
			if(i==0) {
				resource.set("张三", '男');
			}else {
				resource.set("小倩", '女');
			}
			i=(i+1)%2;
		}
		
	}
	

}

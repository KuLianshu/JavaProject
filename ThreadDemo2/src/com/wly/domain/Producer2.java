package com.wly.domain;

import com.wly.domain.entity.Resource1;

public class Producer2 implements Runnable{

	Resource1 resource;
	public Producer2(Resource1 resource){
		this.resource=resource;
	}
	
	/**
	 * 生产者对象，进行不停的生产
	 */
	@Override
	public void run() {
		int i=0;
		while(true){
			if(i==0){
				resource.set("张三", '男');
			}else{
				resource.set("小倩",'女');
			}
			i=(i+1)%2;
		}
		
	}

}

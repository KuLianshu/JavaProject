package com.wly.domain;

import com.wly.domain.entity.Resource2;

public class Producer3 implements Runnable{
	
	Resource2 resource;
	public Producer3(Resource2 resource){
		this.resource=resource;
	}

	@Override
	public void run() {
		int i=0;
		while(true){
			if(i==0){
				resource.set("����", '��');
			}else{
				resource.set("Сٻ",'Ů');
			}
			i=(i+1)%2;
		}
		
	}

}

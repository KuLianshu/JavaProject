package com.wly.domain;

import com.wly.domain.entity.Resource1;

public class Producer2 implements Runnable{

	Resource1 resource;
	public Producer2(Resource1 resource){
		this.resource=resource;
	}
	
	/**
	 * �����߶��󣬽��в�ͣ������
	 */
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

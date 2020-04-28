package com.wly.domain;

import com.wly.domain.entity.Resource;

/**
 * �Զ��������߶���
 * @author KuLianshu
 *
 */
public class Producer implements Runnable{
	
	Resource resource;
	
	public Producer(Resource resource) {
		this.resource=resource;
	}
	

	/**
	 * �����߶��󣬲�ͣ�Ľ�������
	 */
	@Override
	public void run() {
		int i=0;
		while(true) {
			synchronized(resource){
				
				//������
				if(resource.isProduce) {
					try {
						/*
						 * �õ�ǰ�̵߳ȴ��������������wait()������
						 * ������Ч��Ϊ��
						 * ��ǰ�̣߳��������̣߳����ŵ���ǰ�������
						 * �ȴ����У����ͷ����е�������
						 */
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(i==0) {
					resource.name="����";
					resource.sex='��';
				}else {
					resource.name="Сٻ";
					resource.sex='Ů';
				}
				
				//���Ƿ����ɹ��ı�־��Ϊtrue����ʾ�Ѿ���������
				resource.isProduce=true;
				
				/*
				 * ��ǰ��������֪ͨ�������߳̽�������
				 * 
				 * �������ڵ�����resource�����wait()����������
				 * �ȴ�״̬���̣߳�������߳��ɵȴ�״̬תΪ������
				 * ״̬��
				 * 
				 * ��Ҫע����ǣ��������resource�����̴߳��ڵȴ�
				 * ״̬�����������һ�������û�У���û���κ�Ч����
				 * 
				 */
				resource.notify();
			}
			
			i=(i+1)%2;
		}
		
		
	}

}

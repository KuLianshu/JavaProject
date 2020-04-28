package com.wly.domain;

import com.wly.domain.entity.Resource;

/**
 * �Զ��������߶���
 * @author KuLianshu
 *
 */
public class Consumer implements Runnable{
	
	Resource resource;
	
	public Consumer(Resource resource) {
		this.resource=resource;
	}

	/**
	 * ���Ѷ��󣬲�ͣ������
	 */
	@Override
	public void run() {
		while(true) {
			synchronized(resource) {
				//��ʾû�����ɹ�
				if(!resource.isProduce) {
					try {
						/*
						 * ��ǰ�߳�(�������߳�)���ŵ�resource����ĵȴ����У������ͷ���
						 */
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(resource.name+":"+resource.sex);
				
				//���Ƿ����ɹ��ı�־��Ϊfalse,��ʾû�����ɹ�
				resource.isProduce=false;
				
				/*
				 * ��ǰ�������ǻ����������߳�
				 * 
				 * �������ڵ�����resource�����wait()���������ڵȴ�״̬���߳�,���û�����ڵ���resouce�����wait()����
				 * �����ڵȴ�״̬���̣߳���û���κ�Ч��
				 */
				resource.notify();
			}
		}
		
	}

}

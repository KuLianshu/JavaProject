package com.wly.domain.entity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ������Դ
 * @author KuLianshu
 *
 */
public class Resource2 {
	
	/**
	 * ����
	 */
	private String name;
	
	/**
	 * �Ա�
	 */
	private char sex;
	
	/**
	 * �Ƿ����ɹ�����ı�־,���ɹ��˱�־Ϊtrue,û�����ɱ�־λfalse
	 */
	private boolean isProduce;
	
	/**
	 * ʵ����������
	 */
	private Lock lock=new ReentrantLock();
	
	//�����������ȡ�����ڶ���
	private Condition condition_produce=lock.newCondition();
	private Condition condition_consumer=lock.newCondition();
	
	
	/**
	 * ��������������Դʱ���õķ���
	 */
	public void set(String name,char sex) {
		
		//��ʽ��ȡ��
		lock.lock();
		
		try {
			try {
				while(this.isProduce) {
					//���������̵߳ȴ�
					condition_produce.await();
				}
			}catch (InterruptedException  e) {
				e.printStackTrace();
			}
			
			this.name=name;
			this.sex=sex;
			
			System.out.println(Thread.currentThread().getName()+"������====>"+this.name+":"+this.sex);
			
			this.isProduce=true;
			
			//�����������߳�
			condition_consumer.signal();
			
		}finally {
			//��ʾ�ͷ������������finally ����У�������ܳ�����û���ͷŵ����
			lock.unlock();
		}

		
	}
	
	/**
	 * ר�Ÿ��������߳�����ʹ�õ�
	 */
	public void out(){
		
		//��ʽ��ȡ��
		lock.lock();
		
		try {
			while(!this.isProduce) {
				try {
					condition_consumer.await();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName()+"������====>"+this.name+":"+this.sex);
			//���Ƿ����ɹ��ı�־��Ϊfalse,��ʾû�����ɹ�
			this.isProduce=false;
			    
			//�����������߳�
			condition_produce.signal();
			
		}finally {
			//�ͷ���
			lock.unlock();
			
		}
		
	}
	
	
	
	

}

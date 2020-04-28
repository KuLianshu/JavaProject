package com.wly.domain.entity;

/**
 * ������Դ
 * @author KuLianshu
 *
 */
public class Resource {
	
	public String name;
	public char sex;
	/**
	 * �Ƿ����ɹ�����ı�־�����ɹ��˱�־Ϊtrue��û�����ɱ�־λfalse
	 */
	public boolean isProduce;
	
	public synchronized void set(String name,char sex) {
		if(this.isProduce) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.name=name;
		this.sex=sex;
		
		this.isProduce=true;
		this.notify();
		
	}
	
	public synchronized void out() {
		if(!this.isProduce) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(this.name+":"+this.sex);
		
		this.isProduce=false;
		this.notify();
	}

}

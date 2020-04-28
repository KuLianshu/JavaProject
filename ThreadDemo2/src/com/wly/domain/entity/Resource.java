package com.wly.domain.entity;

/**
 * 共享资源
 * @author KuLianshu
 *
 */
public class Resource {
	
	public String name;
	public char sex;
	/**
	 * 是否生成过对象的标志，生成过了标志为true，没有生成标志位false
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

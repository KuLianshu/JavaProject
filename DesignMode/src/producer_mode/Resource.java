package producer_mode;

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
		System.out.println(Thread.currentThread().getName()+"生产了====>"+this.name+":"+this.sex);
		
		this.isProduce=true;
		this.notifyAll();
		
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
		System.out.println(Thread.currentThread().getName()+"消费了====>"+this.name+":"+this.sex);
		this.isProduce=false;
		//唤醒由于调用了resource对象的wait方法而处于等待状态的所有线程,使其转化为可运行状态
		this.notifyAll();
	}

}

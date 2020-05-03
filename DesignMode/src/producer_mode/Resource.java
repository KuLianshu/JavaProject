package producer_mode;

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
		System.out.println(Thread.currentThread().getName()+"������====>"+this.name+":"+this.sex);
		
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
		System.out.println(Thread.currentThread().getName()+"������====>"+this.name+":"+this.sex);
		this.isProduce=false;
		//�������ڵ�����resource�����wait���������ڵȴ�״̬�������߳�,ʹ��ת��Ϊ������״̬
		this.notifyAll();
	}

}

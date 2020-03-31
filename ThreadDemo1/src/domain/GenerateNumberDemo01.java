package domain;

/**
 * 自动生成编号0,1,2,3......
 * 
 * @author KuLianshu
 *
 */
public class GenerateNumberDemo01 {

	public static void main(String[] args) {
		SeqNumber seqNumber=new SeqNumber();
		
		MyThread t1=new MyThread(seqNumber,"线程一号");
		MyThread t2=new MyThread(seqNumber,"线程二号");
		MyThread t3=new MyThread(seqNumber,"线程三号");
		
		t1.start();
		t2.start();
		t3.start();

	}
	
	static class MyThread extends Thread{
		
		private SeqNumber seqNumber;
		public MyThread(SeqNumber seqNumber,String name) {
			super(name);
			this.seqNumber=seqNumber;
		}
		
		@Override
		public void run() {
			super.run();
			for(int i=0;i<3;i++) {
				System.out.println(Thread.currentThread().getName()
						+"输出序号num="+seqNumber.getNextNum());
			}
			
		}
	}

}

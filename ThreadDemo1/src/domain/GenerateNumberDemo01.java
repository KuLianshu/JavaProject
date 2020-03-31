package domain;

/**
 * �Զ����ɱ��0,1,2,3......
 * 
 * @author KuLianshu
 *
 */
public class GenerateNumberDemo01 {

	public static void main(String[] args) {
		SeqNumber seqNumber=new SeqNumber();
		
		MyThread t1=new MyThread(seqNumber,"�߳�һ��");
		MyThread t2=new MyThread(seqNumber,"�̶߳���");
		MyThread t3=new MyThread(seqNumber,"�߳�����");
		
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
						+"������num="+seqNumber.getNextNum());
			}
			
		}
	}

}

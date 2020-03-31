package domain;

public class GenerateNumberDemo02 {

	public static void main(String[] args) {
		
		SeqNumber1 seqNumber=new SeqNumber1();
		
		MyThread t1=new MyThread(seqNumber,"�߳�һ��");
		MyThread t2=new MyThread(seqNumber,"�̶߳���");
		MyThread t3=new MyThread(seqNumber,"�߳�����");
		
		t1.start();
		t2.start();
		t3.start();

	}
	
	
	static class MyThread extends Thread{
		
		private SeqNumber1 seqNumber;
		
		public MyThread(SeqNumber1 seqNumber,String name){
			super(name);
			this.seqNumber=seqNumber;
		}
		
		@Override
		public void run() {
			for(int i=0;i<3;i++){
				System.out.println(Thread.currentThread().getName()+"������num="
			+seqNumber.getNextNum());
			}
		}
	}



}

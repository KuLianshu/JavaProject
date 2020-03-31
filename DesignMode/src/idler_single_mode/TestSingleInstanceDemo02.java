package idler_single_mode;

public class TestSingleInstanceDemo02 {

	public static void main(String[] args) {
		
		MyRunnable myRunnable=new MyRunnable();
		Thread t1=new Thread(myRunnable);
		Thread t2=new Thread(myRunnable);
		
		t1.start();
		t2.start();
		

	}
	
	static class MyRunnable implements Runnable{
		
		private Student stu1;
		private Student stu2;

		@Override
		public void run() {
			stu1=Student.getInstance();
			stu2=Student.getInstance();
			
			System.out.println("stu1="+stu1);
			System.out.println("stu2="+stu2);
			
		}
		
	}
	

}

package my_thread;

public class ThreadDemo02 {

	public static void main(String[] args) {
		
		String currentThreadName=Thread.currentThread().getName();
		for(int i=0;i<10;i++) {
			System.out.println("Main线程名称为:"+currentThreadName
					+"的线程输出的结果="+i);
		}
		
		run();
		
	}
	
	private static void run() {
		String currentThreadName=Thread.currentThread().getName();
		for(int i=0;i<10;i++) {
			System.out.println("run线程名称为:"+currentThreadName
					+"的线程输出的结果="+i);
		}
	}

}

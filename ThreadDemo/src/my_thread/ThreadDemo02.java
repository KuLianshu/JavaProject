package my_thread;

public class ThreadDemo02 {

	public static void main(String[] args) {
		
		String currentThreadName=Thread.currentThread().getName();
		for(int i=0;i<10;i++) {
			System.out.println("Main�߳�����Ϊ:"+currentThreadName
					+"���߳�����Ľ��="+i);
		}
		
		run();
		
	}
	
	private static void run() {
		String currentThreadName=Thread.currentThread().getName();
		for(int i=0;i<10;i++) {
			System.out.println("run�߳�����Ϊ:"+currentThreadName
					+"���߳�����Ľ��="+i);
		}
	}

}

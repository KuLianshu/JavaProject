package my_thread;

public class SleepThreadDemo {

	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			try {
				//让当前线程（main）睡眠指定时间，此时这个线程处于waiting状态，
				//时间已毫秒为单位，指定时间到，则这个线程由waiting状态转为Runnable状态
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+"正在输出"+i);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}

}

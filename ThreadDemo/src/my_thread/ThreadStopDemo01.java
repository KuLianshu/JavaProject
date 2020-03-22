package my_thread;

/**
 * 1、线程等待
 * Object类中的wait()方法，可以使当前的线程等待，直到其他
 * 线程调用此对象的notify()方法或者notifyAll()方法唤醒。
 * 2、线程唤醒
 * （1）Object类中的notify()方法，唤醒在此对象监视器上等待的单个线程，
 * 如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意的。
 * （2）Object类中的notifyAll()方法，唤醒在此对象监视器上等待的所有线程。
 * 
 * 注意：这三个方法只能在被同步化（synchronized）的方法或代码块中调用。
 * 
 * @author KuLianshu
 *
 */
public class ThreadStopDemo01 {

	public static void main(String[] args) {
		
		MyRunnable myRunnable=new MyRunnable();
		Thread t1=new Thread(myRunnable);
		t1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			myRunnable.ternimal();
		}
		
		

	}
	
	/**
	 * 线程的停止
	 * （1）如果线程的run()方法中执行的是一个重复执行的循环，
	 * 可以提供一个标记来控制何时跳出循环。
	 * （2）如果线程因为执行sleep()或是wait()而进入了阻塞状态，
	 * 此时想要停止它，可以使用interrupt()，程序会抛出InterruptException异常
	 * （3）如果程序因为输入/输出的等待而阻塞，基本上必须等待输入输出的动作完成才能离开阻塞状态。
	 * 无法用interrupt()方法来使得线程离开run()方法，要想离开，只能通过引发一个异常的方式来离开。
	 * @author KuLianshu
	 *
	 */
	static class MyRunnable implements Runnable{
		
		private boolean isStop=false;
		
		/**
		 * 让当前线程停止运行，通过将循环标志置为true来完成
		 */
		public void ternimal() {
			isStop=true;
		}
		

		@Override
		public void run() {
			while(!isStop) {
				System.out.println("run ......");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}

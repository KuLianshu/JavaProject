package tickets;

public class MyTickets2 implements Runnable{
	
	/**
	 * 各个售票点共同卖的100票，即我们所说的共享资源
	 */
	private int tickets=100;

	@Override
	public void run() {
		while(true) {
			if(tickets>0) {
				System.out.println(Thread.currentThread().getName()+"正在卖第"+tickets--+"张票");
			}else {
				break;
			}
		}
		
	}
	
	
	

}

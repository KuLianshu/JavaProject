package tickets;

public class MyTickets extends Thread{
	
	/**
	 * 各个售票点共同卖的100票，即我们所说的共享资源
	 */
	private static int tickets=100;
	
	@Override
	public void run() {
		super.run();
		
		
		while(true) {
			if(tickets>0) {
				System.out.println(Thread.currentThread().getName()+"正在卖第"+tickets--+"张票");
			}else {
				break;
			}
		}
		
	}

}

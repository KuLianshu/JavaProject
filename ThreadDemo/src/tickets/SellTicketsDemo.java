package tickets;

public class SellTicketsDemo {

	public static void main(String[] args) {
		
		MyTickets myTickets_beijing=new MyTickets();
		myTickets_beijing.setName("北京站");
		myTickets_beijing.start();
		
		//同一个线程不能同时启动多次，否则报异常：Exception in thread "main" java.lang.IllegalThreadStateException
		//myTickets_beijing.start();
		
		MyTickets myTickets_shanghai=new MyTickets();
		myTickets_shanghai.setName("上海站");
		myTickets_shanghai.start();
		
		
		
		
	}

}

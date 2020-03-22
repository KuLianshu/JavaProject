package tickets;

/**
 * 需求：多个售票站同时销售共同的100张，多个多个线程模拟多个售票点进行售票
 * @author KuLianshu
 *
 */
public class SellTicketsDemo {

	public static void main(String[] args) {
		
		//模拟多个售票点
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

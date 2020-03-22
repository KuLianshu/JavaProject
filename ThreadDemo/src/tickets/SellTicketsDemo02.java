package tickets;

/**
 * 需求：多个售票站同时销售共同的100张，多个线程模拟多个售票点进行售票
 * @author KuLianshu
 *
 */
public class SellTicketsDemo02 {

	public static void main(String[] args) {
		//实例化实现Runnable接口的子类对象
		MyTickets2 myTickets=new MyTickets2();
		
		//模拟多个售票点
		Thread thread_beijing=new Thread(myTickets,"北京站");
		thread_beijing.start();
		
		Thread thread_shanghai=new Thread(myTickets,"上海站");
		thread_shanghai.start();

	}

}

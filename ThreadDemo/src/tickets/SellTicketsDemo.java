package tickets;

/**
 * ���󣺶����Ʊվͬʱ���۹�ͬ��100�ţ��������߳�ģ������Ʊ�������Ʊ
 * @author KuLianshu
 *
 */
public class SellTicketsDemo {

	public static void main(String[] args) {
		
		//ģ������Ʊ��
		MyTickets myTickets_beijing=new MyTickets();
		myTickets_beijing.setName("����վ");
		myTickets_beijing.start();
		
		//ͬһ���̲߳���ͬʱ������Σ������쳣��Exception in thread "main" java.lang.IllegalThreadStateException
		//myTickets_beijing.start();
		
		MyTickets myTickets_shanghai=new MyTickets();
		myTickets_shanghai.setName("�Ϻ�վ");
		myTickets_shanghai.start();
		
		
		
		
	}

}

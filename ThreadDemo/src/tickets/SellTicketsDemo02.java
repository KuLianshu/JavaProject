package tickets;

/**
 * ���󣺶����Ʊվͬʱ���۹�ͬ��100�ţ�����߳�ģ������Ʊ�������Ʊ
 * @author KuLianshu
 *
 */
public class SellTicketsDemo02 {

	public static void main(String[] args) {
		//ʵ����ʵ��Runnable�ӿڵ��������
		MyTickets2 myTickets=new MyTickets2();
		
		//ģ������Ʊ��
		Thread thread_beijing=new Thread(myTickets,"����վ");
		thread_beijing.start();
		
		Thread thread_shanghai=new Thread(myTickets,"�Ϻ�վ");
		thread_shanghai.start();

	}

}

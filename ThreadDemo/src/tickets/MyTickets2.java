package tickets;

public class MyTickets2 implements Runnable{
	
	/**
	 * ������Ʊ�㹲ͬ����100Ʊ����������˵�Ĺ�����Դ
	 */
	private int tickets=100;

	@Override
	public void run() {
		while(true) {
			if(tickets>0) {
				System.out.println(Thread.currentThread().getName()+"��������"+tickets--+"��Ʊ");
			}else {
				break;
			}
		}
		
	}
	
	
	

}

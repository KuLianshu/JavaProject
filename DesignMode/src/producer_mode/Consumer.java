package producer_mode;


/**
 * �Զ��������߶���
 * @author KuLianshu
 *
 */
public class Consumer implements Runnable{
	
Resource resource;
	
	public Consumer(Resource resource) {
		this.resource=resource;
	}

	@Override
	public void run() {
		while(true) {
			resource.out();
		}
		
	}

}

package producer_mode;


/**
 * 自定义消费者对象
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

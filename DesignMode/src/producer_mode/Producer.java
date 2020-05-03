package producer_mode;


/**
 * 自定义生产者对象
 * @author KuLianshu
 *
 */
public class Producer implements Runnable{
	
Resource resource;
	
	public Producer(Resource resource) {
		this.resource=resource;
	}
	

	@Override
	public void run() {
		int i=0;
		while(true) {
			if(i==0) {
				resource.set("张三", '男');
			}else {
				resource.set("小倩", '女');
			}
			i=(i+1)%2;
		}
		
	}

}

package producer_mode;


/**
 * �Զ��������߶���
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
				resource.set("����", '��');
			}else {
				resource.set("Сٻ", 'Ů');
			}
			i=(i+1)%2;
		}
		
	}

}

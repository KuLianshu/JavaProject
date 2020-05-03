package producer_mode;


/**
 * ��û�м�ͬ��������£��������������ѹ����г�����������Ϊ�˽���������⣬�������߶���������߶������ͬ����ʹ�õ�����this,��������������Ȼ���ڣ�
 * �����������֣�������ͬ��ǰ������������еĵڶ������������������ߺ��������߳�ʹ�õĲ���ͬһ������Ϊ�˽��������⣬�����ĳ�����Դ����resource,
 * ����������������ʱ�������⣺���������Ѳ��ܴﵽ��г״̬����һ�������ܶ࣬һ�����Ѻܶ࣬������������Ҫ������һ������һ���������
 * ��취������������Ѳ���г�����⡣
 * 
 * @author KuLianshu
 *
 */
public class ProducerAndConsumerDemo01 {
	
	public static void main(String[] args) {
		Resource resource=new Resource();
		Producer producer=new Producer(resource);
		Consumer consumer=new Consumer(resource);
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}

package producer_mode;


/**
 * 在没有加同步的情况下，发现生产和消费过程中出现了人妖，为了解决人妖问题，给生产者对象和消费者对象加了同步，使用的锁是this,发现人妖问题依然存在，
 * 经过分析发现，不满足同步前提的两个条件中的第二个条件，即：生产者和消费者线程使用的不是同一把锁，为了解决这个问题，将锁改成了资源对象resource,
 * 问题解决，但发现这时还有问题：生产和消费不能达到和谐状态，即一次生产很多，一次消费很多，而不是我们需要的生产一个消费一个的情况。
 * 想办法解决生产和消费不和谐的问题。
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

package com.wly.domain;

import com.wly.domain.entity.Resource;


/**
 * wait和notify及notifyAll都是Object类中的方法，但这些方法却是操作线程的，为什么不把这些方法定义在Thread类中呢？
 *  A:这些方法都必须用在同步代码块或者同步方法中,必须保证调用wait方法的对象和调用notify或者notifyAll方法的对象是同一个对象
 *    才能保证等待唤醒机制正常运行.总之这些方法的使用必须有锁的存在.
 *  B:锁可以是任意对象，能够被任意对象调用的方法当然只能定义在Object类中.
 * @author KuLianshu
 *
 */
public class ProducerAndConsumerDemo02 {

	public static void main(String[] args) {
		Resource resource=new Resource();
		Producer1 producer=new Producer1(resource);
		Consumer1 consumer=new Consumer1(resource);
		
		new Thread(producer).start();
		new Thread(consumer).start();
		

	}

}

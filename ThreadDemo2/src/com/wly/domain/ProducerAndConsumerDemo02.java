package com.wly.domain;

import com.wly.domain.entity.Resource;


/**
 * wait��notify��notifyAll����Object���еķ���������Щ����ȴ�ǲ����̵߳ģ�Ϊʲô������Щ����������Thread�����أ�
 *  A:��Щ��������������ͬ����������ͬ��������,���뱣֤����wait�����Ķ���͵���notify����notifyAll�����Ķ�����ͬһ������
 *    ���ܱ�֤�ȴ����ѻ�����������.��֮��Щ������ʹ�ñ��������Ĵ���.
 *  B:����������������ܹ������������õķ�����Ȼֻ�ܶ�����Object����.
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

package my_thread;

/**
 * 
 * @author KuLianshu
 * 
 *  *  ���̵߳����о��в�ȷ����:���������ͬ�Ĵ�����ܵõ���ִ�н����һ��.������CPU���л���ɵ�
 *  
 *  
 *  ��Ȼ�������߳������ַ�ʽ���̳�Thread���ʵ��Runnable�ӿڣ���ô�����ַ�ʽ��ʲô�����أ�
 *  	��ͬ�㣺���ܿ������߳�
 *  	��ͬ�㣺
 *  		1.������ü̳�Thread�࿪�����̣߳���ô����java����ĵ����̳У���ô�����Ͳ����ڼ̳���������;
 *  			�������ʵ��Runnable�ӿڵķ�ʽ�������̣߳���ô����໹���Լ̳�������.
 *  		2.������ö��̷߳��ʹ�����Դ����ʱ������ü̳�Thread������ɣ������ɶ��߳��޷����ʹ�����Դ����Ϊ
 *  		  ʵ��������߳�ʱ������ԴҲ�������˶�ݣ���ɲ����ǹ�����Դ��Ϊ�˽��������⣬��Ҫ��������Դ��̬����
 *  		 ����һ������Ȼ�ܹ��ö��̷߳��ʹ�����Դ�ˣ���������Դ���������ڱ��ӳ���.
 *  		�������ʵ��Runnable�ӿڵķ�ʽ�������Դ������õķ�ʽ����Ϊ����ֻҪʵ����һ��ʵ����Runnable�ӿڵĶ��󼴿ɣ�
 *  		���߳�ʵ����ʱ��ͬһ��ʵ����Runnable�ӿڵĶ��󴫵ݸ�����̼߳���.
 *  
 *  		����������������̷߳��ʹ�����Դ������ʹ��ʵ��Runnable�ӿڵķ�ʽ����ɣ���Ϊ������õķ�ʽ.
 *
 */
public class ThreadDemo04 {

	public static void main(String[] args) {
		
		MyRunnable myRunnable=new MyRunnable();
		Thread thread=new Thread(myRunnable);
		thread.start();
		
		String mainThreadName=Thread.currentThread().getName();
		for(int i=0;i<10;i++) {
			System.out.println("main:�߳�����Ϊ"+mainThreadName+"�߳��������i="+i);
		}
		

	}
	

	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			String childThreadName=Thread.currentThread().getName();
			for(int i=0;i<10;i++) {
				System.out.println("child:�߳�����Ϊ"+childThreadName+"�߳��������i="+i);
			}
			
		}
		
	}

}

package my_thread;


/**
 * 
 * @author KuLianshu
 * �ڳ���ʼ����ʱ��JVM���Զ������Ǵ���һ���̣߳�����ִ�����Ǳ�д�Ĵ��룬����߳̽������̡߳�
 * �߳��ǳ����д����ִ����
 */
public class ThreadDemo01 {

	public static void main(String[] args) {

		Thread currentThread=Thread.currentThread();
		//���ظ��̵߳��ַ�����ʾ��ʽ�������߳����ơ����ȼ����߳���:Thread[main,5,main]
		System.out.println("currentThread = "+currentThread);
		System.out.println("currenThreadName = "+currentThread.getName());
		//�����߳�����
		currentThread.setName("���߳�");
		
		System.out.println("currenThreadName = "+currentThread.getName());

	}

}

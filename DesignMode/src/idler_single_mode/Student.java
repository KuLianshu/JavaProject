package idler_single_mode;

/**
 * ����ʽ�ĵ������ģʽ�ı�д���裺
 * 1������һ��˽�С���̬�����ر����͵Ķ���
 * 2�����캯��˽�л�
 * 3��ͨ�����еľ�̬�������ر������͵Ķ����ڷ���֮ǰ��Ҫ�ж���������ǲ���
 * ʵ�����������û��ʵ������ʵ����������ֱ�ӷ���
 * @author KuLianshu
 *
 */
public class Student {
	
	//����һ������
	private static Student instance;
	
	private Student() {
		System.out.println("======Student()=====");
	}
	
	/**
	 * 
	 * 
	 *
	 *  ͨ�������������ⲿ�ִ����ڶ��߳������»��а�ȫ����������ͨ������������synchronized�������ȫ������������һ����
	 *  
	 *  ÿ���߳��ڵ�����������Ƕ������жϵ�ǰ�����ǲ��ǿ��ţ������ή��Ч��.
	 *  ���ֲ����Ĵ����Ƚϴ���ô��취���ܽ����ȫ�����������Ч���أ�
	 *  ���Գ���ʹ��ͬ������������Կ���������ֻ����һ���жϻ��ǲ������Ч�ʣ�ͨ���о����ֿ���ͨ��˫���ж�������Ŀ�ģ��������ȫ�����������Ч��
	 * 
	 */
	//ͨ�����еľ�̬�������ر������͵Ķ����ڷ���֮ǰ��Ҫ�ж���������ǲ���ʵ�����������û��ʵ��������ʵ������ʵ���������ֱ�ӷ���
	public static  /*synchronized*/ Student getInstance() {
		if(instance==null) {
			synchronized(Student.class) {
				if(instance==null) {
					try {
						Thread.sleep(10);
						instance=new Student();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return instance;
	}

}

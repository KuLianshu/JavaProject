package hungry_single_mode;

/**
 * �������ģʽ�ж���ʽ�ı�д���裺
 * 1������һ��˽�С���̬�����ա����ر������͵Ķ���ʵ����
 * 2�����캯��˽�л�
 * 3��ͨ�����еľ�̬�������ر������͵Ķ���
 * 
 * @author KuLianshu
 *
 */
public class Person {
	
	//��������ʵ����
	private static final Person instance=new Person();
	
	//���캯��˽�л�
	private Person() {
		System.out.println("=======Person()======");
	}
	
	//���ض���
	public static Person getInstance() {
		return instance;
	}
	

}

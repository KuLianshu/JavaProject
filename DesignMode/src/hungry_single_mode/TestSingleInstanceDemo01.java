package hungry_single_mode;

/**
 * ���ģʽ������̶�����Ĺ̶�����
 * �������ģʽ������ֻ�ܻ�ȡһ����������ģʽ
 * @author KuLianshu
 *
 */
public class TestSingleInstanceDemo01 {

	public static void main(String[] args) {
		
		Person p1=Person.getInstance();
		
		Person p2=Person.getInstance();
		
		System.out.println("p1==p2��ֵ��"+(p1==p2));

	}

}

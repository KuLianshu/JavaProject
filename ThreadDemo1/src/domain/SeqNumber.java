package domain;

/**
 * ���ɱ�ŵ���
 * @author KuLianshu
 *
 */
public class SeqNumber {
	
	private static int num;
	
	/**
	 * �Զ�������ţ�0,1,2,3......
	 * @return
	 */
	public int getNextNum() {
		int number=num;
		num++;
		return number;
	}

}

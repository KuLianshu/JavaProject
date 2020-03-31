package domain;

/**
 * 生成编号的类
 * @author KuLianshu
 *
 */
public class SeqNumber {
	
	private static int num;
	
	/**
	 * 自动生成序号：0,1,2,3......
	 * @return
	 */
	public int getNextNum() {
		int number=num;
		num++;
		return number;
	}

}

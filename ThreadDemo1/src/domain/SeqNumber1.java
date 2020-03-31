package domain;

/**
 *  ThreadLocal�ڲ���һ����Ա����Map<Thread,T> valueMap=new HashMap<Thread,T>();
 * �����߳�t1����valueMapʱ���������ж�t1�߳��ڵ�ǰvalueMap���Ƿ���ڣ���������ڣ����Ե�
 * ǰ�߳�t1Ϊ����initialValue()�����ķ���ֵ��Ϊֵ��ӵ�valueMap�У���valueMap.put(t1,initialValue());
 * ������ڣ������t1��ȡvalueMap�м�Ϊt1��ֵ����valueMap.get(t1)�õ�֮ǰinitialValue()��ֵ��������޸�valueMap
* �м�Ϊt1��ֵ������ֱ��ʹ��valueMap.put(t1,��ֵ)����ɣ������̵߳Ĳ������̺�t1���ƣ����������ж��̷߳���threadLocal��ֵ
* ����ÿ���̲߳����Լ��ı��ر�����ֵ����valueMap��ָ��key��ֵ���������̷߳��ʾͲ�������̰߳�ȫ�������ˡ�
 * 
 * 
 * ���ɱ�ŵ���
 * @author KuLianshu
 *
 */
public class SeqNumber1 {
	
	private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>() {
		
		/**
		 * �ڵ���ThreadLocal�����get()����set(int num)ʱֻ����һ�Σ�
		 * ������ɳ�ʼ��ֵ
		 */
		protected Integer initialValue() {
			System.out.println(Thread.currentThread().getName());
			return 0;
		};
	};
	
	
	/**
	 * �Զ�������ţ�0,1,2,3......
	 * @return
	 */
	public int getNextNum() {
		//���ص�ǰ�̶߳�Ӧ������ֵ
		int num=threadLocal.get();
		threadLocal.set(num+1);
		return num;
	}

}

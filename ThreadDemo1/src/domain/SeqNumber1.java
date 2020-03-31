package domain;

/**
 *  ThreadLocal内部有一个成员变量Map<Thread,T> valueMap=new HashMap<Thread,T>();
 * 当有线程t1操作valueMap时，会首先判断t1线程在当前valueMap中是否存在，如果不存在，则以当
 * 前线程t1为键，initialValue()方法的返回值作为值添加到valueMap中，即valueMap.put(t1,initialValue());
 * 如果存在，则根据t1获取valueMap中键为t1的值，即valueMap.get(t1)得到之前initialValue()的值，如果想修改valueMap
* 中键为t1的值，可以直接使用valueMap.put(t1,新值)来完成，其它线程的操作过程和t1类似，这样，当有多线程访问threadLocal中值
* 会让每个线程操作自己的本地变量的值，即valueMap中指定key的值，这样多线程访问就不会出现线程安全性问题了。
 * 
 * 
 * 生成编号的类
 * @author KuLianshu
 *
 */
public class SeqNumber1 {
	
	private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>() {
		
		/**
		 * 在调用ThreadLocal对象的get()或者set(int num)时只调用一次，
		 * 用来完成初始化值
		 */
		protected Integer initialValue() {
			System.out.println(Thread.currentThread().getName());
			return 0;
		};
	};
	
	
	/**
	 * 自动生成序号：0,1,2,3......
	 * @return
	 */
	public int getNextNum() {
		//返回当前线程对应变量的值
		int num=threadLocal.get();
		threadLocal.set(num+1);
		return num;
	}

}

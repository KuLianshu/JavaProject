package domain;

import java.util.concurrent.ConcurrentHashMap;

/**
 * �̰߳�ȫ������
 * ConcurrentHasMap��CopyOnWriterArrayList��CopyOnWriteArraySet
 * 
 * 
 * @author KuLianshu
 *
 */
public class ContainerClassDemo01 {
	
	public static void main(String[] args) {
		
		ConcurrentHashMap<String,String>concurrentHashMap=new ConcurrentHashMap<>();
		concurrentHashMap.put("dog", "��");
		concurrentHashMap.put("pig", "��");
		concurrentHashMap.put("cat", "è");
		concurrentHashMap.put("cow", "ţ");
		
		System.out.println("concurrentHashMap:"+concurrentHashMap);
		
		
	}

}

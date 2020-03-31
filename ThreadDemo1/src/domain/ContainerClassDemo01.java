package domain;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程安全的容器
 * ConcurrentHasMap、CopyOnWriterArrayList、CopyOnWriteArraySet
 * 
 * 
 * @author KuLianshu
 *
 */
public class ContainerClassDemo01 {
	
	public static void main(String[] args) {
		
		ConcurrentHashMap<String,String>concurrentHashMap=new ConcurrentHashMap<>();
		concurrentHashMap.put("dog", "狗");
		concurrentHashMap.put("pig", "猪");
		concurrentHashMap.put("cat", "猫");
		concurrentHashMap.put("cow", "牛");
		
		System.out.println("concurrentHashMap:"+concurrentHashMap);
		
		
	}

}

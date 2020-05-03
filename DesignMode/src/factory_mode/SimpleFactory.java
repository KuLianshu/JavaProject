package factory_mode;

/**
 * 自定义简单工厂
 * @author KuLianshu
 *
 */
public class SimpleFactory {
	
	public static Person getInstance(String type) {
		if("worker".equals(type)) {
			return new Worker();
			
		}else if("peasant".equals(type)) {
			return new Peasant();
		}else if("doctor".equals(type)) {
			return new Doctor();
		}else {
			throw new RuntimeException("无效的类型字符串"+type);
		}
	}

}

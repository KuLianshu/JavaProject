package factory_mode;

/**
 * �Զ���򵥹���
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
			throw new RuntimeException("��Ч�������ַ���"+type);
		}
	}

}

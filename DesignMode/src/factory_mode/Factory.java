package factory_mode;

/**
 * ������
 * @author KuLianshu
 *
 */
public class Factory {
	
	//�ڷ������ڲ����ݲ�ͬ���������ز�ͬ���������
	public static Animal getAnimal(String type) {
		if("dog".equals(type)) {
			return new Dog();
		}else if("pig".equals(type)) {
			return new Pig();
		}else {
			System.out.println("δ֪����");
			return null;
		}
	}
	

}

package factory_mode;

/**
 * 工厂类
 * @author KuLianshu
 *
 */
public class Factory {
	
	//在方法的内部根据不同的条件返回不同的子类对象
	public static Animal getAnimal(String type) {
		if("dog".equals(type)) {
			return new Dog();
		}else if("pig".equals(type)) {
			return new Pig();
		}else {
			System.out.println("未知类型");
			return null;
		}
	}
	

}

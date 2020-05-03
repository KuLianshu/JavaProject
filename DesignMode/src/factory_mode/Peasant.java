package factory_mode;

public class Peasant implements Person{

	@Override
	public void eat() {
		System.out.println("农民吃饭");
		
	}

	@Override
	public void sleep() {
		System.out.println("农民睡觉");
		
	}

	@Override
	public void talk() {
		System.out.println("农民说话");
		
	}

}

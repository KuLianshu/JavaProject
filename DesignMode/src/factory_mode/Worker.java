package factory_mode;

public class Worker implements Person{

	@Override
	public void eat() {
		System.out.println("工人吃饭");
		
	}

	@Override
	public void sleep() {
		System.out.println("工人睡觉");
		
	}

	@Override
	public void talk() {
		System.out.println("工人说话");
		
	}
	
	

}

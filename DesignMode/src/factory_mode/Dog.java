package factory_mode;

public class Dog implements Animal{

	@Override
	public void eat() {
		
		System.out.println("====����==");
	}

	@Override
	public void sleep() {
		System.out.println("====��˯==");
		
	}
	
	public void shout() {
		System.out.println("=====С��������=====");
	}

}

package factory_mode;

public class Dog implements Animal{

	@Override
	public void eat() {
		
		System.out.println("====¹·³Ô==");
	}

	@Override
	public void sleep() {
		System.out.println("====¹·Ë¯==");
		
	}
	
	public void shout() {
		System.out.println("=====Ğ¡¹·ÍôÍô½Ğ=====");
	}

}

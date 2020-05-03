package factory_mode;

public class Pig implements Animal{

	@Override
	public void eat() {
		System.out.println("====Öí³Ô==");
		
	}

	@Override
	public void sleep() {
		
		System.out.println("====ÖíË¯==");
	}
	
	public void shout() {
		System.out.println("====Öíºßºß½Ğ==");
	}

}

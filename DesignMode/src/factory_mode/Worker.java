package factory_mode;

public class Worker implements Person{

	@Override
	public void eat() {
		System.out.println("���˳Է�");
		
	}

	@Override
	public void sleep() {
		System.out.println("����˯��");
		
	}

	@Override
	public void talk() {
		System.out.println("����˵��");
		
	}
	
	

}

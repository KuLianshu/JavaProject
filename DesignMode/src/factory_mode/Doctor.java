package factory_mode;

public class Doctor implements Person{

	@Override
	public void eat() {
		System.out.println("ҽ���Է�");

	}

	@Override
	public void sleep() {
		System.out.println("ҽ��˯��");

	}

	@Override
	public void talk() {
		System.out.println("ҽ��˵��");
	}

}

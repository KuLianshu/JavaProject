package factory_mode;

public class Doctor implements Person{

	@Override
	public void eat() {
		System.out.println("医生吃饭");

	}

	@Override
	public void sleep() {
		System.out.println("医生睡觉");

	}

	@Override
	public void talk() {
		System.out.println("医生说话");
	}

}

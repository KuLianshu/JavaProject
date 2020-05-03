package factory_mode;

public class FactoryDemo2 {

	public static void main(String[] args) {
		Person person=SimpleFactory1.getInstance("Doctor");
		print(person);

	}
	
	private static void print(Person person) {
		person.eat();
		person.sleep();
		person.talk();
	}

}

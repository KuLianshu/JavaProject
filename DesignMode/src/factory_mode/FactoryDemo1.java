package factory_mode;

public class FactoryDemo1 {

	public static void main(String[] args) {
		Person person=SimpleFactory.getInstance("doctor");
		print(person);

	}
	
	/**
	 *  ‰≥ˆ–≈œ¢
	 * @param person
	 */
	private static void print(Person person) {
		person.eat();
		person.sleep();
		person.talk();
		
	}

}

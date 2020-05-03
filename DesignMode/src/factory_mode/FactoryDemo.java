package factory_mode;

public class FactoryDemo {
	
	public static void main(String[] args){
		Animal dog=Factory.getAnimal("dog");
		call(dog);
		System.out.println("================");
		Animal pig=Factory.getAnimal("pig");
		call(pig);
		
	}
	
	static void call(Animal al) {
		al.eat();
		al.sleep();
		
		if(al instanceof Dog) {
			Dog dog=(Dog)al;
			dog.shout();
		}else if(al instanceof Pig) {
			Pig pig=(Pig)al;
			pig.shout();
		}
		
	}

}

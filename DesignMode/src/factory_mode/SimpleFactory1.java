package factory_mode;

public class SimpleFactory1 {
	
	public static Person getInstance(String type) {
		Person person=null;
		try {
			person=(Person)Class.forName("factory_mode."+type).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return person;
		
	}
	

}

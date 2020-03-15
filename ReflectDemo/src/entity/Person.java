package entity;

public class Person {
	/**
	 * –’√˚
	 */
	private String name;
	char sex;
	
	public String address;
	public String number;
	
	
	/**
	 * ƒÍ¡‰
	 */
	private int age;
	
	public Person(){
		System.out.println("===Person()=====");
	}
	
	public Person(String name){
		this.name=name;
		System.out.println("===Person(String name)=====");
	}
	
	private void print(){
		System.out.println("====Person.print()=====");
	}
	
    void display(){
		System.out.println("====Person.show()=====");
	}
	
	protected void show(String str1,int num){
		System.out.println("====Person.show(String str1,int num)=====");
	}
	
	protected void show(String str1,String str2){
		System.out.println("====Person.show(String str1,String str2)=====");
	}
	
	public String getMsg(){
		return "Person";
	}
	
	public String getMsg(String str){
		return "Person:"+str;
	}
}

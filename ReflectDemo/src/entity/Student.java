package entity;

public class Student {
	private String stuNo;
	protected String classNo;
	String schoolName;
	
	public String master;
	public String teacher;
	
	private void printStudent(){
		System.out.println("====Student.print()=====");
	}
	
    private void printStudent(String str,int i){
	    System.out.println("====Student.print().str="+str+",i="+i);
	}

    void displayStudent(){
		System.out.println("====Student.show()=====");
	}
	
	protected void showStudent(String str1,int num){
		System.out.println("====Student.show(String str1,int num)=====");
	}
	
	protected void showStudent(String str1,String str2){
		System.out.println("====Student.show(String str1,String str2)=====");
	}
	
	public String getMsgStudent(){
		System.out.println("=========getMsgStudent()==========");
		return "Student";
	}
	
	public String getMsgStudent(String str){
		System.out.println("=========getMsgStudent(String str)=========");
		return "Student:"+str;
	}
}

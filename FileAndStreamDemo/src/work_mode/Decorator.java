package work_mode;

/*
 * 装饰设计模式：给现有类增强功能的一种解决方案.
 * 		如何增强一个现有类的功能:
 * 			A:继承
 * 			B:装饰
 * 				
 * 被装饰对象往往提供一个基本功能.
 * 装饰对象在被装饰对象的基础上增强新的功能.
 * 
 * 下面例子中:
 * 儿子Son是被装饰对象,Mother和Father都是装饰对象，都是为了增强儿子的功能而存在的。其中Father的存在也是为了增强Mother的功能.
 */
public class Decorator {
	
	public static void main(String[] args) {
		
		Son son=new Son();
		son.paint();
		
		//Mother是修饰对象，被修饰对象son作为构造函数的实参传递到Mother类中
		Mother mother=new Mother(son);
		mother.paint();
		
		Father father=new Father(mother);
		father.paint();
		
	}

}

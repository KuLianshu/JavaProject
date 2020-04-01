设计模式基础
----------------


### 一、单例模式

单例设计模式：对外只能获取一个对象的设计模式。


#### 1、饿汉式

单例设计模式中饿汉式的编写步骤：</br>
（1）声明一个私有的静态的最终的返回本类类型的对象并实例化</br>
（2）构造函数私有化</br>
（3）通过公有的静态方法返回本类类型的对象</br>
`````
public class Person {
	
	private static final Person instance=new Person();
	
	private Person() {
		System.out.println("=======Person()======");
	}
	
	public static Person getInstance() {
		return instance;
	}

}

`````


#### 2、懒汉式

懒汉式的单例设计模式的编写步骤：</br>
（1）声明一个私有的静态的返回本类类型的对象</br>
（2）构造函数私有化</br>
（3）通过公有的静态方法返回本类类型的对象，在返回之前需要判断这个对象是不是实例化过，如果没有实例化过则实例化，实例化过后就直接返回</br>
`````
public class Student {
	
	private static Student instance;
	
	private Student() {
		System.out.println("======Student()=====");
	}

	public static  /*synchronized*/ Student getInstance() {
		if(instance==null) {
			synchronized(Student.class) {
				if(instance==null) {
					try {
						Thread.sleep(10);
						instance=new Student();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return instance;
	}

}
`````














反射中常用的方法
--------------------
#### 1、获取类模板的方法：
````
      //使用这种方式获取类模板有局限性：必须现有对象才能得到类模板对象
      Class cls=对象名.getClass();
      //最常用的，只要知道完全限定名(包名+类名)字符串即可获取类模板对象
      Class cls=Class.forName(包名+类名的字符串);
      //最简单,也比较常用，但必须指定类名才能获取类模板对象
      Class cls=类名.class;
````
 注意：<br>  
 （1）同一种类型的对象获取的类模板对象是同一个对象。<br>  
 （2）三种获取类模板的方式不同，但同于同一类型的对象获取的类模板是同一个对象。<br>  
#### 2、实例化类模板对象
````
      Class clz=Class.forName("entity.Person");
      Object obj=clz.newInstance();
`````
#### 3、获取属性
##### 获取本类及其父类中所有属性（仅限public）
`````
      //获取本类及其父类中所有的public权限的字段并组成数组
      Field []fields=clz.getFields();
      //根据字段名获取字段对象
      Field field=clz.getField("master");
      //获取对象
      Object obj=clz.newInstance();
      //给字段赋值 
      field.set(obj, "蒋介石");
      //根据字段获取指定对象的字段值（获取obj对象中的master字段的值）
      Object fieldValue=field.get(obj);
`````
##### 获取本类中所有属性（所有权限）
````
      //只获取本类中所有字段（不限权限）
      Field[]fields=clz.getDeclaredFields();
      //获取本类中指定字段名的字段对象
      Field field=clz.getDeclaredField("stuNo");
      Object obj=clz.newInstance();
      //因为stuNo被private修饰，所以必须取消Java语言的语法检查，不然将赋值失败
      field.setAccessible(true);
      field.set(obj, "007");
      //获取字段的值
      Object fieldValue=field.get(obj);

````
#### 4、获取方法
##### 获取本类及其父类中所有的方法（仅限public）
``````
      //根据类模板获取本类及其父类中所有的公共访问权限的方法
      Method[] methods=clz.getMethods();
      //第一个参数是方法名，第二个参数是方法参数数据类型所对应的类模板对象数组
      Method method=clz.getMethod("getMsgStudent", String.class);
      Object obj=clz.newInstance();
      //调用指定的方法,在反射中调用方法的格式为：方法对象.invoke(对象名,实际参数值列表);returnType即为方法返回值
      Object returnType=method.invoke(obj, "Hello");
			
``````
##### 获取本类中所有方法（不限属性）
```
      //根据类模板获取本类中所有权限的方法
      Method[] methods=clz.getDeclaredMethods();
      //第一个参数是方法名，第二个参数是方法参数的数据类型对应的类模板对象的变长数组
      Method method=clz.getDeclaredMethod("printStudent", String.class,int.class);
      Object obj=clz.newInstance();
      //取消java的语法检查
      method.setAccessible(true);
      Object returnType=method.invoke(obj, "Hello",6);
    
```
#### 5、获取构造函数
```
      //根据类模板实例化对象调用的是无参构造
      Object obj=clz.newInstance();
      System.out.println("obj = "+obj);
      //得到类中所有的构造函数
      Constructor[]constructors=clz.getConstructors();
      //得到带有一个String数据类型参数的构造函数
      Constructor constructor=clz.getConstructor(String.class);
      //调用构造函数
      Object con_obj=constructor.newInstance("Hello");
      

```

#### 6、总结
（1）反射的好处，其实就一句话：高内聚低耦合。把代码动态化，提高了代码的灵活度减少了代码量。<br>  
（2）反射的缺点，代码灵活度增大了，自然会带来效率的问题，因此，大量使用反射会带来效率低的问题。<br>  





























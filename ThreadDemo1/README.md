Thread 基础 二
---------------

### 线程同步 

#### synchronized使用

1、同步代码块
``````
        //不安全，因为多个线程使用的
        //synchronized (new Object()) {
				//synchronized ("abc") {
        //不安全，因为多个线程使用的不是同一把锁
				//synchronized (new String("abc")) {
        synchronized(obj) {
                  if(tickets>0) {
                    try {
                      Thread.sleep(10);
                      System.out.println(Thread.currentThread().getName()
                          +"正在卖第"+tickets+"张票");
                      tickets--;
                    } catch (InterruptedException e) {
                      e.printStackTrace();
                    }
                  }else {
                    break;
                  }
                }
``````

2、同步方法
``````
    /**
		 * 在方法返回值数据类型的前面加上synchronized关键字后这个方法就叫同步方法，同步
		 * 方法中的代码值某一时刻只能有一个线程进行执行其中的代码
		 */
		private synchronized void sell() {
			if(tickets>0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName()
							+"正在卖第"+tickets+"张票");
					tickets--;
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

``````
注意：</br>
1、并不是只要给需要同步的代码加上synchronize同步代码块就一定能解决安全性问题，因为同步是有前提的。</br>
同步的前提：</br>
（1）共享资源是不是被两个或者两个以上的线程访问</br>
（2）多个线程访问共享资源时加上同步后需要保证多个线程使用的是同一把锁</br>

#### 同步代码块与同步函数的区别
1、语法不同。</br>
2、使用的锁不同：</br>
（1）同步代码块可以使用任意对象作为锁。</br>
（2）实例方法使用的锁是this。</br>
（3）静态方法使用的锁是静态方法所在的类的字节码文件对象，即类名.class。</br>
3、如何证明实例方法使用的锁是this？</br>
当同步方法和同步函数使用的是同一把锁则能数据数据安全性，如果不是则不能保证数据的安全性，所以可以通过证明同步函数和同步代码块使用的是同一把锁来间接证明同步函数使用的锁是什么。</br>

### 容器类的线程安全
1、容器类大多数默认都没有考虑线程安全问题，程序必须自行实现同步以确保共享数据在多线程下存取不会出错：</br>
可以用synchronized来锁住这个对象
``````
synchronized(list){list.add(...);}
``````
可以使用Collections的synchroniezdXXX()方法来返回一个同步化的容器对象
``````
List list=Collections.synchronizedList(new AsrrayList());
``````
这种方法在迭代是仍要用synchronized修饰
``````
List list=Collections.synchronizedList(new ArrayList());
...
synchronized(list){
  Iterator i=list.iterator();
  while(i.hasNext()){
    foo(i.next());
  }
}

``````
2、 线程安全的容器：ConcurrentHasMap、CopyOnWriterArrayList、CopyOnWriteArraySet。

### 锁互斥

1、死锁的原因：</br>
线程1锁住资源A等待资源B，线程2锁住资源B等待资源A，两个线程都在等待自己需要的资源，而这些资源被另外的线程锁住，这些线程你等我，我等你，谁也不愿意让出资源,这样死锁就产生了。</br>
2、解决死锁的办法之一就是：加大锁的粒度。</br>

### ThreadLocal类

1、ThreadLocal内部有一个成员变量Map<Thread,T> valueMap=new HashMap<Thread,T>();当有线程t1操作valueMap时，会首先判断t1线程在当前valueMap中是否存在，如果不存在，则以当前线程t1为键，initialValue()方法的返回值作为值添加到valueMap中，即valueMap.put(t1,initialValue());如果存在，则根据t1获取valueMap中键为t1的值，即valueMap.get(t1)得到之前initialValue()的值，如果想修改valueMap中键为t1的值，可以直接使用valueMap.put(t1,新值)来完成，其它线程的操作过程和t1类似，这样，当有多线程访问threadLocal中值会让每个线程操作自己的本地变量的值，即valueMap中指定key的值，这样多线程访问就不会出现线程安全性问题了。











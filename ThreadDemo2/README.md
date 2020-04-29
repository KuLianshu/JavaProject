Thread 基础 三
-----------------
### 线程等待、线程唤醒

#### 1、wait()/notify()/notifyAll()
````
			synchronized(resource){
				if(resource.isProduce) {
					try {
						/*
						 * 让当前线程等待，调用锁对象的wait()方法，
						 * 产生的效果为：
						 * 当前线程（生产者线程）被放到当前锁对象的
						 * 等待池中，并释放所有的锁对象。
						 */
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(i==0) {
					resource.name="张三";
					resource.sex='男';
				}else {
					resource.name="小倩";
					resource.sex='女';
				}
				
				//将是否生成过的标志置为true，表示已经生产过了
				resource.isProduce=true;
				
				/*
				 * 当前环境下是通知消费者线程进行消费
				 * 
				 * 唤醒由于调用了resource对象的wait()方法而处于
				 * 等待状态的线程，让这个线程由等待状态转为可运行
				 * 状态。
				 * 
				 * 需要注意的是：如果持有resource锁的线程处于等待
				 * 状态，则随机唤醒一个，如果没有，则没有任何效果。
				 * 
				 */
				resource.notify();
        //唤醒由于调用了resource对象的wait方法而处于等待状态的所有线程,使其转化为可运行状态
		    //this.notifyAll();
			}
			
			i=(i+1)%2;
		}

````
问： wait和notify及notifyAll都是Object类中的方法，但这些方法却是操作线程的，为什么不把这些方法定义在Thread类中呢？</br>
答：</br>
（1）这些方法都必须用在同步代码块或者同步方法中,必须保证调用wait方法的对象和调用notify或者notifyAll方法的对象是同一个对象才能保证等待唤醒机制正常运行.总之这些方法的使用必须有锁的存在。</br>
（2）锁可以是任意对象，能够被任意对象调用的方法当然只能定义在Object类中。</br>


### 2、唤醒特定线程（Lock）
````
/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private char sex;
	
	/**
	 * 是否生成过对象的标志,生成过了标志为true,没有生成标志位false
	 */
	private boolean isProduce;
	
	/**
	 * 实例化锁对象
	 */
	private Lock lock=new ReentrantLock();
	
	//根据锁对象获取监视哨对象
	private Condition condition_produce=lock.newCondition();
	private Condition condition_consumer=lock.newCondition();
	
	
	/**
	 * 让生产者生产资源时调用的方法
	 */
	public void set(String name,char sex) {
		
		//显式获取锁
		lock.lock();
		
		try {
			try {
				while(this.isProduce) {
					//让生产者线程等待
					condition_produce.await();
				}
			}catch (InterruptedException  e) {
				e.printStackTrace();
			}
			
			this.name=name;
			this.sex=sex;
			
			System.out.println(Thread.currentThread().getName()+"生产了====>"+this.name+":"+this.sex);
			
			this.isProduce=true;
			
			//唤醒消费者线程
			condition_consumer.signal();
			
		}finally {
			//显示释放锁，必须放在finally 语句中，否则可能出现锁没有释放的情况
			lock.unlock();
		}

		
	}
	
	/**
	 * 专门给消费者线程消费使用的
	 */
	public void out(){
		
		//显式获取锁
		lock.lock();
		
		try {
			while(!this.isProduce) {
				try {
					condition_consumer.await();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName()+"消费了====>"+this.name+":"+this.sex);
			//将是否生成过的标志置为false,表示没有生成过
			this.isProduce=false;
			    
			//唤醒生产者线程
			condition_produce.signal();
			
		}finally {
			//释放锁
			lock.unlock();
			
		}
		
	}
	
````

### 3、停止线程
````
public static void main(String[] args) {
		MyRunnable myRunnable=new MyRunnable();
		Thread t1=new Thread(myRunnable);
		t1.start();
		
		Thread t2=new Thread(myRunnable);
//		t2.start();
		
		try {
			
			Thread.sleep(10);
			
			//强制让t1线程由等待状态转换成可运行状态
			t1.interrupt();
//			t2.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("====Main.InterruptedException===");
		}
		

	}
	
	static class MyRunnable implements Runnable{
		
    //可以通过设置标记的方式使线程跳出循环，进而停止线程
		private boolean isStop;
		
		public void setTerminal() {
			this.isStop=true;
		}

		@Override
		public synchronized void run() {
			while(!isStop) {
				try {
					//一旦处于等待状态的线程被强制唤醒,则会在这个位置发生异常，
					//进入下面的catch语句块中
					this.wait();
					
				} catch (InterruptedException e) {
					System.out.println("===MyRunnable.run()=====");
					setTerminal();
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"===MyRunnable=====");
			}
			
		}
		
	}

````











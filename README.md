# FileAndStreamDemo这个项目包含的内容

## 一、File


## 二、Stream

### 1、字节流
（1）对字节进行操作最基础的流类
（2）流的类型
  InputStream--->FileInputStream
  OutputStream--->FileOutputStream

### 2、字符流
（1）对字符进行操作最基础的流类
（2）流的类型
  Reader--->FileReader
  Writer--->FileWriter
（3）字符流=字节流+编码表
（4）注意：使用FileWriter时，有可能会需要用到flush()
（5）flush()：
使用FileWriter的方法write()将指定字符写入指定文件中时，内容并没有直接写入目标设备中，而是先写到缓冲区，当缓冲区被写满后，系统会自动将数据写入目标设备中；但有时候我们的数据并没有那么多，这时就可以调用flush()手动刷新缓冲，通知系统将数据写入目标设备。

### 3、缓冲流
（1）流的类型
  字节缓冲流：
  BufferedInputStream/BufferedOutputStream
  BufferedRreader/BufferedWriter
（2）必要时调用flush刷新缓冲区
 
### 4、数据流
（1）作用：/<br>
用于向目标设备读写Java基本类型、String类型、对象类型数据的能力（注意数据流操作对象类型的数据时，该类需要序列化需要序列化）。
（2）流的类型/<br>
  DataInputStream/<br>
  DataOutputStream/<br>
  
 ### 5、内存流
 （1）注意：/<br>
 关闭内存流是无效的，因为内存流没有调用操作系统的底层功能。/<br>
 （2）流的类型/<br>
   ByteArrayInputStream/<br>
   ByteArrayOutputStream/<br>
   
  ### 6、打印流
  （1）为了能够自动刷新缓冲区，必须使用PrintStream
  （2）
  //第一个参数例化PrintWriter并关联文件输出流；第二个参数为true说明启用自动刷新缓冲区功能，false表示禁用自动刷新缓冲区功能
  PrintWriter printWriter=printWriter=new PrintWriter(new FileOutputStream(path),true);
  printWriter.print(20);
  //也可以调用flush()主动刷新
	printWriter.flush();
  （3）使用PrintWriter输出数据,如果启用了自动刷新缓存功能，则只有调用了println、printf 或 format 的其中一个方法时可能完成此操作
   
  ### 7、对象流
  （1）流类型
   ObjectInputStream
   ObjectOutputStream
   
   ### 8、RandomAccessFile
   
   
   
  
  
  
  


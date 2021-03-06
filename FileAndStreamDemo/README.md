# FileAndStreamDemo这个项目包含的内容

## 一、File


## 二、Stream

### 1、字节流

#### （1）对字节进行操作最基础的流类

#### （2）流的类型
  * InputStream--->FileInputStream<br>  
  * OutputStream--->FileOutputStream<br>  
  
  ```Java
InputStream inputStream =new FileInputStream(Constants.path);
OutputStream outputStream =new FileOutputStream(Constants.path);
  ```

### 2、字符流

#### （1）对字符进行操作最基础的流类

#### （2）流的类型
  * Reader--->FileReader<br>  
  * Writer--->FileWriter<br>  
```Java
Reader reader=new FileReader(Constants.path);
Writer writer=new FileWriter(Constants.path,true);
```
  
#### （3）字符流=字节流+编码表

#### （4）注意：
使用FileWriter时，有可能会需要用到flush()

#### （5）flush()：
使用FileWriter的方法write()将指定字符写入指定文件中时，内容并没有直接写入目标设备中，而是先写到缓冲区，当缓冲区被写满后，系统会自动将数据写入目标设备中；但有时候我们的数据并没有那么多，这时就可以调用flush()手动刷新缓冲，通知系统将数据写入目标设备。

### 3、缓冲流

#### （1）流的类型
  * 字节缓冲流：<br>
  BufferedInputStream/BufferedOutputStream<br>  
  * 字符缓冲流：<br>
  BufferedRreader/BufferedWriter
  ```Java
  BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(Constants.path));
  BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(Constants.path));
  BufferedReader bufferedReader=new BufferedReader(new FileReader(Constants.path));
  BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(Constants.path));
  ```
  
#### （2）必要时调用flush刷新缓冲区  
 
### 4、数据流

#### （1）作用：
用于向目标设备读写Java基本类型、String类型、对象类型数据的能力（注意数据流操作对象类型的数据时，该类需要序列化需要序列化）。<br>  

#### （2）流的类型
  * DataInputStream<br>
  * DataOutputStream<br>
  ```Java
  DataInputStream dataInputStream=new DataInputStream(new FileInputStream(Constants.path));
  DataOutputStream dataOutputStream=new DataOutputStream(new FileOutputStream(Constants.path));
  ```
  
 ### 5、内存流
 
 #### （1）注意：
 关闭内存流是无效的，因为内存流没有调用操作系统的底层功能。<br>
 
 #### （2）流的类型
   * ByteArrayInputStream
   * ByteArrayOutputStream
   ```Java
   ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
   ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(buffer);
   ```
   
  ### 6、打印流
  
  #### （1）为了能够自动刷新缓冲区，必须使用PrintStream
  
  #### （2）flush() 
  ```Java
  //第一个参数例化PrintWriter并关联文件输出流；第二个参数为true说明启用自动刷新缓冲区功能，false表示禁用自动刷新缓冲区功能
  PrintWriter printWriter=printWriter=new PrintWriter(new FileOutputStream(path),true);
  printWriter.print(20);
  //也可以调用flush()主动刷新
   printWriter.flush(); 
   ```
   
   ```Java
   PrintStream consolePrintStream=new PrintStream(System.out);
   PrintWriter printWriter=new PrintWriter(new FileOutputStream(Constants.path),true);
   
   ```
   
  #### （3）关于刷新
  使用PrintWriter输出数据,如果启用了自动刷新缓存功能，则只有调用了println、printf 或 format 的其中一个方法时可能完成此操作<br>  
   
  ### 7、对象流
  
  #### （1）流类型
   * ObjectInputStream<br>  
   * ObjectOutputStream<br>  
   ```Java
   ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(Constants.path));
   ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(Constants.path));
   ```
   
   ### 8、RandomAccessFile
   
   ### 9、转换流
   #### （1）流类型
   * InputStreamReader
   * OutputStreamWriter
   ```Java
   OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(Constants.path));
   InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(Constants.path));
   ```
   
  
  
  
  

 

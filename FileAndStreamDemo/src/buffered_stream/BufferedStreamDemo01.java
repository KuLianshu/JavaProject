package buffered_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import stream.Constants;

public class BufferedStreamDemo01 {

	public static void main(String[] args) {

		write();
		read();

	}
	
	private static void read() {
		BufferedReader bufferedReader=null;
		try {
			bufferedReader=new BufferedReader(new FileReader(Constants.path));
			String str=null;
			while((str=bufferedReader.readLine())!=null) {
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedReader!=null) {
				try {
					bufferedReader.close();
					bufferedReader=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private static void write() {
		BufferedWriter bufferedWriter=null;
		try {
			bufferedWriter=new BufferedWriter(new FileWriter(Constants.path));
			bufferedWriter.write("虎鲸你好！");
			//会根据操作系统的不同，自动选择换行符，在windows下使用\r\n进行换行，在Unix或者Linux下使用\n换行
			bufferedWriter.newLine();
			bufferedWriter.write("胖虎你好！");
			//刷新缓冲区
			bufferedWriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedWriter!=null) {
				try {
					bufferedWriter.close();
					bufferedWriter=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	

}

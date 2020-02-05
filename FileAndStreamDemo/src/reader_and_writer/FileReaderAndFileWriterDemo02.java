package reader_and_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import stream.Constants;

/**
 * 文件流
 * @author KuLianshu
 *
 */
public class FileReaderAndFileWriterDemo02 {
	
	public static void read() {
		Reader reader=null;
		try {
			reader=new FileReader(Constants.path);
			char []buffer=new char[2];
			int len;
			while((len=reader.read(buffer))!=-1) {
				System.out.println(new String(buffer,0,len));
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
					reader=null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void writer() {
		Writer writer=null;
		try {
			writer=new FileWriter(Constants.path,true);
			writer.write("每一天");
			writer.write("都要加油呀");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
					writer=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	

}

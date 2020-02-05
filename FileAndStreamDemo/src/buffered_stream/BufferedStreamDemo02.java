package buffered_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 接收用户键盘录入
 * @author KuLianshu
 *
 */
public class BufferedStreamDemo02 {

	public static void main(String[] args) {
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		
		String str=null;
		do {
			System.out.println("请输入信息：");
			//阻塞式方法，如果没有接收到数据，则这个方法会处于阻塞状态，直到收到数据后才会解除阻塞继续运行
			try {
				str=bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if("exit".equals(str)) {
				break;
			}
			System.out.println("content = "+str);
			
		}while(true);
		

	}
	
	

}

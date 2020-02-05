package encode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 字符= 字节+编码表
 * 
 * 编码：将字符转化成字节的过程
 * 解码：将字节转化成字符的过程
 * 
 * 乱码产生的原因：编码和解码过程中使用的不是同一个编码表
 * @author KuLianshu
 *
 */
public class EncodeDoMain {

	public static void main(String[] args) {
		encode();

	}
	
	
	public static void encode() {
		String str="出现叛徒，紧急撤离";
		//对给定的字符进行编码；str.getBytes()使用的是默认编码，当前是中文环境，所以使用的是GBK编码表
		byte[]buffer=str.getBytes();
		System.out.println("buffer = "+Arrays.toString(buffer));
		try {
		    //使用utf-8编码
			buffer=str.getBytes("utf-8");
			System.out.println("buffer = "+Arrays.toString(buffer));
			//对得到的字进行解码，同时指定编码表
			String newStr=new String(buffer,"utf-8");
			System.out.println("newStr = "+newStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}

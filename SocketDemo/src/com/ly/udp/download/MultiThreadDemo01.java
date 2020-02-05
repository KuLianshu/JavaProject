package com.ly.udp.download;

import java.io.File;

/**
 * 多线程下载演示
 * 因为多个线程需要在不同的位置进行读写操作，因此只能用RandomAccessFile来完成
 * @author Weiliyuan
 *
 */
public class MultiThreadDemo01 {

	public static void main(String[] args) {
		
		//需要下载的源文件
		String srcPath="E:\\"+File.separator+"JavaWorkSpace"+File.separator+"hello.txt";
		String destPath="E:\\"+File.separator+"JavaWorkSpace"+File.separator+"hello1.txt";
		File srcFile=new File(srcPath);
		File destFile=new File(destPath);
		
		//开启的线程数
		int threadNum=3;
		for(int i=0;i<threadNum;i++) {
			new DownLoadRunnable(srcFile, destFile, threadNum, i, "线程"+(i+1)+"号").start();
		}
		
	}
	
	

}

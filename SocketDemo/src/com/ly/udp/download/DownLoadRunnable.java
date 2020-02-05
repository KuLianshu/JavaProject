package com.ly.udp.download;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DownLoadRunnable extends Thread{
	
	//声明源文件的操作对象：随机访问文件对象
	private RandomAccessFile randomAccessFile_src;
	
	//声明目标文件的操作对象：随机访问文件对象
	private RandomAccessFile randomAccessFile_dest;
	
	//每个线程需要下载的文件的大小
	private long fileSize;
	
	public DownLoadRunnable(File srcFile,File destFile,int threadNum,int currentThreadId,String theadName) {
		try {
			randomAccessFile_src=new RandomAccessFile(srcFile, "r");
			randomAccessFile_dest=new RandomAccessFile(destFile, "rw");
			long fileTotal=srcFile.length();
			long temp=fileTotal/threadNum;
			fileSize=fileTotal%threadNum==0?temp:temp+1;
			long fileStart=fileSize*currentThreadId;
			randomAccessFile_src.seek(fileStart);
			randomAccessFile_dest.seek(fileStart);
			System.out.println("线程"+getName()+"从"+fileStart+"位置开始下载...");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public void run() {
		super.run();
		byte[]buffer=new byte[1024];
		int len=0;
		try {
			
			int sum=0;
			while((len=randomAccessFile_src.read(buffer))!=-1&&sum<fileSize) {
				sum+=len;
				randomAccessFile_dest.write(buffer,0,len);
			}
			System.out.println("线程"+Thread.currentThread().getName()+"下载完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(randomAccessFile_src!=null) {
					randomAccessFile_src.close();
					randomAccessFile_src=null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				
				if(randomAccessFile_dest!=null) {
					randomAccessFile_dest.close();
					randomAccessFile_dest=null;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}

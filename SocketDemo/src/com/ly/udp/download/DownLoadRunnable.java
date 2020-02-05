package com.ly.udp.download;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DownLoadRunnable extends Thread{
	
	//����Դ�ļ��Ĳ���������������ļ�����
	private RandomAccessFile randomAccessFile_src;
	
	//����Ŀ���ļ��Ĳ���������������ļ�����
	private RandomAccessFile randomAccessFile_dest;
	
	//ÿ���߳���Ҫ���ص��ļ��Ĵ�С
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
			System.out.println("�߳�"+getName()+"��"+fileStart+"λ�ÿ�ʼ����...");
			
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
			System.out.println("�߳�"+Thread.currentThread().getName()+"�������");
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

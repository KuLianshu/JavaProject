package com.ly.udp.download;

import java.io.File;

/**
 * ���߳�������ʾ
 * ��Ϊ����߳���Ҫ�ڲ�ͬ��λ�ý��ж�д���������ֻ����RandomAccessFile�����
 * @author Weiliyuan
 *
 */
public class MultiThreadDemo01 {

	public static void main(String[] args) {
		
		//��Ҫ���ص�Դ�ļ�
		String srcPath="E:\\"+File.separator+"JavaWorkSpace"+File.separator+"hello.txt";
		String destPath="E:\\"+File.separator+"JavaWorkSpace"+File.separator+"hello1.txt";
		File srcFile=new File(srcPath);
		File destFile=new File(destPath);
		
		//�������߳���
		int threadNum=3;
		for(int i=0;i<threadNum;i++) {
			new DownLoadRunnable(srcFile, destFile, threadNum, i, "�߳�"+(i+1)+"��").start();
		}
		
	}
	
	

}

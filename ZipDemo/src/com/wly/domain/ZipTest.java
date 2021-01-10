package com.wly.domain;

import java.io.File;
import java.io.IOException;

import com.wly.domain.utils.UZipFile;
import com.wly.domain.utils.ZipUtil;

public class ZipTest {

	public static void main(String[] args) {
		
		
//		zipTest1(zipPath);
		zipTest2();
		
	}
	
	
	private static void zipTest1() {
		String zipPath = "E:"+File.separator+"Test"+File.separator+"Img.zip";
		ZipUtil.unZip(zipPath); 
	    String f =  "E:"+File.separator+"Test"+File.separator;
	    File file = new File(f);
	    String[] test=file.list();
	    for(int i=0;i<test.length;i++){
	      System.out.println(test[i]);
	    }
	    System.out.println("------------------");
	    String fileName = "";
	    File[] tempList = file.listFiles();
	    for (int i = 0; i < tempList.length; i++) {
	      if (tempList[i].isFile()) {
	        System.out.println("文   件："+tempList[i]);
	        fileName = tempList[i].getName();
	        System.out.println("文件名："+fileName);
	      }
	      if (tempList[i].isDirectory()) {
	        System.out.println("文件夹："+tempList[i]);
	      }
	    }
	}
	
	private static void zipTest2() {
		String zipPath = "E:"+File.separator+"Test"+File.separator+"Img.zip";
		/**
	     * 解压文件
	     */
//	    File zipFile = new File("d:/资料.zip");
		File zipFile = new File(zipPath);
	    String path = "E:"+File.separator+"zipfile"+File.separator;
	    try {
			UZipFile.unZipFiles(zipFile, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

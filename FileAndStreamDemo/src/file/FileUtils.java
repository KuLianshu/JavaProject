package file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * File ：代表文件或者文件夹
 * 
 * @author KuLianshu
 *
 */
public class FileUtils {
	
	/**
	 * File.separator 存储了当前系统的路径分隔符
	 *UNIX系统上，此字段的值为'/'；在Windows系统上此字段的值为'\\'
	 */
	private static String path="note1.txt";
	private static String dir="E:"+File.separator+"note"+File.separator+"myNote";
	private static String path1=dir+File.separator+"myNote.txt";
	private static String path2=dir+File.separator+"myNote2.txt";
	
	
	
	public static void createFile() {
		//注意：不能根据文件名是否有扩展名来确定file是文件还是文件夹
		File file=new File(path);
		try {
			//使用file对象的createNewFile()创建文件夹，如果创建成功返回true，否则返回false，如果指定目录下的文件已经存在则创建失败
			boolean createFileResult=file.createNewFile();
			System.out.println("createFileResult = "+createFileResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createFile1() {
		
		/**
		 * mkdir()：只能创建一级目录
		 * mkdirs()：可以创建多级目录
		 *  
		 */
		File dirFile=new File(dir);
		dirFile.mkdirs();
		File file=new File(path1);
		try {
			boolean createFileResult=file.createNewFile();
			System.out.println("createFileResult = "+createFileResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readFile() {
		File file=new File(path1);
		File dirFile=new File(dir);
		System.out.println("file is File = "+file.isFile());
		System.out.println("dirFile is Directory = "+dirFile.isDirectory());
		//得到当前文件的绝对路径
		System.out.println("absolutePath = "+file.getAbsolutePath());
		//返回由此抽象路径名表示的文件或目录的名称。该名称是路径名名称序列中的最后一个名称。
		System.out.println("fileName = "+file.getName());
		//此抽象路径名的字符串形式
		System.out.println("filePath = "+file.getPath());
		//返回当前路径附文件夹的路径字符串
		System.out.println("parentPath = "+file.getParent());
		//返回父路径对应的File对象
		File parentFile=file.getParentFile();
		System.out.println("parentFile = "+parentFile);
	}
	
	public static void deleteFile() {
		File file=new File(path1);
		//判断文件是否存在
		if(file.exists()) {
			boolean deleteResult=file.delete();
			System.out.println("deleteResult = "+deleteResult);
		}else {
			System.out.println("文件不存在");
		}
	}
	
	
	public static void readFileInfo() {
		File file=new File(path1);
		if(file.exists()) {
			//返回文件大小，以字节为单位
			long fileSize=file.length();
			System.out.println("fileSize = "+fileSize);
			//返回从1970-1-1 00:00:00 到现在所经历的毫秒数
			long lastModified=file.lastModified();
			System.out.println("lastModified = "+lastModified);
			Date date=new Date(lastModified);
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate=format.format(date);
			System.out.println("modifed time : "+strDate);
			//返回盘符路径对应的字符串表示形式
			File []files=File.listRoots();
			System.out.println(Arrays.toString(files));
			
		}
	}
	
	
	public static void renameFile() {
		File dirFile=new File(dir);
		File file1=new File(path1);
		File file2=new File(path2);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		if(!file1.exists()) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//将一个文件进行重命名
		boolean renameResult=file1.renameTo(file2);
		System.out.println("renameResult = "+renameResult);
		
	}
	
	public static void fileList() {
		File file=new File(dir);
		//返回当前文件夹下所有文件和文件夹名称组成的数组
		String [] fileList=file.list();
		System.out.println("fileList = "+fileList);
		String[] fileNames=file.list(new FilenameFilter() {
			
			/**
			 * dir:父文件夹名称
			 * name:当前正在操作的文件或文件夹的名称
			 * return:如果返回true，就将当前文件的文件名name存入到fileNames数组中，否则不存入
			 * 
			 */
			@Override
			public boolean accept(File dir, String name) {
				System.out.println("dir = "+dir+", name = "+name);
				return name.endsWith(".txt");
			}
		});
		
		System.out.println(Arrays.toString(fileNames));
		
	}
	
	public static void listFile() {
		File file=new File(dir);
		listChilds(file,0);
	}
	
	/**
	 * 列举指定目录下所有的文件和文件夹，包括文件夹下的文件
	 * @param file 文件对象
	 * @param level 文件所在的层级
	 */
	private static void listChilds(File file,int level) {
		StringBuilder sb=new StringBuilder("|--");
		for(int i=0;i<level;i++) {
			sb.insert(0, "#");
		}
		File[] files=file.listFiles();
		int length=files==null?0:files.length;
		for(int i=0;i<length;i++) {
			File currentFile=files[i];
			System.out.println(sb.toString()+currentFile.getName());
			if(currentFile.isDirectory()) {
				listChilds(currentFile,level+1);
			}
		}
		
	}
	
	
	

}

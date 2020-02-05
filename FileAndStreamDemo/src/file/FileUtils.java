package file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * File �������ļ������ļ���
 * 
 * @author KuLianshu
 *
 */
public class FileUtils {
	
	/**
	 * File.separator �洢�˵�ǰϵͳ��·���ָ���
	 *UNIXϵͳ�ϣ����ֶε�ֵΪ'/'����Windowsϵͳ�ϴ��ֶε�ֵΪ'\\'
	 */
	private static String path="note1.txt";
	private static String dir="E:"+File.separator+"note"+File.separator+"myNote";
	private static String path1=dir+File.separator+"myNote.txt";
	private static String path2=dir+File.separator+"myNote2.txt";
	
	
	
	public static void createFile() {
		//ע�⣺���ܸ����ļ����Ƿ�����չ����ȷ��file���ļ������ļ���
		File file=new File(path);
		try {
			//ʹ��file�����createNewFile()�����ļ��У���������ɹ�����true�����򷵻�false�����ָ��Ŀ¼�µ��ļ��Ѿ������򴴽�ʧ��
			boolean createFileResult=file.createNewFile();
			System.out.println("createFileResult = "+createFileResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createFile1() {
		
		/**
		 * mkdir()��ֻ�ܴ���һ��Ŀ¼
		 * mkdirs()�����Դ����༶Ŀ¼
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
		//�õ���ǰ�ļ��ľ���·��
		System.out.println("absolutePath = "+file.getAbsolutePath());
		//�����ɴ˳���·������ʾ���ļ���Ŀ¼�����ơ���������·�������������е����һ�����ơ�
		System.out.println("fileName = "+file.getName());
		//�˳���·�������ַ�����ʽ
		System.out.println("filePath = "+file.getPath());
		//���ص�ǰ·�����ļ��е�·���ַ���
		System.out.println("parentPath = "+file.getParent());
		//���ظ�·����Ӧ��File����
		File parentFile=file.getParentFile();
		System.out.println("parentFile = "+parentFile);
	}
	
	public static void deleteFile() {
		File file=new File(path1);
		//�ж��ļ��Ƿ����
		if(file.exists()) {
			boolean deleteResult=file.delete();
			System.out.println("deleteResult = "+deleteResult);
		}else {
			System.out.println("�ļ�������");
		}
	}
	
	
	public static void readFileInfo() {
		File file=new File(path1);
		if(file.exists()) {
			//�����ļ���С�����ֽ�Ϊ��λ
			long fileSize=file.length();
			System.out.println("fileSize = "+fileSize);
			//���ش�1970-1-1 00:00:00 �������������ĺ�����
			long lastModified=file.lastModified();
			System.out.println("lastModified = "+lastModified);
			Date date=new Date(lastModified);
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate=format.format(date);
			System.out.println("modifed time : "+strDate);
			//�����̷�·����Ӧ���ַ�����ʾ��ʽ
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
		//��һ���ļ�����������
		boolean renameResult=file1.renameTo(file2);
		System.out.println("renameResult = "+renameResult);
		
	}
	
	public static void fileList() {
		File file=new File(dir);
		//���ص�ǰ�ļ����������ļ����ļ���������ɵ�����
		String [] fileList=file.list();
		System.out.println("fileList = "+fileList);
		String[] fileNames=file.list(new FilenameFilter() {
			
			/**
			 * dir:���ļ�������
			 * name:��ǰ���ڲ������ļ����ļ��е�����
			 * return:�������true���ͽ���ǰ�ļ����ļ���name���뵽fileNames�����У����򲻴���
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
	 * �о�ָ��Ŀ¼�����е��ļ����ļ��У������ļ����µ��ļ�
	 * @param file �ļ�����
	 * @param level �ļ����ڵĲ㼶
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

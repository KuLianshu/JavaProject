package domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import entity.MainBoard;
import entity.PCI;

public class AssemblerDemo02 {

	public static void main(String[] args) {
		MainBoard mainBoard=new MainBoard();
		InputStream inputSrream=Thread.currentThread().getContextClassLoader().getResourceAsStream("Config.properties");
		Properties properties=new Properties();
		try {
			properties.load(inputSrream);
			String strCardCount=properties.getProperty("cardCount");
			int cardCount=Integer.parseInt(strCardCount);
			//获取集合中元素的个数
			int size=properties.size();
			if(cardCount!=size-1) {
				throw new RuntimeException("卡的数量不匹配！");
			}
			System.out.println("size = "+size);
			for(int i=1;i<size;i++) {
				String card=properties.getProperty("card"+i);
				Class clz=Class.forName(card);
				Object cardObject=clz.newInstance();
				if(cardObject instanceof PCI) {
					PCI pci=(PCI)cardObject;
					mainBoard.use(pci);
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		

	}

}

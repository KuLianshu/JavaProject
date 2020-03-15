package domain;

import entity.MainBoard;
import entity.NetCard;
import entity.SoundCard;
import entity.VideoCard;

/**
 * ����ĺô�����ʵ��һ�仰�����ھ۵���ϡ��Ѵ��붯̬��������˴�������ȼ����˴�������
 
�����ȱ�㣬�������������ˣ���Ȼ�����Ч�ʵ����⣬��ˣ�����ʹ�÷�������Ч�ʵ͵����⣡
 * @author KuLianshu
 *
 */
public class AssemblerDemo01 {

	public static void main(String[] args) {
		
		NetCard netCard=new NetCard();
		SoundCard soundCard=new SoundCard();
		VideoCard videoCard=new VideoCard();
		MainBoard mainBoard=new MainBoard();
		
		mainBoard.use(netCard);
		System.out.println("=========");
		mainBoard.use(soundCard);
		System.out.println("=========");
		mainBoard.use(videoCard);
		
	}

}

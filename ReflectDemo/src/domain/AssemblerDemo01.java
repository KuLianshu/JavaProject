package domain;

import entity.MainBoard;
import entity.NetCard;
import entity.SoundCard;
import entity.VideoCard;

/**
 * 反射的好处，其实就一句话：高内聚低耦合。把代码动态化，提高了代码的灵活度减少了代码量！
 
反射的缺点，代码灵活度增大了，自然会带来效率的问题，因此，大量使用反射会带来效率低的问题！
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

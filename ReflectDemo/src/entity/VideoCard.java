package entity;

public class VideoCard implements PCI{

	@Override
	public void start() {
		System.out.println("显卡正在启动.....");

	}
	
	@Override
	public void run() {
		System.out.println("显卡正在显示画面...");
		
	}

	@Override
	public void stop() {
		System.out.println("显卡正在停止显示画面");

	}
}

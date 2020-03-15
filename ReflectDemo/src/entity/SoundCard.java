package entity;

public class SoundCard implements PCI{

	@Override
	public void start() {
		System.out.println("声卡正在启动.....");

	}
	
	@Override
	public void run() {
		System.out.println("声卡正在dudu....");
		
	}

	@Override
	public void stop() {
		System.out.println("声卡正在停止dudu");

	}
	
	
}

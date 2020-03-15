package entity;

public class NetCard implements PCI{
	@Override
	public void start() {
		System.out.println("网卡正在启动.....");

	}
	
	@Override
	public void run() {
		System.out.println("网卡正在发送数据....");
		
	}

	@Override
	public void stop() {
		System.out.println("网卡正在停止");

	}
}

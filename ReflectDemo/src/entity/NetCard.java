package entity;

public class NetCard implements PCI{
	@Override
	public void start() {
		System.out.println("������������.....");

	}
	
	@Override
	public void run() {
		System.out.println("�������ڷ�������....");
		
	}

	@Override
	public void stop() {
		System.out.println("��������ֹͣ");

	}
}

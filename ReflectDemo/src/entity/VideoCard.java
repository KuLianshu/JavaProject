package entity;

public class VideoCard implements PCI{

	@Override
	public void start() {
		System.out.println("�Կ���������.....");

	}
	
	@Override
	public void run() {
		System.out.println("�Կ�������ʾ����...");
		
	}

	@Override
	public void stop() {
		System.out.println("�Կ�����ֹͣ��ʾ����");

	}
}

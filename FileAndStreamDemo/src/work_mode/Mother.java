package work_mode;

public class Mother implements Work{
	
	private Work work;
	
	public Mother(Work work) {
		this.work=work;
	}
	

	@Override
	public void paint() {
		this.work.paint();
		System.out.println("�������ڸ����ӵĻ���ɫ");
		
	}

}

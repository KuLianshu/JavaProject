package work_mode;

public class Mother implements Work{
	
	private Work work;
	
	public Mother(Work work) {
		this.work=work;
	}
	

	@Override
	public void paint() {
		this.work.paint();
		System.out.println("妈妈正在给儿子的画着色");
		
	}

}

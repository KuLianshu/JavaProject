package work_mode;

public class Father implements Work{
	
	private Work work;
	
	public Father(Work work) {
		this.work=work;
	}

	@Override
	public void paint() {
		this.work.paint();
		System.out.println("爸爸给儿子的画做相框");
		
	}

}

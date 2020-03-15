package entity;

public class MainBoard {
	
	public MainBoard() {
	}
	
	public void use(PCI pci) {
		pci.start();
		pci.run();
		pci.stop();
	}
	

	
	

}

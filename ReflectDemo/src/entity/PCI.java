package entity;

/**
 * 定义PCI卡接口
 * @author KuLianshu
 *
 */
public interface PCI {
	/**
	 * PCI卡启动
	 */
	void start();
	
	/**
	 * PCI卡开始工作
	 */
	void run();
	
	/**
	 * PCI卡停止
	 */
	void stop();
}

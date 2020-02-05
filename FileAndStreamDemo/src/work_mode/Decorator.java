package work_mode;

/*
 * װ�����ģʽ������������ǿ���ܵ�һ�ֽ������.
 * 		�����ǿһ��������Ĺ���:
 * 			A:�̳�
 * 			B:װ��
 * 				
 * ��װ�ζ��������ṩһ����������.
 * װ�ζ����ڱ�װ�ζ���Ļ�������ǿ�µĹ���.
 * 
 * ����������:
 * ����Son�Ǳ�װ�ζ���,Mother��Father����װ�ζ��󣬶���Ϊ����ǿ���ӵĹ��ܶ����ڵġ�����Father�Ĵ���Ҳ��Ϊ����ǿMother�Ĺ���.
 */
public class Decorator {
	
	public static void main(String[] args) {
		
		Son son=new Son();
		son.paint();
		
		//Mother�����ζ��󣬱����ζ���son��Ϊ���캯����ʵ�δ��ݵ�Mother����
		Mother mother=new Mother(son);
		mother.paint();
		
		Father father=new Father(mother);
		father.paint();
		
	}

}

package Model;

/**
* �����߳�
* @author Zhangfan
*
*/

public class Car extends Thread{
	String name ="";
	//����Ϊ˽�б������������ݵƵ�״̬�����Ƿ�ֹͣ
	private Lighter lighter;
	public Car(String name,Lighter lighter) 
	{
		this.name=name;
		this.lighter=lighter;
	}
	
	
	public void run() {
		if (lighter.state.equals("red")) {
			System.out.println(this.name+":�ȴ���");
		}else {
			System.out.println(this.name+":ͨ���˺��̵�");
		}
	}
}

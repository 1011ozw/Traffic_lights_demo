package Model;

/**
* 车辆线程
* @author Zhangfan
*
*/

public class Car extends Thread{
	String name ="";
	//灯作为私有变量，车辆根据灯的状态决定是否停止
	private Lighter lighter;
	public Car(String name,Lighter lighter) 
	{
		this.name=name;
		this.lighter=lighter;
	}
	
	
	public void run() {
		if (lighter.state.equals("red")) {
			System.out.println(this.name+":等待中");
		}else {
			System.out.println(this.name+":通过了红绿灯");
		}
	}
}

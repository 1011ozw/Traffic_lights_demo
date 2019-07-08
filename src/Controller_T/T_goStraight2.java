package Controller_T;
//从右车道直行
import javax.swing.JLabel;

public class T_goStraight2 extends Thread{
	private int speed=50;
	private JLabel car_r2;
	private boolean run;
	private String threadName;
	private boolean flag=true;
	private boolean cargo;
	//private Thread t;
	
	public T_goStraight2(JLabel car, String name,int sp) {
		car_r2 = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
	
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run()  {
		System.out.print(getName());
		PV_goStraight2.p();
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				if(PV_goStraight2.value<-1)PV.value++;
			if (PV_goStraight2.value==0||car_r2.getBounds().x<701) {
				car_r2.setLocation((car_r2.getBounds().x-1), car_r2.getBounds().y);
			}
			if(car_r2.getBounds().x<142&&flag==true)
			{PV_goStraight2.v();
			flag=false;}
			}
			
			synchronized(this) {
				try {
					wait(speed);
				} catch(Exception e) {
					e.printStackTrace();
				}
			 }	
		   
		}   
	}
	
	public void runCar(boolean state) {

		cargo = state;
	}
}

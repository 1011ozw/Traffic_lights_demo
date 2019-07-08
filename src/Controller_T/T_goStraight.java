package Controller_T;
//从左车道直行
import javax.swing.JLabel;

import Controller.LightController_L;

public class T_goStraight extends Thread{
	private int speed=50;
	private JLabel car1;
	private boolean run;
	private String threadName;
	private boolean cargo;
	private boolean flag=true;

	//private Thread t;
	
	public T_goStraight(JLabel car, String name,int sp) {
		
		car1 = car;
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
		this.run = true;
		PV.p();
		while(run) {
			
			if(cargo) {		
				//System.out.println("value:"+PV.value);
			if(PV.value<-1)PV.value++;
				if(PV.value==0||car1.getBounds().x>142){
				if(T_LightController_L.judge_l||car1.getBounds().x>142){
					car1.setLocation((car1.getBounds().x+1), car1.getBounds().y);
					
				}
				if(car1.getBounds().x>701&&flag==true)
				{PV.v();
				flag=false;}
				}
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

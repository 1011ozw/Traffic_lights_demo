package Controller;

import javax.swing.JLabel;
import Controller.LightController_R;

public class goStraight2 extends Thread{
	private int speed=50;
	private JLabel car_s2;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public goStraight2(JLabel car, String name,int sp) {
		car_s2 = car;
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
		
		while(run) {
			
			if(cargo) {
				if(car_s2.getBounds().x>=615) {
					if(LightController_L.getLight_rs()) {
						car_s2.setLocation((car_s2.getBounds().x-1), car_s2.getBounds().y);
					}
				}
				else {
					car_s2.setLocation((car_s2.getBounds().x-1), car_s2.getBounds().y);
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

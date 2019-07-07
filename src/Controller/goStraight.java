package Controller;

import javax.swing.JLabel;
import Controller.LightController_L;

public class goStraight extends Thread {
	private int speed=50;
	private JLabel car2;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public goStraight(JLabel car, String name,int sp) {
		
		car2 = car;
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
		
		
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				
				if(car2.getBounds().x<=300) {
					if(LightController_L.getLight_rs() && !LightController_L.getLight_others()) {
						car2.setLocation((car2.getBounds().x+1), car2.getBounds().y);
					}	
				}
				else {
					car2.setLocation((car2.getBounds().x+1), car2.getBounds().y);
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

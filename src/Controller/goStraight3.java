package Controller;

import javax.swing.JLabel;
import Controller.LightController_U;

public class goStraight3 extends Thread{
	public int speed=50;
	private JLabel car2;
	private boolean run;
	private String threadName;
	
	private int pv;//pv
	
	private boolean cargo;
	//private Thread t;
	
	public goStraight3(JLabel car, String name,int sp) {
		
		car2 = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
		
		pv = PVController.getPV_U_s();//pv
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run()  {
		
		this.run = true;
		
		while(run) {
			
			pv = PVController.getPV_U_s();//pv
			
			if(cargo) {
				
				if(car2.getBounds().y<=200 && car2.getBounds().y > 105) { //before the crossing
					
					if(pv == 1) {
						if(LightController_U.getLight_rs() && !LightController_U.getLight_others()) {
							
							car2.setLocation((car2.getBounds().x), car2.getBounds().y+1);
							
						}	
					}
					
				}
				else if(car2.getBounds().y <= 105) {
					//**
					car2.setLocation((car2.getBounds().x), car2.getBounds().y+1);
				}
				else if(car2.getBounds().y > 200 && car2.getBounds().y <600) {
					//进入临界值. 资源-1
					PVController.setPV_U_s(0);
					car2.setLocation((car2.getBounds().x), car2.getBounds().y+1);
				}
				
				else {
					
					if(car2.getBounds().y == 600) {
						//走出临界区 资源+1
						PVController.setPV_U_s(1);
					}
					
					car2.setLocation((car2.getBounds().x), car2.getBounds().y+1);
					
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

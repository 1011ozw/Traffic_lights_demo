package Controller;

import javax.swing.JLabel;
import Controller.LightController_L;

public class goStraight extends Thread {
	public int speed=50;
	private JLabel car2;
	private boolean run;
	private String threadName;
	
	private int pv;//pv
	
	private boolean cargo;
	//private Thread t;
	
	public goStraight(JLabel car, String name,int sp) {
		
		car2 = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
		
		pv = PVController.getPV_L_s();//pv
		
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run()  {
		
		
		this.run = true;
		
		while(run) {
			
			pv = PVController.getPV_L_s();//pv
			
			if(cargo) {
				
				if(car2.getBounds().x<=300 && car2.getBounds().x > 140) {
					
					if(pv == 1) {
						if(LightController_L.getLight_rs() && !LightController_L.getLight_others()) {
							car2.setLocation((car2.getBounds().x+1), car2.getBounds().y);
						}	
					}
					
					
				}
				
				else if(car2.getBounds().x <= 140) {
					car2.setLocation((car2.getBounds().x+1), car2.getBounds().y);
				}
				
				else if(car2.getBounds().x>300 && car2.getBounds().x<620){
					
					//进入临界值. 资源-1
					PVController.setPV_L_s(0);
					
					car2.setLocation((car2.getBounds().x+1), car2.getBounds().y);
					
					}
				
				else {
					
					if(car2.getBounds().x == 620) {
						//走出临界区 资源+1
						PVController.setPV_L_s(1);
					}
					
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

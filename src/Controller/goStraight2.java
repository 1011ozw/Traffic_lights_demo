package Controller;

import javax.swing.JLabel;
import Controller.LightController_R;

public class goStraight2 extends Thread{
	private static int speed=50;
	private JLabel car_s2;
	private boolean run;
	private String threadName;
	
	private int pv;//pv
	
	private static boolean cargo;
	//private Thread t;
	
	public goStraight2(JLabel car, String name,int sp) {
		car_s2 = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
		
		pv = PVController.getPV_R_s();//pv
	
	}

	public static int getSpeed() {
		return speed;
	}
	public static void setSpeed(int new_speed) {
		speed = new_speed;
	}
	
	public void setRun(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run()  {
	
		this.run = true;
		
		while(run) {
			
			pv = PVController.getPV_R_s();//pv
			
			if(cargo) {
				if(car_s2.getBounds().x>=615 && car_s2.getBounds().x<691) {
					
					if(pv == 1) {
						if(LightController_R.getLight_rs() && !LightController_R.getLight_others()) {
							car_s2.setLocation((car_s2.getBounds().x-1), car_s2.getBounds().y);
						}
					}
					
				}
				else if(car_s2.getBounds().x >= 691) {
					car_s2.setLocation((car_s2.getBounds().x-1), car_s2.getBounds().y);
				}
				else if(car_s2.getBounds().x < 615 && car_s2.getBounds().x > 230) {
					//进入临界值. 资源-1
					PVController.setPV_R_s(0);
					car_s2.setLocation((car_s2.getBounds().x-1), car_s2.getBounds().y);
				}
				else {
					if(car_s2.getBounds().x == 230) {
						//走出临界区 资源+1
						PVController.setPV_R_s(1);
					}
					
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
	
	public static void runCar(boolean state) {

		cargo = state;
	}
	
}

package Controller;

import javax.swing.JLabel;

public class goStraight4 extends Thread{
	private static int speed=50;
	private JLabel car2;
	private boolean run;
	private String threadName;
	
	private int pv;//pv
	
	private static boolean cargo;
	//private Thread t;
	
	public goStraight4(JLabel car, String name,int sp) {
		
		car2 = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
		
		pv = PVController.getPV_D_s();//pv
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
			
			pv = PVController.getPV_D_s();//pv
			
			if(cargo) {
				
				if(car2.getBounds().y>=590 && car2.getBounds().y<690) { //before the crossing
					
					if(pv == 1) {
						if(LightController_D.getLight_rs() && !LightController_D.getLight_others()) {
						
							car2.setLocation((car2.getBounds().x), car2.getBounds().y-1);
						
						}	

					}
				}
				else if(car2.getBounds().y >= 690) {
					car2.setLocation((car2.getBounds().x), car2.getBounds().y-1);
				}
				else if(car2.getBounds().y<590 && car2.getBounds().y>200) {
					//进入临界值. 资源-1
					PVController.setPV_D_s(0);
					
					car2.setLocation((car2.getBounds().x), car2.getBounds().y-1);
				}
				else {
					
					if(car2.getBounds().y == 200) {
						//走出临界区 资源+1
						PVController.setPV_D_s(1);
					}
					
					car2.setLocation((car2.getBounds().x), car2.getBounds().y-1);
					
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

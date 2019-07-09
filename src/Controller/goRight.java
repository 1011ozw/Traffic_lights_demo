package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goRight extends Thread {
	private static int speed=50;
	private JLabel car_right;
	private boolean run;
	private String threadName;
	
	private int pv;//pv
	
	private boolean cargo;
	//private Thread t;
	
	public goRight(JLabel car, String name, int sp) {
		car_right = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
	
		pv = PVController.getPV_L_r();//pv
		
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
		//System.out.print(getName());
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car2_down.png"));
		
		
		this.run = true;
		
		while(run) {
			
			pv = PVController.getPV_L_r();//pv
			
			if(cargo) {
				
				if(car_right.getBounds().x<=310) {
					
					if(car_right.getBounds().x <= 230 && car_right.getBounds().x > 142 ) {
						
						if(pv == 1) {
							if(LightController_L.getLight_r()) {
								car_right.setLocation((car_right.getBounds().x+1), car_right.getBounds().y);
							}
						}
					}
					
					else if(car_right.getBounds().x <= 142) {
						car_right.setLocation((car_right.getBounds().x+1), car_right.getBounds().y);
					}
					
					else {
						
						//进入临界值. 资源-1
						PVController.setPV_L_r(0);
						
						car_right.setLocation((car_right.getBounds().x+1), car_right.getBounds().y);
					}
					
					
				}
				else {
					car_right.setIcon(icon);
					car_right.setBounds(car_right.getBounds().x,car_right.getBounds().y,38,70); 
					car_right.setLocation((car_right.getBounds().x), car_right.getBounds().y+1);
					
					if(car_right.getBounds().y == 665) {
						
						//走出临界区 资源+1
						
						PVController.setPV_L_r(1);
						
						
					}
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

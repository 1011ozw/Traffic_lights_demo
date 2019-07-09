package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goLeft2 extends Thread{
	
	private static int speed=50;
	private JLabel car1;
	private boolean run;
	private String threadName;
	
	private int pv;//pv
	
	private boolean cargo;
	//private Thread t;
	
	public goLeft2(JLabel car, String name,int sp) {
		car1 = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
		
		pv = PVController.getPV_R_l();//pv
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
		ImageIcon icon=new ImageIcon(goLeft2.class.getResource("/img/car4_R_d.png"));
		//System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			pv = PVController.getPV_R_l();//pv
			
			if(cargo) {
				if(car1.getBounds().x>=410) {
					
					//judge traffic light is red or not before crossing
					if(car1.getBounds().x>=615 && car1.getBounds().x < 691) {
						
						if(pv == 1) {
							
							if(LightController_R.getLight_l() && !LightController_R.getLight_others()) {
								car1.setLocation((car1.getBounds().x-1), car1.getBounds().y);
							}
							
						}
						
						
					}
					else if(car1.getBounds().x >= 691) {
						car1.setLocation((car1.getBounds().x-1), car1.getBounds().y);
					}
					
					else {
						
						//进入临界值. 资源-1
						PVController.setPV_R_l(0);
						
						car1.setLocation((car1.getBounds().x-1), car1.getBounds().y);
					}
				
				}
				else {
					car1.setIcon(icon);
					
					if(car1.getBounds().y == 386) {
						car1.setBounds(car1.getBounds().x,car1.getBounds().y,38,70); //change the height and width
					}
					
					car1.setLocation((car1.getBounds().x), car1.getBounds().y+1);	
					
					if(car1.getBounds().y == 666) {
						
						//走出临界区 资源+1
						
						PVController.setPV_R_l(1);
						
						
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

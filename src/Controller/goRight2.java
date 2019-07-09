package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goRight2 extends Thread{
	public int speed=50;
	private JLabel car_right;
	private boolean run;
	private String threadName;
	
	private int pv;//pv
	
	private boolean cargo;
	//private Thread t;
	
	public goRight2(JLabel car, String name,int sp) {
		car_right = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
		
		pv = PVController.getPV_R_r();//pv
		
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run()  {
		//System.out.print(getName());
		ImageIcon icon=new ImageIcon(goRight2.class.getResource("/img/car7_D_s.png"));
		
		
		this.run = true;
		
		while(run) {
			
			pv = PVController.getPV_R_r();//pv
			
			if(cargo) {
				if(car_right.getBounds().x>=565) {
					
					if(car_right.getBounds().x<691 && car_right.getBounds().x>=620) {
						if(pv == 1) {
							if(LightController_R.getLight_r()) {
								car_right.setLocation((car_right.getBounds().x-1), car_right.getBounds().y);
							}
						}
					}
					else if(car_right.getBounds().x>=691) {
						car_right.setLocation((car_right.getBounds().x-1), car_right.getBounds().y);
					}
					else {
						//进入临界值. 资源-1
						PVController.setPV_R_r(0);
						car_right.setLocation((car_right.getBounds().x-1), car_right.getBounds().y);
					}
				}
				
				else {
					car_right.setIcon(icon);
					
					if(car_right.getBounds().y == 295) {
						car_right.setBounds(car_right.getBounds().x,car_right.getBounds().y-35,38,70); 
					}
					car_right.setBounds(car_right.getBounds().x,car_right.getBounds().y,38,70); 
					car_right.setLocation((car_right.getBounds().x), car_right.getBounds().y-1);
					
					if(car_right.getBounds().y ==160) {
						
						//走出临界区 资源+1
						
						PVController.setPV_R_r(1);
						
						
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

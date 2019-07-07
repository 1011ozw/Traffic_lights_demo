package Controller;

import javax.swing.ImageIcon;
import Controller.LightController_L;

import javax.swing.JLabel;

public class goLeft extends Thread {
	private int speed=50;
	private JLabel car1;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public goLeft(JLabel car, String name,int sp) {
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
		ImageIcon icon=new ImageIcon(goLeft.class.getResource("/img/car3_up.png"));
		//System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				if(car1.getBounds().x<=465) {
					
					//judge traffic light is red or not before crossing
					if(car1.getBounds().x<=300) {
						
						if(LightController_L.getLight_l() && !LightController_L.getLight_others()) {
							car1.setLocation((car1.getBounds().x+1), car1.getBounds().y);
						}
						
					}
					else {
						car1.setLocation((car1.getBounds().x+1), car1.getBounds().y);
					}
				
				}
				else {
					car1.setIcon(icon);
					
					if(car1.getBounds().y == 429) {
						car1.setBounds(car1.getBounds().x,car1.getBounds().y-35,38,70); 
					}
					
					car1.setLocation((car1.getBounds().x), car1.getBounds().y-1);	
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

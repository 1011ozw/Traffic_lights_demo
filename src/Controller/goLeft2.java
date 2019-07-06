package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goLeft2 extends Thread{
	
	private int speed=50;
	private JLabel car1;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public goLeft2(JLabel car, String name,int sp) {
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
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car4_R_d.png"));
		System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			if(cargo) 
				if(car1.getBounds().x>=410) {
					
					//judge traffic light is red or not before crossing
					if(car1.getBounds().x>=615) {
						
						if(LightController_L.getLight_l()) {
							car1.setLocation((car1.getBounds().x-1), car1.getBounds().y);
						}
						
					}
					
					else {
						car1.setLocation((car1.getBounds().x-1), car1.getBounds().y);
					}
				
				}
				else {
					car1.setIcon(icon);
					
					if(car1.getBounds().y == 386) {
						car1.setBounds(car1.getBounds().x,car1.getBounds().y,38,70); 
					}
					
					car1.setLocation((car1.getBounds().x), car1.getBounds().y+1);	
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

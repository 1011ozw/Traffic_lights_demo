package Controller;

import javax.swing.JLabel;

public class goStraight4 extends Thread{
	private int speed=50;
	private JLabel car2;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public goStraight4(JLabel car, String name,int sp) {
		
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
				
				if(car2.getBounds().y>=590) { //before the crossing
					
					if(LightController_D.getLight_rs() && !LightController_D.getLight_others()) {
						
						car2.setLocation((car2.getBounds().x), car2.getBounds().y-1);
						
					}	
				}
				
				else {
					
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
	
	public void runCar(boolean state) {

		cargo = state;
	}
}
package Controller;

import javax.swing.JLabel;

public class T_goStraight extends Thread{
	private int speed=50;
	private JLabel car1;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public T_goStraight(JLabel car, String name,int sp) {
		
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
		System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				
				if(LightController_L.getLight_rs()) {
					car1.setLocation((car1.getBounds().x+1), car1.getBounds().y);
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

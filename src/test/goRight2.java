package test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goRight2 extends Thread{
	private JLabel car_right;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public goRight2(JLabel car, String name) {
		car_right = car;
		threadName = name;
		run = false;
		cargo = true;
	
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run()  {
		System.out.print(getName());
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car3_up.png"));
		
		
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				if(car_right.getBounds().x>=370) {
					car_right.setLocation((car_right.getBounds().x-1), car_right.getBounds().y);
				}
				else {
					car_right.setIcon(icon);
					car_right.setBounds(car_right.getBounds().x,car_right.getBounds().y,38,70); 
					car_right.setLocation((car_right.getBounds().x), car_right.getBounds().y-1);
				}
				
			}
				
			
			synchronized(this) {
				try {
					wait(50);
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

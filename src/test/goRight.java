package test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goRight extends Thread {
	private JLabel car_right;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public goRight(JLabel car, String name) {
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
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car2_down.png"));
		
		
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				if(car_right.getBounds().x<=200) {
					car_right.setLocation((car_right.getBounds().x+1), car_right.getBounds().y);
				}
				else {
					car_right.setIcon(icon);
					car_right.setBounds(car_right.getBounds().x,car_right.getBounds().y,38,70); 
					car_right.setLocation((car_right.getBounds().x), car_right.getBounds().y+1);
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

package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goRight2 extends Thread{
	private int speed=50;
	private JLabel car_right;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public goRight2(JLabel car, String name,int sp) {
		car_right = car;
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
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car3_up.png"));
		
		
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				if(car_right.getBounds().x>=560) {
					car_right.setLocation((car_right.getBounds().x-1), car_right.getBounds().y);
				}
				else {
					car_right.setIcon(icon);
					
					if(car_right.getBounds().y == 295) {
						car_right.setBounds(car_right.getBounds().x,car_right.getBounds().y-35,38,70); 
					}
					car_right.setBounds(car_right.getBounds().x,car_right.getBounds().y,38,70); 
					car_right.setLocation((car_right.getBounds().x), car_right.getBounds().y-1);
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

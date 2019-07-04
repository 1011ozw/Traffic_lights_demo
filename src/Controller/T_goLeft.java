package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class T_goLeft extends Thread {
	private int speed=50;
	private JLabel car_down1;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public T_goLeft(JLabel car, String name,int sp) {
		car_down1 = car;
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
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car3_R_road.png"));
		System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			if(cargo) 
				if(car_down1.getBounds().y>=179) {
				car_down1.setLocation(car_down1.getBounds().x, (car_down1.getBounds().y-1));
				}
				else {
					car_down1.setIcon(icon);
				
					if(car_down1.getBounds().x==473)
						car_down1.setBounds(car_down1.getBounds().x,(car_down1.getBounds().y),70,38); 
					
					
					car_down1.setLocation((car_down1.getBounds().x-1), car_down1.getBounds().y);	
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
	
	/*
	public void start () {
		/*
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	      
	   }
	*/

}

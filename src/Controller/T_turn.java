package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class T_turn extends Thread {
	private int speed=50;
	private JLabel car3;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public T_turn(JLabel car, String name,int sp) {
		car3 = car;
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
		ImageIcon icon1=new ImageIcon(goRight.class.getResource("/img/car3_up.png"));
		ImageIcon icon2=new ImageIcon(goRight.class.getResource("/img/car3_R_road.png"));
		System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			if(cargo) 
				if(car3.getBounds().x<=296&&car3.getBounds().y==277) {
				car3.setLocation(car3.getBounds().x+1, (car3.getBounds().y));
			
				}
				if(car3.getBounds().x>296&&car3.getBounds().y>=199){
					car3.setIcon(icon1);
				
					if(car3.getBounds().y==277)
						car3.setBounds(car3.getBounds().x,(car3.getBounds().y)-20,38,70); 
					
					
					car3.setLocation((car3.getBounds().x), car3.getBounds().y-1);	
					
				}
				
			if(car3.getBounds().x<=297&&car3.getBounds().y==200) {
			
					car3.setIcon(icon2);
				
					if(car3.getBounds().x==297)
						car3.setBounds(car3.getBounds().x,(car3.getBounds().y),70,38); 
					
					
					car3.setLocation((car3.getBounds().x-1), car3.getBounds().y);	
					
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

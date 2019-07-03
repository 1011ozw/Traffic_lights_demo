package test;

import javax.swing.ImageIcon;
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
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car3_up.png"));
		System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			if(cargo) 
				if(car1.getBounds().x<=300) {
				car1.setLocation((car1.getBounds().x+1), car1.getBounds().y);
				}
				else 
				{car1.setIcon(icon);
				car1.setLocation((car1.getBounds().x), car1.getBounds().y-1);	
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

package test;

import javax.swing.JLabel;

public class goStraight extends Thread {
	
	private JLabel car1;
	private boolean run;
	private String threadName;
	private Thread t;
	
	public goStraight(JLabel car, String name) {
		car1 = car;
		threadName = name;
		run = false;
	
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run()  {
		this.run = true;
		while(run) {
			car1.setLocation((car1.getBounds().x+1), car1.getBounds().y);
			
			synchronized(this) {
				try {
					wait(50);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}	
		}   
	}
	
	public void start () {
		
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	      
	   }
	

}

package test;

import javax.swing.JLabel;

public class goStraight extends Thread {
	
	private JLabel car1;
	
	private boolean run;
	
	public goStraight(JLabel car) {
		car1 = car;
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
					wait(100);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
        
	}

}

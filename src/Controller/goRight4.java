package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goRight4 extends Thread{
	private int speed=50;
	private JLabel car1;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public goRight4(JLabel car, String name,int sp) {
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
		ImageIcon icon=new ImageIcon(goRight4.class.getResource("/img/car6_D_r.png"));
		//System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				if(car1.getBounds().y>=532) {
					
					car1.setLocation((car1.getBounds().x), car1.getBounds().y-1);
				
				}
				else {
					car1.setIcon(icon);
					
					if(car1.getBounds().x == 562) {
						car1.setBounds(car1.getBounds().x,car1.getBounds().y,70,38); //change the height and width
					}
					
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

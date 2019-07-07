package Controller_T;
//�³���ת
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controller.goRight;

public class T_goRight2 extends Thread{
	private int speed=50;
	private JLabel car_right;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public T_goRight2(JLabel car, String name,int sp) {
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
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car3.png"));
		
		
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				if(car_right.getBounds().y>=402) {
					car_right.setLocation((car_right.getBounds().x), car_right.getBounds().y-1);
				}
				else {
					car_right.setIcon(icon);
					
					if(car_right.getBounds().x == 142) {
						car_right.setBounds(car_right.getBounds().x-35,car_right.getBounds().y,70,38); 
					}
					car_right.setBounds(car_right.getBounds().x,car_right.getBounds().y,70,38); 
					car_right.setLocation((car_right.getBounds().x+1), car_right.getBounds().y);
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
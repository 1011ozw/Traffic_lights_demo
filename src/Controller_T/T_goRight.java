package Controller_T;
//×ö³µÓÒ×ª
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controller.goRight;

public class T_goRight extends Thread{
	private int speed=50;
	private JLabel car_right;
	private boolean run;
	private String threadName;
	private boolean flag=true;
	private boolean cargo;
	//private Thread t;
	
	public T_goRight(JLabel car, String name, int sp) {
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
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car2_down.png"));
		PV_goRight.p();
		
		this.run = true;
		
		while(run) {
			
			
			if(cargo) {
				if(PV_goRight.value<-1)PV.value++;
				if(PV_goRight.value==0||car_right .getBounds().x>142){
				if(car_right.getBounds().x<=310) {
					car_right.setLocation((car_right.getBounds().x+1), car_right.getBounds().y);
				}
				else {
					car_right.setIcon(icon);
					car_right.setBounds(car_right.getBounds().x,car_right.getBounds().y,38,70); 
					car_right.setLocation((car_right.getBounds().x), car_right.getBounds().y+1);
				}
				if(car_right.getBounds().y>555&&flag==true)
				{PV_goRight.v();
				flag=false;}
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

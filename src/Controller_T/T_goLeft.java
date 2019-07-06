package Controller_T;
//车辆从下车道左转
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controller.goRight;

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
		cargo = true;  //判断车能否前行
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
			
			if(cargo){ 
				if(T_LightController_D.judge_d||car_down1.getBounds().y<583){
				if(car_down1.getBounds().y>=200) {
				car_down1.setLocation(car_down1.getBounds().x, (car_down1.getBounds().y-1));
				}
				else {
					car_down1.setIcon(icon);
				
					if(car_down1.getBounds().x==473)
						car_down1.setBounds(car_down1.getBounds().x,(car_down1.getBounds().y)+20,70,38); 
					
					
					car_down1.setLocation((car_down1.getBounds().x-1), car_down1.getBounds().y);	
				}
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

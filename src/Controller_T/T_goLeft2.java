package Controller_T;
//车辆从右车道左转
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controller.goRight;

public class T_goLeft2 extends Thread{
	private int speed=50;
	private JLabel car_s2;
	private boolean run;
	private String threadName;
	static boolean already_pass=false;
	private boolean flag=true;
	
	private boolean cargo;
	//private Thread t;
	
	public T_goLeft2(JLabel car, String name,int sp) {
		car_s2 = car;
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
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car3_down.png"));
		System.out.print(getName());
		PV_goLeft2.p();;
		this.run = true;
		
		while(run) {
			
			if(cargo) {
				if (car_s2.getBounds().x<=748 && car_s2.getBounds().x>717) {
					car_s2.setLocation(car_s2.getBounds().x-1, (car_s2.getBounds().y));
				}
				if(PV_goLeft2.value<-1)PV_goLeft2.value++;
				if (PV_goLeft2.value==0||car_s2.getBounds().x<717) {
				if(already_pass)T_LightController_R.judge_r=true;
				if(T_LightController_R.judge_r||car_s2.getBounds().x<717){
				if(car_s2.getBounds().x>=379) {
					car_s2.setLocation(car_s2.getBounds().x-1, (car_s2.getBounds().y));
				}
				else {
					car_s2.setIcon(icon);
				
					if(car_s2.getBounds().y==214)
						car_s2.setBounds(car_s2.getBounds().x,(car_s2.getBounds().y),38,70); 
					
					
					car_s2.setLocation((car_s2.getBounds().x), car_s2.getBounds().y+1);	
				}
				if(car_s2.getBounds().y>555&&flag==true)
				{PV_goLeft2.v();
				flag=false;}
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

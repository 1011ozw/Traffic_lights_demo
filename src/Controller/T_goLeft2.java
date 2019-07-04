package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class T_goLeft2 extends Thread{
	private int speed=50;
	private JLabel car_s2;
	private boolean run;
	private String threadName;
	
	private boolean cargo;
	//private Thread t;
	
	public T_goLeft2(JLabel car, String name,int sp) {
		car_s2 = car;
		threadName = name;
		run = false;
		cargo = true;  //�жϳ��ܷ�ǰ��
		speed=sp;
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run()  {
		ImageIcon icon=new ImageIcon(goRight.class.getResource("/img/car3_down.png"));
		System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			if(cargo) 
				if(car_s2.getBounds().x>=379) {
					car_s2.setLocation(car_s2.getBounds().x-1, (car_s2.getBounds().y));
				}
				else {
					car_s2.setIcon(icon);
				
					if(car_s2.getBounds().y==214)
						car_s2.setBounds(car_s2.getBounds().x,(car_s2.getBounds().y),38,70); 
					
					
					car_s2.setLocation((car_s2.getBounds().x), car_s2.getBounds().y+1);	
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

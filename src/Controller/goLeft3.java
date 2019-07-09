package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goLeft3 extends Thread{

	public int speed=50;
	private JLabel car1;
	private boolean run;
	private String threadName;
	
	private int pv;//pv
	
	private boolean cargo;
	//private Thread t;
	
	public goLeft3(JLabel car, String name,int sp) {
		car1 = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
		
		pv = PVController.getPV_U_l();//pv
		
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run()  {
		ImageIcon icon=new ImageIcon(goLeft3.class.getResource("/img/car5_U_l.png"));
		//System.out.print(getName());
		
		this.run = true;
		
		while(run) {
			
			pv = PVController.getPV_U_l();//pv
			
			if(cargo) {
				if(car1.getBounds().y<=435) {
					
					//judge traffic light is red or not before crossing
					if(car1.getBounds().y<=200 && car1.getBounds().y > 105) {
						
						//�ڵ�һ��λʱ,�ж���Դ����,�Ƿ����; ����: pv = 1
						if(pv == 1) {
							if(LightController_U.getLight_l() && !LightController_U.getLight_others()) {
								car1.setLocation((car1.getBounds().x), car1.getBounds().y+1);
							}
						}
						
					}
					else if(car1.getBounds().y<=105) {
						car1.setLocation((car1.getBounds().x), car1.getBounds().y+1);
					}
					else {
						//�����ٽ�ֵ. ��Դ-1
						PVController.setPV_U_l(0);
						
						car1.setLocation((car1.getBounds().x), car1.getBounds().y+1);
					}
				
				}
				else {
					car1.setIcon(icon);
					
					if(car1.getBounds().x == 410) {
						car1.setBounds(car1.getBounds().x,car1.getBounds().y,70,54); //change the height and width
					}
					
					car1.setLocation((car1.getBounds().x+1), car1.getBounds().y);	
					
					if(car1.getBounds().x == 690) {
						
						//�߳��ٽ��� ��Դ+1
						
						PVController.setPV_U_l(1);
						
						
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

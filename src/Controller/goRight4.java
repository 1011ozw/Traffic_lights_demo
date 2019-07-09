package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class goRight4 extends Thread{
	public int speed=50;
	private JLabel car1;
	private boolean run;
	private String threadName;
	
	private int pv;//pv
	
	private boolean cargo;
	//private Thread t;
	
	public goRight4(JLabel car, String name,int sp) {
		car1 = car;
		threadName = name;
		run = false;
		cargo = true;
		speed=sp;
		
		pv = PVController.getPV_D_r();//pv
		
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
			
			pv = PVController.getPV_D_r();//pv
			
			if(cargo) {
				if(car1.getBounds().y>=532) {
					
					if(car1.getBounds().y>=600 && car1.getBounds().y<690) {
						
						if(pv == 1) {
							if(LightController_D.getLight_r()) {
								car1.setLocation((car1.getBounds().x), car1.getBounds().y-1);
							}
						}
					}
					else if(car1.getBounds().y >= 690) {
						car1.setLocation((car1.getBounds().x), car1.getBounds().y-1);
					}
					else {
						//进入临界值. 资源-1
						PVController.setPV_D_r(0);
						
						car1.setLocation((car1.getBounds().x), car1.getBounds().y-1);
					}

				}
				else {
					car1.setIcon(icon);
					
					if(car1.getBounds().x == 562) {
						car1.setBounds(car1.getBounds().x,car1.getBounds().y,70,38); //change the height and width
					}
					
					car1.setLocation((car1.getBounds().x+1), car1.getBounds().y);	
					
					if(car1.getBounds().x == 685) {
						
						//走出临界区 资源+1
						
						PVController.setPV_D_r(1);
						
						
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

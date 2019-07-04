package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LightController_L extends Thread{
	
	private JLabel lighticon;
	private boolean status;
	private int combo;// every two turns changes to other roads
	private boolean others;// T for cars on other roads to drive
	
	private static boolean go_l;
	private static boolean go_s_r;
	
	public LightController_L(JLabel light) {
		status = true; //for thread to keep running 
		go_l = true;
		go_s_r = false;
		
		combo = 0;
		others = false;
		
		lighticon = light;
	}
	
	public static boolean getLight_l() {
		return !go_l;
	}
	
	public static boolean getLight_rs() {
		return !go_s_r;
	}
	
	@Override
	public void run() {
		ImageIcon light_stop = new ImageIcon(LightController_L.class.getResource("/img/light_L_off.png"));
		ImageIcon light_L = new ImageIcon(LightController_L.class.getResource("/img/light_L_l.png"));
		ImageIcon light_RS = new ImageIcon(LightController_L.class.getResource("/img/light_L_r+s.png"));
		
		this.status = true;
		
		while(status) {
			
			if(!others) {//other roads is not active
				
				if(go_s_r) {
					lighticon.setIcon(light_RS);
				}
				else if (go_l) {
					lighticon.setIcon(light_L);
				}
				
				combo++;
				System.out.print(combo);
				
				if(combo == 2) {
					others = !others;
					combo = 0;
				}
				
			}
			
			else {
				
				lighticon.setIcon(light_stop);
				
				combo++;
				if(combo == 2) {
					others = !others;
					combo = 0;
				}
			}
			
			synchronized(this) {
				try {
					
					go_l = !go_l;
					go_s_r = !go_s_r;
					wait(10000);
				} catch(Exception e) {
					e.printStackTrace();
				}
			 }	
		}
		
	}
	
}

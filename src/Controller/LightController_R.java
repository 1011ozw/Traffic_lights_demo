package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LightController_R extends Thread{

	private JLabel lighticon;
	
	private boolean status;
	private int combo;// every two turns changes to other roads
	private static boolean others_r;// T for cars on other roads to drive
	
	private static boolean go_l;
	private static boolean go_s;
	
	public LightController_R(JLabel light) {
		status = true; //for thread to keep running 
		go_l = true;
		go_s = false;
		
		combo = 1;
		others_r = false;
		
		lighticon = light;
	}
	
	public static boolean getLight_others() {
		return others_r;
	}
	
	public static boolean getLight_l() {
		return go_l;
	}
	
	public static boolean getLight_rs() {
		return go_s;
	}
	
	@Override
	public void run() {
		ImageIcon light_stop = new ImageIcon(LightController_R.class.getResource("/img/light_R_off.png"));
		ImageIcon light_L = new ImageIcon(LightController_R.class.getResource("/img/light_R_l.png"));
		ImageIcon light_RS = new ImageIcon(LightController_R.class.getResource("/img/light_R_r+s.png"));
		
		this.status = true;
		
		while(status) {
		
			if(combo <= 0) {
				others_r = true;
				
				go_l = false;
				go_s = false;
			}
			else if(combo == 1) {
				go_l = true;
				
				others_r = false;
				go_s = false;
			}
			else if(combo == 2) {
				go_s = true;
				
				others_r = false;
				go_l = false;
			}
			else {
				combo = -1;
			}
			
			
			if(!others_r) {//other roads is not active
				
				if(go_s) {
					lighticon.setIcon(light_RS);
					combo++;// 2 turns to change other roads
				}
				else if (go_l) {
					lighticon.setIcon(light_L);
					combo++;// 2 turns to change other roads
				}
			}
			
			else{//if others_l is true
				
				lighticon.setIcon(light_stop);
				
				combo++;

			}
			
			//--------
			synchronized(this) {
				try {
					
					wait(10000);
				} 
				catch(Exception e) {
					e.printStackTrace();
				}
			 }	
			//------
			
		}
	}
}
	

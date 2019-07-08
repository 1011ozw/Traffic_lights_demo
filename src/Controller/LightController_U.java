package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LightController_U extends Thread{
	private JLabel lighticon;
	private boolean status;
	private int combo;// every two turns changes to other roads
	private static boolean others_u;// T for cars on other roads to drive
	
	private static boolean go_l;
	private static boolean go_s_r;
	private static boolean go_r;
	
	public LightController_U(JLabel light) {
		status = true; //for thread to keep running 
		go_l = false;
		go_s_r = false;
		go_r = false;
		
		combo = -1;
		others_u = true;
		
		lighticon = light;
	}
	
	public static boolean getLight_l() {
		return go_l;
	}
	
	public static boolean getLight_r() {
		return go_r;
	}
	
	public static boolean getLight_rs() {
		return go_s_r;
	}
	
	public static boolean getLight_others() {
		
		return others_u;
	}
	
	@Override
	public void run() {
		ImageIcon light_stop = new ImageIcon(LightController_U.class.getResource("/img/light_U_off.png"));
		ImageIcon light_L = new ImageIcon(LightController_U.class.getResource("/img/light_U_l.png"));
		ImageIcon light_RS = new ImageIcon(LightController_U.class.getResource("/img/light_U_r+s.png"));
		
		this.status = true;
		go_r = true;
		
		while(status) {
			
			//combo:  -1, 0=others drive left and straight; 1=go left; 2=go straight;
			if(combo <= 0) {
				others_u = true;
				
				go_l = false;
				go_s_r = false;
			}
			else if(combo == 1) {
				go_l = true;
				
				others_u = false;
				go_s_r = false;
			}
			else if(combo == 2) {
				go_s_r = true;
				
				others_u = false;
				go_l = false;
			}
			else {
				combo = -1;
			}
			
			
			if(!others_u) {//other roads is not active
				
				if(go_s_r) {
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
			
			synchronized(this) {
				try {
					
					wait(10000);
				} catch(Exception e) {
					e.printStackTrace();
				}
			 }	
		}
		
	}
}

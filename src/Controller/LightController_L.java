package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LightController_L extends Thread{
	
	private JLabel lighticon;
	private boolean status;
	
	private static int combo;// every two turns changes to other roads
	private static int speed = 10000;
	
	private static boolean others_l;// T for cars on other roads to drive
	
	private static boolean go_l;
	private static boolean go_s_r;
	private static boolean go_r;
	
	public LightController_L(JLabel light) {
		status = true; //for thread to keep running 
		go_l = false;
		go_s_r = false;
		
		go_r = false;
		
		speed = 10000;
		
		combo = 1;
		others_l = false;
		
		lighticon = light;
	}
	
	public static void setSpeed(int new_speed) {
		speed = new_speed;
	}
	
	public static void setCombo(int new_combo) {
		combo = new_combo;
	}
	public static int getCombo() {
		return combo;
	}
	
	public static boolean getLight_r() {
		return go_r;
	}
	
	public static boolean getLight_l() {
		return go_l;
	}
	
	public static boolean getLight_rs() {
		return go_s_r;
	}
	
	public static boolean getLight_others() {
		return others_l;
	}
	
	@Override
	public void run() {
		ImageIcon light_stop = new ImageIcon(LightController_L.class.getResource("/img/light_L_off.png"));
		ImageIcon light_L = new ImageIcon(LightController_L.class.getResource("/img/light_L_l.png"));
		ImageIcon light_RS = new ImageIcon(LightController_L.class.getResource("/img/light_L_r+s.png"));
		
		this.status = true;
		go_r = true;
		
		
		if(TestWindowBuilder.free == 666) {
			//正常情况
			//正常情况循环开始
			while(status) {
				
				//combo:  -1, 0=others drive left and straight; 1=go left; 2=go straight;
				if(combo <= 0) {
					others_l = true;
					
					go_l = false;
					go_s_r = false;
				}
				else if(combo == 1) {
					go_l = true;
					
					others_l = false;
					go_s_r = false;
				}
				else if(combo == 2) {
					go_s_r = true;
					
					others_l = false;
					go_l = false;
				}
				else {
					combo = -1;
					others_l = true;
				}
				
				
				if(!others_l) {//other roads is not active
					
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
						
						wait(speed);
					} catch(Exception e) {
						e.printStackTrace();
					}
				 }	
			}
			//正常情况循环结束↑
			
		}
		else if(TestWindowBuilder.free == 00) {
			//南北向左转
			combo = 1;
			go_l = true;
			
			others_l = false;
			go_s_r = false;
			
			lighticon.setIcon(light_L);
			
		}
		else if(TestWindowBuilder.free == 01) {
			//南北向直行
			combo = 2;
			go_s_r = true;
			
			others_l = false;
			go_l = false;
			
			lighticon.setIcon(light_RS);
		}
		else if(TestWindowBuilder.free == 10) {
			//东西向左转
			combo = -1;
			others_l = true;
			
			go_l = false;
			go_s_r = false;
			
			lighticon.setIcon(light_stop);
		}
		else if(TestWindowBuilder.free == 11) {
			//东西向直行
			combo = 0;
			others_l = true;
			
			go_l = false;
			go_s_r = false;
			
			lighticon.setIcon(light_stop);
			
		}
		
		
		
	}
	
}

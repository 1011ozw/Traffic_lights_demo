package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LightController_R extends Thread{

	private JLabel lighticon;
	
	private boolean status;
	private static int combo;// every two turns changes to other roads
	
	private static int speed = 10000;
	
	private static boolean others_r;// T for cars on other roads to drive
	
	
	private static boolean go_l;
	private static boolean go_s;
	private static boolean go_r;
	
	public LightController_R(JLabel light) {
		status = true; //for thread to keep running 
		go_l = false;
		go_s = false;
		go_r = false;
		
		speed = 10000;
		combo = 1;
		others_r = false;
		
		lighticon = light;
	}
	
	public static int getSpeed() {
		return speed;
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
	
	public static boolean getLight_others() {
		return others_r;
	}
	
	public static boolean getLight_l() {
		return go_l;
	}
	
	public static boolean getLight_r() {
		return go_r;
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
		go_r = true;
		
		if(TestWindowBuilder.free == 666) {
			//正常情况
			//正常情况循环开始
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
					others_r = true;
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
			//正常情况循环结束↑
			
		}
		else if(TestWindowBuilder.free == 00) {
			//南北向左转
			combo = 1;
			go_l = true;
			
			others_r = false;
			go_s = false;
			
			lighticon.setIcon(light_L);
		}
		else if(TestWindowBuilder.free == 01) {
			//南北向直行
			combo = 2;
			go_s = true;
			
			others_r = false;
			go_l = false;
			
			lighticon.setIcon(light_RS);
		}
		else if(TestWindowBuilder.free == 10) {
			//东西向左转
			combo = -1;
			others_r = true;
			
			go_l = false;
			go_s = false;
			
			lighticon.setIcon(light_stop);
		}
		else if(TestWindowBuilder.free == 11) {
			//东西向直行
			combo = 0;
			others_r = true;
			
			go_l = false;
			go_s = false;
			
			lighticon.setIcon(light_stop);
		}
		
		
		
		
	}
}
	

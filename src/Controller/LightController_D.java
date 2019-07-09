package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LightController_D extends Thread{
	private JLabel lighticon;
	private boolean status;
	private static int combo;// every two turns changes to other roads
	private static int speed = 10000;
	
	private static boolean others_d;// T for cars on other roads to drive
	
	private static boolean go_l;
	private static boolean go_s_r;
	private static boolean go_r;
	
	public LightController_D(JLabel light) {
		status = true; //for thread to keep running 
		go_l = false;
		go_s_r = false;
		go_r = false;
		combo = -1;
		others_d = true;
		
		lighticon = light;
	}
	
	public static void setSpeed(int new_speed) {
		speed = new_speed;
	}
	
	public static int getSpeed() {
		return speed;
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
		
		return others_d;
	}
	
	@Override
	public void run() {
		ImageIcon light_stop = new ImageIcon(LightController_U.class.getResource("/img/light_D_off.png"));
		ImageIcon light_L = new ImageIcon(LightController_U.class.getResource("/img/light_D_l.png"));
		ImageIcon light_RS = new ImageIcon(LightController_U.class.getResource("/img/light_D_r+s.png"));
		
		this.status = true;
		go_r = true;
		
		
		if(TestWindowBuilder.free == 666) {
			//�������
			//�������ѭ����ʼ
			while(status) {
				
				//combo:  -1, 0=others drive left and straight; 1=go left; 2=go straight;
				if(combo <= 0) {
					others_d = true;
					
					go_l = false;
					go_s_r = false;
				}
				else if(combo == 1) {
					go_l = true;
					
					others_d = false;
					go_s_r = false;
				}
				else if(combo == 2) {
					go_s_r = true;
					
					others_d = false;
					go_l = false;
				}
				else {
					combo = -1;
					others_d = true;
				}
				
				
				if(!others_d) {//other roads is not active
					
					if(go_s_r) {
						lighticon.setIcon(light_RS);
						combo++;// 2 turns to change other roads
					}
					else if (go_l) {
						lighticon.setIcon(light_L);
						combo++;// 2 turns to change other roads
					}
				}
				
				else{//if others_u is true
					
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
			//�������ѭ��������
			
		}
		else if(TestWindowBuilder.free == 00) {
			//�ϱ�����ת
			combo = -1;
			others_d = true;
			
			go_l = false;
			go_s_r = false;
			
			lighticon.setIcon(light_stop);
		}
		else if(TestWindowBuilder.free == 01) {
			//�ϱ���ֱ��
			combo = 0;
			others_d = true;
			
			go_l = false;
			go_s_r = false;
			
			lighticon.setIcon(light_stop);
		}
		else if(TestWindowBuilder.free == 10) {
			//��������ת
			combo = 1;
			go_l = true;
			
			others_d = false;
			go_s_r = false;
			
			lighticon.setIcon(light_L);
		}
		else if(TestWindowBuilder.free == 11) {
			//������ֱ��
			combo = 2;
			go_s_r = true;
			
			others_d = false;
			go_l = false;
			
			lighticon.setIcon(light_RS);
		}
	}
}

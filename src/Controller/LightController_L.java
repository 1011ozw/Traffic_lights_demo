package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LightController_L extends Thread{
	
	private JLabel lighticon;
	private boolean status;
	private boolean go_l;
	private static boolean go_s_r;
	
	public LightController_L(JLabel light) {
		status = true;
		go_l = true;
		go_s_r = false;
		
		lighticon = light;
	}
	
	public boolean getLight_l() {
		return go_l;
	}
	
	public static boolean getLight_rs() {
		return !go_s_r;
	}
	
	@Override
	public void run() {
		ImageIcon light_stop = new ImageIcon(LightController_L.class.getResource("/img/light.png"));
		ImageIcon light_L = new ImageIcon(LightController_L.class.getResource("/img/light_L_l.png"));
		ImageIcon light_RS = new ImageIcon(LightController_L.class.getResource("/img/light_L_r+s.png"));
		
		this.status = true;
		
		while(status) {
		
			if(go_s_r) {
				lighticon.setIcon(light_RS);
			}
			else if (go_l) {
				lighticon.setIcon(light_L);
			}
			else {
				lighticon.setIcon(light_stop);
			}
			
			synchronized(this) {
				try {
					
					go_l = !go_l;
					go_s_r = !go_s_r;
					wait(5000);
				} catch(Exception e) {
					e.printStackTrace();
				}
			 }	
		}
		
	}
	
}

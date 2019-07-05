package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class T_LightController_R extends Thread {
	private boolean status;
	private JLabel lighticon;
	static int stage;
	
	public T_LightController_R(JLabel light) {
		status = true; //for thread to keep running 
		lighticon = light;
	}
	
	@Override
	public void run(){
		ImageIcon tlight_off=new ImageIcon(T_LightController_R.class.getResource("/img/tlight_R_off.png"));
		ImageIcon tlight_pass=new ImageIcon(T_LightController_R.class.getResource("/img/tlight_R_pass.png"));	
	this.status=true;
	stage=0;
	while(status) {
		if(stage==2)
			lighticon.setIcon(tlight_pass);
			else
				lighticon.setIcon(tlight_off);
		
		synchronized(this) {
			try {
				stage++;
				stage=stage%3;
				wait(3000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		 }	
	}
	}
}

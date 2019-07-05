package Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class T_LightController_D extends Thread {
	private boolean status;
	private JLabel lighticon;
	static int stage;
	
	public T_LightController_D(JLabel light) {
		status = true; //for thread to keep running 
		lighticon = light;
	}
	
	@Override
	public void run(){
		ImageIcon tlight_off=new ImageIcon(T_LightController_D.class.getResource("/img/tlight_D_off.png"));
		ImageIcon tlight_pass=new ImageIcon(T_LightController_D.class.getResource("/img/tlight_D_pass.png"));	
	this.status=true;
	stage=1;
	while(status) {
		if(stage==1)
			lighticon.setIcon(tlight_pass);
			else
				lighticon.setIcon(tlight_off);
		
		synchronized(this) {
			try {
				stage++;
				stage=stage%3;
				wait(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		 }	
	}
	}
}

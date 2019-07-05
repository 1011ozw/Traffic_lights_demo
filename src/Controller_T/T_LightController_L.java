package Controller_T;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class T_LightController_L extends Thread {
	private boolean status;
	private JLabel lighticon;
	static int stage;
	static boolean judge_l;
	
	public T_LightController_L(JLabel light) {
		status = true; //for thread to keep running 
		lighticon = light;
	}
	
	@Override
	public void run(){
		ImageIcon tlight_off=new ImageIcon(T_LightController_L.class.getResource("/img/tlight_L_off.png"));
		ImageIcon tlight_pass=new ImageIcon(T_LightController_L.class.getResource("/img/tlight_L_pass.png"));	
	this.status=true;
	stage=0;
	while(status) {
		if(stage==1)
			{lighticon.setIcon(tlight_pass);
			judge_l=true;
			T_turn.already_pass=true;
			T_goStraight.already_pass=true;
			}
			else{
				lighticon.setIcon(tlight_off);
		judge_l=false;
	}
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

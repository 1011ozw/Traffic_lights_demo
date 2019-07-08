package Controller_T;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class T_LightController_R extends Thread {
	private boolean status;
	private JLabel lighticon;
	static int stage;
	static boolean judge_r;
	
	public T_LightController_R(JLabel light) {
		status = true; //for thread to keep running 
		lighticon = light;
	}
	
	@Override
	public void run(){
		ImageIcon tlight_off=new ImageIcon(T_LightController_R.class.getResource("/img/tlight_R_off.png"));
		ImageIcon tlight_pass=new ImageIcon(T_LightController_R.class.getResource("/img/tlight_R_pass.png"));	
	this.status=true;
	if(T_road.free==0){
	stage=0;
	while(status) {
		if(stage==2)
			{lighticon.setIcon(tlight_pass);
			judge_r=true;
			}
			else
				{lighticon.setIcon(tlight_off);
		judge_r=false;}
		synchronized(this) {
			try {
				stage++;
				stage=stage%3;

				wait(T_road.swift_speed);

			} catch(Exception e) {
				e.printStackTrace();
			}
		 }	
	}
	}
	else if(T_road.free==3){judge_r=true;lighticon.setIcon(tlight_pass);}
	else {judge_r=false;lighticon.setIcon(tlight_off);}
	}
}

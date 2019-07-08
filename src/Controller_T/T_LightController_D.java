package Controller_T;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class T_LightController_D extends Thread {
	private boolean status;
	private JLabel lighticon;
	static int stage;
	static boolean judge_d;
	
	public T_LightController_D(JLabel light) {
		status = true; //for thread to keep running 
		lighticon = light;
	}
	
	@Override
	public void run(){
		ImageIcon tlight_off=new ImageIcon(T_LightController_D.class.getResource("/img/tlight_D_off.png"));
		ImageIcon tlight_pass=new ImageIcon(T_LightController_D.class.getResource("/img/tlight_D_pass.png"));	
	this.status=true;
	if(T_road.free==0){
	stage=0;
	while(status) {
		if(stage==0)
			{lighticon.setIcon(tlight_pass);
		judge_d=true;
			}
			else
				{lighticon.setIcon(tlight_off);
		judge_d=false;}
		
		synchronized(this) {
			try {
				stage++;
				stage=stage%3;
				wait(6000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		 }	
	}
	}
	else if(T_road.free==2){judge_d=true;lighticon.setIcon(tlight_pass);}
	else {judge_d=false;lighticon.setIcon(tlight_off);}
	}

}

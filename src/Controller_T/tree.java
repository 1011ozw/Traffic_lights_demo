package Controller_T;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controller.goRight;

public class tree extends Thread {
private int stage=0;
private JLabel treea;

public tree(JLabel tree){
	treea=tree;
}

	@Override
	public void run()  {
		while(true){
			ImageIcon tree0=new ImageIcon(goRight.class.getResource("/img/tree0.png"));
			ImageIcon tree1=new ImageIcon(goRight.class.getResource("/img/tree1.png"));
			ImageIcon tree2=new ImageIcon(goRight.class.getResource("/img/tree2.png"));
			ImageIcon tree3=new ImageIcon(goRight.class.getResource("/img/tree3.png"));
			stage++;
			stage=stage%4;
			if(stage==0)treea.setIcon(tree0);
			if(stage==1)treea.setIcon(tree1);
			if(stage==2)treea.setIcon(tree2);
			if(stage==3)treea.setIcon(tree3);
		
			
			synchronized(this) {
				try {
					wait(1000);
				} catch(Exception e) {
					e.printStackTrace();
				}
			 }	
		}
	}
	
}

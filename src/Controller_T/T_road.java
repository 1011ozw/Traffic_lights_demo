package Controller_T;
import img.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controller.TestWindowBuilder;
import Controller.goStraight;

public class T_road {

	private JFrame frame;
	
	private boolean state = true;
	private JLabel car_down2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T_road window = new T_road();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public T_road() throws InterruptedException {
		
		initialize();
		
	}

	
	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	private void initialize() throws InterruptedException {
		frame = new JFrame();
		frame.setBounds(100, 100, 896, 896);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		
		//initialize car Label
		JLabel car1 = new JLabel("");
		car1.setIcon(new ImageIcon(T_road.class.getResource("/img/car1.png")));
		car1.setBounds(142, 342, 70, 38);
		frame.getContentPane().add(car1);
		
		JLabel car2 = new JLabel("");
		car2.setIcon(new ImageIcon(T_road.class.getResource("/img/car2.png")));
		car2.setBounds(142, 402, 70, 38);
		frame.getContentPane().add(car2);
		
		JLabel car3 = new JLabel("");
		car3.setIcon(new ImageIcon(T_road.class.getResource("/img/car3.png")));
		car3.setBounds(142, 277, 70, 38);
		frame.getContentPane().add(car3);
		
		JLabel car_s2 = new JLabel("");
		car_s2.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_R_road.png")));
		car_s2.setBounds(717, 214, 70, 38);
		frame.getContentPane().add(car_s2);
		
		JLabel car_r2 = new JLabel("");
		car_r2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
		car_r2.setBounds(717, 128, 70, 38);
		frame.getContentPane().add(car_r2);
		
		JLabel car_down1 = new JLabel("");
		car_down1.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_up.png")));
		car_down1.setBounds(473, 583, 38, 70);
		frame.getContentPane().add(car_down1);
		
		car_down2 = new JLabel("");
		car_down2.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_up.png")));
		car_down2.setBounds(556, 583, 38, 70);
		frame.getContentPane().add(car_down2);
		
		JLabel Light_L = new JLabel("");
		Light_L.setIcon(new ImageIcon(T_road.class.getResource("/img/light.png")));
		Light_L.setBounds(292, 289, 60, 137);
		frame.getContentPane().add(Light_L);
		
		JLabel Light_R = new JLabel("");
		Light_R.setIcon(new ImageIcon(T_road.class.getResource("/img/tlight_R.png")));
		Light_R.setBounds(557, 128, 60, 107);
		frame.getContentPane().add(Light_R);
		
		JLabel Light_D = new JLabel("");
		Light_D.setIcon(new ImageIcon(T_road.class.getResource("/img/tlight_D.png")));
		Light_D.setBounds(497, 415, 93, 51);
		frame.getContentPane().add(Light_D);
		
		//调用函数类
		T_goLeft tgoleft=new T_goLeft(car_down1,"car_down1",5);
		T_goLeft2 tgoLeft2 = new T_goLeft2(car_s2, "car_s2", 5);
		T_goStraight tgoStraight=new T_goStraight(car1, "car1", 5);
		T_goStraight2 tgoStraight2=new T_goStraight2(car_r2, "car_r2", 5);
		T_goRight  tgoRight=new T_goRight(car2, "car2", 5);
		T_goRight2 tgoRight2 = new T_goRight2(car_down2, "car_down2", 5);
		T_turn tturn=new T_turn(car3,"car3",5);
		//红绿灯调用
		T_LightController_D tld = new T_LightController_D(Light_D); //下方红绿灯
		T_LightController_L tll = new T_LightController_L(Light_L); //左方红绿灯
		T_LightController_R tlr = new T_LightController_R(Light_R); //右方红绿灯
		//Start button
		JButton START = new JButton("\u5F00\u59CB\u8FD0\u884C");
		START.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//车辆线程启动
				tgoleft.start();
				tgoLeft2.start();
				tgoStraight.start();
				tgoStraight2.start();
				tgoRight.start();
				tgoRight2.start();
				tturn.start();
				//红绿灯线程启动
                tld.start();
                tll.start();
                tlr.start();
			}
		});
		
		
		
		
		START.setBounds(684, 707, 93, 23);
		frame.getContentPane().add(START);
		
		//change status button
		JButton STOP = new JButton("\u505C\u6B62\u8FD0\u884C");
		STOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				state = !state;			
				tgoleft.runCar(state);
				tgoleft.runCar(state);
				tgoStraight.runCar(state);
				tgoStraight2.runCar(state);
				tgoRight.runCar(state);
				tgoRight2.runCar(state);
				tturn.runCar(state);


			}
		});
		STOP.setBounds(684, 771, 93, 23);
		frame.getContentPane().add(STOP);
		
		
		
		
		//Map background
		JLabel MAP = new JLabel("");
		MAP.setBounds(0, 0, 896, 857);
		frame.getContentPane().add(MAP);
		MAP.setHorizontalAlignment(SwingConstants.CENTER);
		MAP.setIcon(new ImageIcon(T_road.class.getResource("/img/troad.png")));
	}
}

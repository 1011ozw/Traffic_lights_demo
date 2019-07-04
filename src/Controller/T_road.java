package Controller;
import img.*;
//fuzhenggang 2019/7/3
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		
		//set public driving class
//		goStraight gostraight = new goStraight(car1,"car1",10);
//		goRight goright = new goRight(car2, "car2",25);
//		goLeft goleft= new goLeft(car3, "car3",15);
//		
//		goStraight2 gostraight2 = new goStraight2(car_s2,"car_s2",25);
//		goRight2 goright2 = new goRight2(car_r2, "car_r2",30);
		
		//调用函数类
		T_goLeft tgoleft=new T_goLeft(car_down1,"car_down1",5);
		T_goLeft2 tgoLeft2 = new T_goLeft2(car_s2, "car_s2", 5);
		T_goStraight tgoStraight=new T_goStraight(car1, "car1", 5);
		T_goStraight2 tgoStraight2=new T_goStraight2(car_r2, "car_r2", 5);
		T_goRight  tgoRight=new T_goRight(car2, "car2", 5);
		T_goRight2 tgoRight2 = new T_goRight2(car_down2, "car_down2", 5);
		T_turn tturn=new T_turn(car3,"car3",5);
		//Start button
		JButton START = new JButton("\u5F00\u59CB\u8FD0\u884C");
		START.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				gostraight.start();	
//				goleft.start();
//				goright.start();
				
				tgoleft.start();
				tgoLeft2.start();
				tgoStraight.start();
				tgoStraight2.start();
				tgoRight.start();
				tgoRight2.start();
				tturn.start();
//				gostraight2.start();
//				goright2.start();
			}
		});
		
		
		START.setBounds(684, 707, 93, 23);
		frame.getContentPane().add(START);
		
		//change status button
		JButton STOP = new JButton("\u505C\u6B62\u8FD0\u884C");
		STOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				state = !state;
//				gostraight.runCar(state);
//				goleft.runCar(state);
//				goright.runCar(state);
				
				tgoleft.runCar(state);
				tgoleft.runCar(state);
				tgoStraight.runCar(state);
				tgoStraight2.runCar(state);
				tgoRight.runCar(state);
				tgoRight2.runCar(state);
				tturn.runCar(state);
//				gostraight2.runCar(state);
//				goright2.runCar(state);

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
		
		JLabel label = new JLabel("");
		label.setBounds(379, 567, 70, 38);
		frame.getContentPane().add(label);
	}
}

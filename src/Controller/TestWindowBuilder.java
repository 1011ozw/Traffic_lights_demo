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

public class TestWindowBuilder {

	private JFrame frame;
	
	private boolean state = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindowBuilder window = new TestWindowBuilder();
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
	public TestWindowBuilder() throws InterruptedException {
		
		initialize();
		
	}

	
	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	private void initialize() throws InterruptedException {
		frame = new JFrame();
		frame.setBounds(100, 100, 896, 909);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		//initialize car Label
		JLabel car_L_s1 = new JLabel("");
		car_L_s1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car1.png")));
		car_L_s1.setBounds(142, 488, 70, 30);
		frame.getContentPane().add(car_L_s1);
		
		JLabel car_L_s2 = new JLabel("");
		car_L_s2.setBounds(65, 488, 70, 30);
		frame.getContentPane().add(car_L_s2);
		
		JLabel car_L_r1 = new JLabel("");
		car_L_r1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car2.png")));
		car_L_r1.setBounds(142, 528, 70, 38);
		frame.getContentPane().add(car_L_r1);
		
		JLabel car_L_r2 = new JLabel("");
		car_L_r2.setBounds(65, 528, 70, 38);
		frame.getContentPane().add(car_L_r2);
		
		JLabel car_L_l1 = new JLabel("");
		car_L_l1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3.png")));
		car_L_l1.setBounds(142, 429, 70, 38);
		frame.getContentPane().add(car_L_l1);
		
		JLabel car_L_l2 = new JLabel("");
		car_L_l2.setBounds(65, 429, 70, 38);
		frame.getContentPane().add(car_L_l2);
		
		JLabel car_R_s1 = new JLabel("");
		car_R_s1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
		car_R_s1.setBounds(691, 339, 70, 38);
		frame.getContentPane().add(car_R_s1);
		
		JLabel car_R_s2 = new JLabel("");
		car_R_s2.setBounds(779, 339, 70, 38);
		frame.getContentPane().add(car_R_s2);
		
		JLabel car_R_r1 = new JLabel("");
		car_R_r1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
		car_R_r1.setBounds(691, 295, 70, 38);
		frame.getContentPane().add(car_R_r1);
		
		//set public driving class
		goStraight gostraight = new goStraight(car_L_s1,"car1",10);
		goRight goright = new goRight(car_L_r1, "car2",25);
		goLeft goleft= new goLeft(car_L_l1, "car3",15);
		
		goStraight2 gostraight2 = new goStraight2(car_R_s1,"car_s2",25);
		goRight2 goright2 = new goRight2(car_R_r1, "car_r2",30);
		
		//Start button
		JButton START = new JButton("\u5F00\u59CB\u8FD0\u884C");
		START.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gostraight.start();	
				goleft.start();
				goright.start();
				
				gostraight2.start();
				goright2.start();
			}
		});
		
		JLabel car_R_r2 = new JLabel("");
		car_R_r2.setBounds(779, 295, 70, 38);
		frame.getContentPane().add(car_R_r2);
		
		JLabel car_R_l1 = new JLabel("");
		car_R_l1.setBounds(691, 386, 70, 38);
		frame.getContentPane().add(car_R_l1);
		
		JLabel car_R_l2 = new JLabel("");
		car_R_l2.setBounds(779, 386, 70, 38);
		frame.getContentPane().add(car_R_l2);
		
		JLabel car_U_r1 = new JLabel("");
		car_U_r1.setBounds(320, 105, 38, 70);
		frame.getContentPane().add(car_U_r1);
		
		JLabel car_U_r2 = new JLabel("");
		car_U_r2.setBounds(320, 35, 38, 70);
		frame.getContentPane().add(car_U_r2);
		
		JLabel car_U_s1 = new JLabel("");
		car_U_s1.setBounds(367, 105, 38, 70);
		frame.getContentPane().add(car_U_s1);
		
		JLabel car_U_s2 = new JLabel("");
		car_U_s2.setBounds(367, 35, 38, 70);
		frame.getContentPane().add(car_U_s2);
		
		JLabel car_U_l1 = new JLabel("");
		car_U_l1.setBounds(418, 105, 38, 70);
		frame.getContentPane().add(car_U_l1);
		
		JLabel car_U_l2 = new JLabel("");
		car_U_l2.setBounds(418, 35, 38, 70);
		frame.getContentPane().add(car_U_l2);
		
		JLabel car_D_l1 = new JLabel("");
		car_D_l1.setBounds(465, 690, 38, 70);
		frame.getContentPane().add(car_D_l1);
		
		JLabel car_D_l2 = new JLabel("");
		car_D_l2.setBounds(465, 760, 38, 70);
		frame.getContentPane().add(car_D_l2);
		
		JLabel car_D_s1 = new JLabel("");
		car_D_s1.setBounds(514, 690, 38, 70);
		frame.getContentPane().add(car_D_s1);
		
		JLabel car_D_s2 = new JLabel("");
		car_D_s2.setBounds(514, 760, 38, 70);
		frame.getContentPane().add(car_D_s2);
		
		JLabel car_D_r1 = new JLabel("");
		car_D_r1.setBounds(562, 690, 38, 70);
		frame.getContentPane().add(car_D_r1);
		
		JLabel car_D_r2 = new JLabel("");
		car_D_r2.setBounds(562, 768, 38, 70);
		frame.getContentPane().add(car_D_r2);
		START.setBounds(684, 707, 93, 23);
		frame.getContentPane().add(START);
		
		//change status button
		JButton STOP = new JButton("\u505C\u6B62\u8FD0\u884C");
		STOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				state = !state;
				gostraight.runCar(state);
				goleft.runCar(state);
				goright.runCar(state);
				
				gostraight2.runCar(state);
				goright2.runCar(state);

			}
		});
		STOP.setBounds(684, 771, 93, 23);
		frame.getContentPane().add(STOP);
		
		
		
		
		//Map background
		JLabel MAP = new JLabel("");
		MAP.setBounds(0, 0, 896, 857);
		frame.getContentPane().add(MAP);
		MAP.setHorizontalAlignment(SwingConstants.CENTER);
		MAP.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/road1.jpg")));
		
	}
}

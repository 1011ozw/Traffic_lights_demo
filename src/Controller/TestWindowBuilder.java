package Controller;
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
		frame.setBounds(100, 100, 896, 896);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		
		//initialize car Label
		JLabel car1 = new JLabel("");
		car1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car1.png")));
		car1.setBounds(142, 488, 70, 30);
		frame.getContentPane().add(car1);
		
		JLabel car2 = new JLabel("");
		car2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car2.png")));
		car2.setBounds(142, 528, 70, 38);
		frame.getContentPane().add(car2);
		
		JLabel car3 = new JLabel("");
		car3.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3.png")));
		car3.setBounds(142, 429, 70, 38);
		frame.getContentPane().add(car3);
		
		JLabel car_s2 = new JLabel("");
		car_s2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
		car_s2.setBounds(691, 339, 70, 38);
		frame.getContentPane().add(car_s2);
		
		JLabel car_r2 = new JLabel("");
		car_r2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
		car_r2.setBounds(691, 295, 70, 38);
		frame.getContentPane().add(car_r2);
		
		//initialize light Label
		JLabel Light_L = new JLabel("");
		Light_L.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/light.png")));
		Light_L.setBounds(305, 430, 54, 137);
		frame.getContentPane().add(Light_L);
		
		//set public driving class
		goStraight gostraight = new goStraight(car1,"car1",10);
		goRight goright = new goRight(car2, "car2",25);
		goLeft goleft= new goLeft(car3, "car3",15);
		
		goStraight2 gostraight2 = new goStraight2(car_s2,"car_s2",25);
		goRight2 goright2 = new goRight2(car_r2, "car_r2",30);
		
		//set public light class
		LightController_L lightC_l = new LightController_L(Light_L);
		
		//Start button
		JButton START = new JButton("\u5F00\u59CB\u8FD0\u884C");
		START.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gostraight.start();	
				goleft.start();
				goright.start();
				
				gostraight2.start();
				goright2.start();
				
				lightC_l.start();
				
			}
		});
		START.setBounds(684, 707, 93, 23);
		frame.getContentPane().add(START);
		
		//change status button
		JButton STOP = new JButton("\u6682\u505C/\u542F\u52A8");
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

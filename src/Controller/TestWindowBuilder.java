package Controller;
import img.*;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		
		JMenuBar menuBar=new JMenuBar();
		menuBar.setLocation(0, 0);
		menuBar.setSize(600, 23);
		menuBar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.setBackground(Color.WHITE);
		JMenu menu1=new JMenu("演示");
		menu1.setBackground(Color.LIGHT_GRAY);
		menu1.setHorizontalAlignment(SwingConstants.CENTER);
		JMenu menu2=new JMenu("改变红绿灯");
		menu2.setHorizontalAlignment(SwingConstants.LEFT);
		JMenuItem item10=new JMenuItem("开始演示");
		JMenuItem item11=new JMenuItem("加入车辆");
		JMenuItem item13=new JMenuItem("退出");
		JMenuItem item3=new JMenuItem("随机变换红绿灯");
		JMenuItem item21=new JMenuItem("设置上车道绿灯");
		JMenuItem item22=new JMenuItem("设置左车道绿灯");
		JMenuItem item23=new JMenuItem("设置下车道绿灯");
		JMenuItem item24=new JMenuItem("设置右车道绿灯");
		JMenuItem item4=new JMenuItem("加快红绿灯变换速度");
		JMenuItem item5=new JMenuItem("减慢红绿灯变换速度");
		menu1.add(item10);
		menu1.add(item11);
		menu1.add(item13);
		JMenuItem item12=new JMenuItem("刷新");
		menu1.add(item12);
		menu1.addSeparator();
		menu2.add(item21);
		menu2.add(item22);
		menu2.add(item23);
		menu2.add(item24);
		menu2.add(item3);
		menu2.add(item4);
		menu2.add(item5);
		menuBar.add(menu1);
		menuBar.add(menu2);
		frame.getContentPane().add(menuBar);
		
		
		 
		//initialize car Label
		//car left lane
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
		
		//car right lane
		JLabel car_R_s2 = new JLabel("");
		car_R_s2.setBounds(779, 339, 70, 38);
		frame.getContentPane().add(car_R_s2);
		
		JLabel car_R_r1 = new JLabel("");
		car_R_r1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
		car_R_r1.setBounds(691, 295, 70, 38);
		frame.getContentPane().add(car_R_r1);
		
		JLabel car_R_r2 = new JLabel("");
		car_R_r2.setBounds(779, 295, 70, 38);
		frame.getContentPane().add(car_R_r2);
		
		JLabel car_R_l1 = new JLabel("");
		car_R_l1.setBounds(691, 386, 70, 38);
		frame.getContentPane().add(car_R_l1);
		
		JLabel car_R_l2 = new JLabel("");
		car_R_l2.setBounds(779, 386, 70, 38);
		frame.getContentPane().add(car_R_l2);
		
		//car up lane
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
		
		//car down lane
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
		
		//initialize light Label
		JLabel Light_L = new JLabel("");
		Light_L.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/light.png")));
		Light_L.setBounds(305, 430, 54, 137);
		frame.getContentPane().add(Light_L);
		
		//set public driving class
		goStraight gostraight = new goStraight(car_L_s1,"car1",10);
		goRight goright = new goRight(car_L_r1, "car2",25);
		goLeft goleft= new goLeft(car_L_l1, "car3",15);
		
		goStraight2 gostraight2 = new goStraight2(car_R_s1,"car_s2",25);
		goRight2 goright2 = new goRight2(car_R_r1, "car_r2",30);
		
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

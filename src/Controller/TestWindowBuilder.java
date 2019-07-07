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
		frame.setBounds(100, 100, 896, 889);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		

		JMenuBar menuBar=new JMenuBar();
		menuBar.setLocation(0, 0);
		menuBar.setSize(600, 23);
		menuBar.setBackground(Color.WHITE);
		JMenu menu1=new JMenu("演示");
		menu1.setBackground(Color.LIGHT_GRAY);
		menu1.setHorizontalAlignment(SwingConstants.CENTER);
		JMenu menu2=new JMenu("改变红绿灯");
		menu2.setHorizontalAlignment(SwingConstants.LEFT);
		JMenuItem item10=new JMenuItem("开始演示");
		
		// add car menu
		JMenu menu3=new JMenu("加入车辆");
		JMenu menu4=new JMenu("左车道");
		JMenu menu5=new JMenu("右车道");
		JMenu menu6=new JMenu("上车道");
		JMenu menu7=new JMenu("下车道");
		JMenuItem addcar_L_l=new JMenuItem("左转");
		JMenuItem addcar_L_s=new JMenuItem("直行");
		JMenuItem addcar_L_r=new JMenuItem("右转");
		menu4.add(addcar_L_l);
		menu4.add(addcar_L_s);
		menu4.add(addcar_L_r);
		
		
		JMenuItem addcar_R_l=new JMenuItem("左转");
		JMenuItem addcar_R_s=new JMenuItem("直行");
		JMenuItem addcar_R_r=new JMenuItem("右转");
		menu5.add(addcar_R_l);
		menu5.add(addcar_R_s);
		menu5.add(addcar_R_r);
		JMenuItem addcar_U_l=new JMenuItem("左转");
		JMenuItem addcar_U_s=new JMenuItem("直行");
		JMenuItem addcar_U_r=new JMenuItem("右转");
		menu6.add(addcar_U_l);
		menu6.add(addcar_U_s);
		menu6.add(addcar_U_r);
		JMenuItem addcar_D_l=new JMenuItem("左转");
		JMenuItem addcar_D_s=new JMenuItem("直行");
		JMenuItem addcar_D_r=new JMenuItem("右转");
		menu7.add(addcar_D_l);
		menu7.add(addcar_D_s);
		menu7.add(addcar_D_r);
		
		JMenuItem item13=new JMenuItem("退出");
		JMenuItem item3=new JMenuItem("随机变换红绿灯");
		JMenuItem item21=new JMenuItem("设置上车道绿灯");
		JMenuItem item22=new JMenuItem("设置左车道绿灯");
		JMenuItem item23=new JMenuItem("设置下车道绿灯");
		JMenuItem item24=new JMenuItem("设置右车道绿灯");
		JMenuItem item4=new JMenuItem("加快红绿灯变换速度");
		JMenuItem item5=new JMenuItem("减慢红绿灯变换速度");
		JMenuItem item12=new JMenuItem("刷新");
		menu1.add(item10);
		menu1.add(menu3);
		menu3.add(menu4);
		menu3.add(menu5);
		menu3.add(menu6);
		menu3.add(menu7);
		menu1.add(item13);
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
		car_R_r1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car7_D_l.png")));
		car_R_r1.setBounds(691, 295, 70, 38);
		frame.getContentPane().add(car_R_r1);
		
		JLabel car_R_r2 = new JLabel("");
		car_R_r2.setBounds(779, 295, 70, 38);
		frame.getContentPane().add(car_R_r2);
		
		JLabel car_R_l1 = new JLabel("");
		car_R_l1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car4_R_s.png")));
		car_R_l1.setBounds(691, 386, 70, 38);
		frame.getContentPane().add(car_R_l1);
		
		JLabel car_R_l2 = new JLabel("");
		car_R_l2.setBounds(779, 386, 70, 38);
		frame.getContentPane().add(car_R_l2);
		
		//car up lane
		JLabel car_U_r1 = new JLabel("");
		car_U_r1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car1_U_d.png")));
		car_U_r1.setBounds(320, 105, 38, 70);
		frame.getContentPane().add(car_U_r1);
		
		JLabel car_U_r2 = new JLabel("");
		car_U_r2.setBounds(320, 35, 38, 70);
		frame.getContentPane().add(car_U_r2);
		
		JLabel car_U_s1 = new JLabel("");
		car_U_s1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car4_R_d.png")));
		car_U_s1.setBounds(367, 105, 38, 70);
		frame.getContentPane().add(car_U_s1);
		
		JLabel car_U_s2 = new JLabel("");
		car_U_s2.setBounds(367, 35, 38, 70);
		frame.getContentPane().add(car_U_s2);
		
		JLabel car_U_l1 = new JLabel("");
		car_U_l1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car5_U_d.png")));
		car_U_l1.setBounds(410, 105, 54, 70);
		frame.getContentPane().add(car_U_l1);
		
		JLabel car_U_l2 = new JLabel("");
		car_U_l2.setBounds(418, 35, 38, 70);
		frame.getContentPane().add(car_U_l2);
		
		//car down lane
		JLabel car_D_l1 = new JLabel("");
		car_D_l1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car7_D_s.png")));
		car_D_l1.setBounds(465, 690, 38, 70);
		frame.getContentPane().add(car_D_l1);
		
		JLabel car_D_l2 = new JLabel("");
		car_D_l2.setBounds(465, 760, 38, 70);
		frame.getContentPane().add(car_D_l2);
		
		JLabel car_D_s1 = new JLabel("");
		car_D_s1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_up.png")));
		car_D_s1.setBounds(507, 690, 47, 70);
		frame.getContentPane().add(car_D_s1);
		
		JLabel car_D_s2 = new JLabel("");
		car_D_s2.setBounds(514, 760, 38, 70);
		frame.getContentPane().add(car_D_s2);
		
		JLabel car_D_r1 = new JLabel("");
		car_D_r1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car6_D_s.png")));
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
		
		JLabel Light_U = new JLabel("");
		Light_U.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/light_U.png")));
		Light_U.setBounds(319, 272, 137, 54);
		frame.getContentPane().add(Light_U);
		
		JLabel Light_R = new JLabel("");
		Light_R.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/light_R.png")));
		Light_R.setBounds(557, 287, 54, 137);
		frame.getContentPane().add(Light_R);
		
		JLabel Light_D = new JLabel("");
		Light_D.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/light_D.png")));
		Light_D.setBounds(463, 534, 137, 54);
		frame.getContentPane().add(Light_D);
		
		//set public driving class
		goStraight gostraight = new goStraight(car_L_s1,"car_L_s1",10);
		goRight goright = new goRight(car_L_r1, "car_L_r1",25);
		goLeft goleft= new goLeft(car_L_l1, "car_L_l1",15);
		
		goStraight2 gostraight2 = new goStraight2(car_R_s1,"car_R_s1",25);
		goRight2 goright2 = new goRight2(car_R_r1, "car_R_r1",30);
		goLeft2 goleft2 = new goLeft2(car_R_l1,"car_R_l1",17);
		
		
		goStraight3 gostraight3 = new goStraight3(car_U_s1,"car_U_s1",25);
		goRight3 goright3 = new goRight3(car_U_r1,"car_U_r1",15);
		goLeft3 goleft3 = new goLeft3(car_U_l1,"car_U_l1",15);
		
		goStraight4 gostraight4 = new goStraight4(car_D_s1,"car_D_s1",15);
		goRight4 goright4 = new goRight4(car_D_r1,"car_D_r1",15);
		goLeft4 goleft4 = new goLeft4(car_D_l1,"car_D_l1",15);
		
		//menu function
		menu4.add(addcar_L_l);
		addcar_L_l.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				car_L_l2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car2.png")));
				car_L_l2.setBounds(65, 429, 70, 30);
				frame.getLayeredPane().add(car_L_l2,new Integer(80));
				frame.validate();
				goLeft gl=new goLeft(car_L_l2,"car_L_l",15);
				gl.start();
				
			}
		});
		menu4.add(addcar_L_s);
		addcar_L_s.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				car_L_s2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car1.png")));
				car_L_s2.setBounds(65, 488, 70, 30);
				frame.getLayeredPane().add(car_L_s2,new Integer(80));
				frame.validate();
				goStraight gs=new goStraight(car_L_s2,"car_L_s",25);
				gs.start();
				
			}
		});
		menu4.add(addcar_L_r);
		addcar_L_r.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				car_L_r2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3.png")));
				frame.getLayeredPane().add(car_L_r2,new Integer(80));
				frame.validate();
				goRight gr=new goRight(car_L_r2,"car_L_r",25);
				gr.start();
				
			}
		});
		
		
		//set public light class
		LightController_L lightC_l = new LightController_L(Light_L);
		LightController_R lightC_r = new LightController_R(Light_R);
		LightController_U lightC_u = new LightController_U(Light_U);
		LightController_D lightC_d = new LightController_D(Light_D);
		
		//Start button
		JButton START = new JButton("\u5F00\u59CB\u8FD0\u884C");
		START.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				gostraight.start();	
				gostraight2.start();
				gostraight3.start();
				gostraight4.start();
				
				goleft.start();
				goleft2.start();
				goleft3.start();
				goleft4.start();
				
				goright.start();
				goright2.start();
				goright3.start();
				goright4.start();
				
				lightC_l.start();
				lightC_r.start();
				lightC_u.start();
				lightC_d.start();
			}
		});
		
		JButton Add_L_r = new JButton("");
		Add_L_r.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_L_r.setBounds(0, 528, 50, 50);
		frame.getContentPane().add(Add_L_r);
		
		JButton Add_L_s = new JButton("");
		Add_L_s.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_L_s.setBounds(0, 477, 50, 50);
		frame.getContentPane().add(Add_L_s);
		
		JButton Add_L_l = new JButton("");
		Add_L_l.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_L_l_add = new JLabel("");
				car_L_l_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3.png")));
				car_L_l_add.setBounds(65, 429, 70, 38);
				frame.getLayeredPane().add(car_L_l_add,new Integer(80));
				frame.validate();
				
				goLeft goleft_add= new goLeft(car_L_l_add, "car_L_l_add",15);
				goleft_add.start();
				
			}
		});
		Add_L_l.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_L_l.setBounds(0, 426, 50, 50);
		frame.getContentPane().add(Add_L_l);
		
		
		
		//StartBTN setting, other insert btn will automatically insert above these codes↓
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
				goleft2.runCar(state);
				
				gostraight3.runCar(state);
				goright3.runCar(state);
				goleft3.runCar(state);
				
				gostraight4.runCar(state);
				goright4.runCar(state);
				goleft4.runCar(state);
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

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
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controller.goStraight;
import Controller_T.T_road;

public class TestWindowBuilder {

	private JFrame frame;
	
	private boolean state = true;
	
	//666代表红绿灯重置，并正常启动； 00代表红绿灯转变为南北向左转； 01代表红绿灯转变为南北向直行； 10代表红绿灯转变为东西向左转； 11代表红绿灯转变为东西向直行
	public static int free = 666; 

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
		frame.setBounds(100, 100, 921, 897);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		

		JMenuBar menuBar=new JMenuBar();
		menuBar.setLocation(0, 0);
		menuBar.setSize(187, 23);
		menuBar.setBackground(Color.WHITE);
		JMenu menu1=new JMenu("演示");
		menu1.setBackground(Color.LIGHT_GRAY);
		menu1.setHorizontalAlignment(SwingConstants.CENTER);
		JMenu menu2=new JMenu("红绿灯");
		JMenu menu3=new JMenu("汽车");
		menu2.setHorizontalAlignment(SwingConstants.LEFT);	
		
		//menu function
		JMenuItem item13=new JMenuItem("退出");
		item13.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
			}
		});

		
		JMenuItem item12=new JMenuItem("刷新");
		item12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				TestWindowBuilder window;
				try {
					window = new TestWindowBuilder();
					window.frame.setVisible(true);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem item30=new JMenuItem("转为T字路口");
		item30.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					T_road window=new T_road();
					window.frame.setVisible(true);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu1.add(item30);
		menu1.add(item13);
		menu1.add(item12);
		menu1.addSeparator();
        //menu2.add(item3);
		
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
		
		//initialize PVController
		PVController pvController = new PVController();
		
		//set public driving class
		goStraight gostraight = new goStraight(car_L_s1,"car_L_s1",20);
		goRight goright = new goRight(car_L_r1, "car_L_r1",20);
		goLeft goleft= new goLeft(car_L_l1, "car_L_l1",20);
		
		goStraight2 gostraight2 = new goStraight2(car_R_s1,"car_R_s1",20);
		goRight2 goright2 = new goRight2(car_R_r1, "car_R_r1",20);
		goLeft2 goleft2 = new goLeft2(car_R_l1,"car_R_l1",20);
		
		
		goStraight3 gostraight3 = new goStraight3(car_U_s1,"car_U_s1",20);
		goRight3 goright3 = new goRight3(car_U_r1,"car_U_r1",20);
		goLeft3 goleft3 = new goLeft3(car_U_l1,"car_U_l1",20);
		
		goStraight4 gostraight4 = new goStraight4(car_D_s1,"car_D_s1",20);
		goRight4 goright4 = new goRight4(car_D_r1,"car_D_r1",20);
		goLeft4 goleft4 = new goLeft4(car_D_l1,"car_D_l1",20);
		
		
		//set public light class
		LightController_L lightC_l = new LightController_L(Light_L);
		LightController_R lightC_r = new LightController_R(Light_R);
		LightController_U lightC_u = new LightController_U(Light_U);
		LightController_D lightC_d = new LightController_D(Light_D);
		
		//Start button
		JButton START = new JButton("");
		START.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/Start.png")));
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
		Add_L_r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_L_r_add = new JLabel("");
				car_L_r_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car2.png")));
				car_L_r_add.setBounds(65, 528, 70, 38);
				frame.getLayeredPane().add(car_L_r_add,new Integer(80));
				frame.validate();
				
				goRight goright_add= new goRight(car_L_r_add, "car_L_r_add",15);
				goright_add.start();
				
			}
		});
		Add_L_r.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_L_r.setBounds(0, 528, 50, 50);
		frame.getContentPane().add(Add_L_r);
		
		JButton Add_L_s = new JButton("");
		Add_L_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_L_s_add = new JLabel("");
				car_L_s_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car1.png")));
				car_L_s_add.setBounds(65, 485, 70, 38);
				frame.getLayeredPane().add(car_L_s_add,new Integer(80));
				frame.validate();
				
				goStraight gosraight_add= new goStraight(car_L_s_add, "car_L_s_add",15);
				gosraight_add.start();
				
			}
		});
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
				
				goLeft goleft_add= new goLeft(car_L_l_add, "car_L_l_add",12);
				goleft_add.start();
				
			}
		});
		Add_L_l.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_L_l.setBounds(0, 426, 50, 50);
		frame.getContentPane().add(Add_L_l);
		
		JButton Add_R_l = new JButton("");
		Add_R_l.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_R_l_add = new JLabel("");
				car_R_l_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car4_R_s.png")));
				car_R_l_add.setBounds(780, 386, 70, 38);
				frame.getLayeredPane().add(car_R_l_add,new Integer(80));
				frame.validate();
				
				goLeft2 goleft2_add= new goLeft2(car_R_l_add, "car_R_l_add",15);
				goleft2_add.start();
				
			}
		});
		Add_R_l.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_R_l.setBounds(850, 380, 50, 50);
		frame.getContentPane().add(Add_R_l);
		
		JButton Add_R_s = new JButton("");
		Add_R_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_R_s_add = new JLabel("");
				car_R_s_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
				car_R_s_add.setBounds(780, 339, 70, 38);
				frame.getLayeredPane().add(car_R_s_add,new Integer(80));
				frame.validate();
				
				goStraight2 gostraight2_add= new goStraight2(car_R_s_add, "car_R_s_add",15);
				gostraight2_add.start();
				
			}
		});
		Add_R_s.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_R_s.setBounds(850, 329, 50, 50);
		frame.getContentPane().add(Add_R_s);
		
		JButton Add_R_r = new JButton("");
		Add_R_r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_R_r_add = new JLabel("");
				car_R_r_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car7_D_l.png")));
				car_R_r_add.setBounds(780, 289, 70, 38);
				frame.getLayeredPane().add(car_R_r_add,new Integer(80));
				frame.validate();
				
				goRight2 goright2_add= new goRight2(car_R_r_add, "car_R_r_add",15);
				goright2_add.start();
				
			}
		});
		Add_R_r.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_R_r.setBounds(850, 278, 50, 50);
		frame.getContentPane().add(Add_R_r);
		
		JButton Add_U_l = new JButton("");
		Add_U_l.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_U_l_add = new JLabel("");
				car_U_l_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car5_U_d.png")));
				car_U_l_add.setBounds(410, 25, 54, 70);
				frame.getLayeredPane().add(car_U_l_add,new Integer(80));
				frame.validate();
				
				goLeft3 goleft3_add= new goLeft3(car_U_l_add, "car_U_l_add",15);
				goleft3_add.start();
				
			}
		});
		Add_U_l.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_U_l.setBounds(410, 0, 50, 50);
		frame.getContentPane().add(Add_U_l);
		
		JButton Add_U_s = new JButton("");
		Add_U_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_U_s_add = new JLabel("");
				car_U_s_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car4_R_d.png")));
				car_U_s_add.setBounds(370, 25, 54, 70);
				frame.getLayeredPane().add(car_U_s_add,new Integer(80));
				frame.validate();
				
				goStraight3 gostraight3_add= new goStraight3(car_U_s_add, "car_U_l_add",15);
				gostraight3_add.start();
				
			}
		});
		Add_U_s.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_U_s.setBounds(360, 0, 50, 50);
		frame.getContentPane().add(Add_U_s);
		
		JButton Add_U_r = new JButton("");
		Add_U_r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_U_r_add = new JLabel("");
				car_U_r_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car1_U_d.png")));
				car_U_r_add.setBounds(320, 25, 54, 70);
				frame.getLayeredPane().add(car_U_r_add,new Integer(80));
				frame.validate();
				
				goRight3 goright3_add= new goRight3(car_U_r_add, "car_U_l_add",15);
				goright3_add.start();
				
			}
		});
		Add_U_r.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_U_r.setBounds(315, 0, 50, 50);
		frame.getContentPane().add(Add_U_r);
		
		JButton Add_D_l = new JButton("");
		Add_D_l.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_D_l_add = new JLabel("");
				car_D_l_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car7_D_s.png")));
				car_D_l_add.setBounds(465, 770, 54, 70);
				frame.getLayeredPane().add(car_D_l_add,new Integer(80));
				frame.validate();
				
				goLeft4 goleft4_add= new goLeft4(car_D_l_add, "car_D_l_add",15);
				goleft4_add.start();
				
			}
		});
		Add_D_l.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_D_l.setBounds(460, 810, 50, 50);
		frame.getContentPane().add(Add_D_l);
		
		JButton Add_D_s = new JButton("");
		Add_D_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_D_s_add = new JLabel("");
				car_D_s_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_up.png")));
				car_D_s_add.setBounds(510, 765, 54, 70);
				frame.getLayeredPane().add(car_D_s_add,new Integer(80));
				frame.validate();
				
				goStraight4 gostraight4_add= new goStraight4(car_D_s_add, "car_D_s_add",15);
				gostraight4_add.start();
				
			}
		});
		Add_D_s.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_D_s.setBounds(510, 810, 50, 50);
		frame.getContentPane().add(Add_D_s);
		
		JButton Add_D_r = new JButton("");
		Add_D_r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car_D_r_add = new JLabel("");
				car_D_r_add.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car6_D_s.png")));
				car_D_r_add.setBounds(560, 765, 54, 70);
				frame.getLayeredPane().add(car_D_r_add,new Integer(80));
				frame.validate();
				
				goRight4 goright4_add= new goRight4(car_D_r_add, "car_D_s_add",15);
				goright4_add.start();
				
			}
		});
		Add_D_r.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/AddBTN.jpg")));
		Add_D_r.setBounds(560, 810, 50, 50);
		frame.getContentPane().add(Add_D_r);
		
		JButton ChangeLight1 = new JButton("");
		ChangeLight1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				//南北左转启动
				free = 00;
				
				LightController_L lightL_new = new LightController_L(Light_L);
				LightController_R lightR_new = new LightController_R(Light_R);
				LightController_U lightU_new = new LightController_U(Light_U);
				LightController_D lightD_new = new LightController_D(Light_D);
				
				lightL_new.start();
				lightR_new.start();
				lightU_new.start();
				lightD_new.start();
				
				lightC_l.stop();
				lightC_r.stop();
				lightC_u.stop();
				lightC_d.stop();
				
			}
		});
		ChangeLight1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/btn_l.jpg")));
		ChangeLight1.setBounds(70, 650, 80, 80);
		frame.getContentPane().add(ChangeLight1);
		
		JButton ChangeLight2 = new JButton("");
		ChangeLight2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				//南北直行启动
				free = 01;
				
				LightController_L lightL_new = new LightController_L(Light_L);
				LightController_R lightR_new = new LightController_R(Light_R);
				LightController_U lightU_new = new LightController_U(Light_U);
				LightController_D lightD_new = new LightController_D(Light_D);
				
				lightL_new.start();
				lightR_new.start();
				lightU_new.start();
				lightD_new.start();
				
				lightC_l.stop();
				lightC_r.stop();
				lightC_u.stop();
				lightC_d.stop();				
			}
		});
		ChangeLight2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/btn_s.jpg")));
		ChangeLight2.setBounds(180, 650, 80, 80);
		frame.getContentPane().add(ChangeLight2);
		
		JButton ChangeLight3 = new JButton("");
		ChangeLight3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//东西左转启动
				free = 10;
				
				LightController_L lightL_new = new LightController_L(Light_L);
				LightController_R lightR_new = new LightController_R(Light_R);
				LightController_U lightU_new = new LightController_U(Light_U);
				LightController_D lightD_new = new LightController_D(Light_D);
				
				lightL_new.start();
				lightR_new.start();
				lightU_new.start();
				lightD_new.start();
				
				lightC_l.stop();
				lightC_r.stop();
				lightC_u.stop();
				lightC_d.stop();	
			}
		});
		ChangeLight3.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/btn_l.jpg")));
		ChangeLight3.setBounds(70, 760, 80, 80);
		frame.getContentPane().add(ChangeLight3);
		
		JButton ChangeLight4 = new JButton("");
		ChangeLight4.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//东西直行启动
				free = 11;
				
				LightController_L lightL_new = new LightController_L(Light_L);
				LightController_R lightR_new = new LightController_R(Light_R);
				LightController_U lightU_new = new LightController_U(Light_U);
				LightController_D lightD_new = new LightController_D(Light_D);
				
				lightL_new.start();
				lightR_new.start();
				lightU_new.start();
				lightD_new.start();
				
				lightC_l.stop();
				lightC_r.stop();
				lightC_u.stop();
				lightC_d.stop();
			}
		});
		ChangeLight4.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/btn_s.jpg")));
		ChangeLight4.setBounds(180, 760, 80, 80);
		frame.getContentPane().add(ChangeLight4);
		
		//菜单栏设置路灯状态
		JMenuItem item21=new JMenuItem("设置左右道直行");
		item21.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				free = 01;
				LightController_L lightL_new = new LightController_L(Light_L);
				LightController_R lightR_new = new LightController_R(Light_R);
				LightController_U lightU_new = new LightController_U(Light_U);
				LightController_D lightD_new = new LightController_D(Light_D);
				
				lightL_new.start();
				lightR_new.start();
				lightU_new.start();
				lightD_new.start();
				
				lightC_l.stop();
				lightC_r.stop();
				lightC_u.stop();
				lightC_d.stop();
				
			}
		});
		JMenuItem item22=new JMenuItem("设置左右车道左转");
		item22.addActionListener(new ActionListener() {	
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				free = 00;
				LightController_L lightL_new = new LightController_L(Light_L);
				LightController_R lightR_new = new LightController_R(Light_R);
				LightController_U lightU_new = new LightController_U(Light_U);
				LightController_D lightD_new = new LightController_D(Light_D);
				
				lightL_new.start();
				lightR_new.start();
				lightU_new.start();
				lightD_new.start();
				
				lightC_l.stop();
				lightC_r.stop();
				lightC_u.stop();
				lightC_d.stop();
				
			}
		});
		JMenuItem item23=new JMenuItem("设置上下车道直行");
		item23.addActionListener(new ActionListener() {			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				free = 11;
				LightController_L lightL_new = new LightController_L(Light_L);
				LightController_R lightR_new = new LightController_R(Light_R);
				LightController_U lightU_new = new LightController_U(Light_U);
				LightController_D lightD_new = new LightController_D(Light_D);
				
				lightL_new.start();
				lightR_new.start();
				lightU_new.start();
				lightD_new.start();
				
				lightC_l.stop();
				lightC_r.stop();
				lightC_u.stop();
				lightC_d.stop();
				
			}
		});
		JMenuItem item24=new JMenuItem("设置上下车道左转");
		item24.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				free = 10;
				LightController_L lightL_new = new LightController_L(Light_L);
				LightController_R lightR_new = new LightController_R(Light_R);
				LightController_U lightU_new = new LightController_U(Light_U);
				LightController_D lightD_new = new LightController_D(Light_D);
				
				lightL_new.start();
				lightR_new.start();
				lightU_new.start();
				lightD_new.start();
				
				lightC_l.stop();
				lightC_r.stop();
				lightC_u.stop();
				lightC_d.stop();	
				
			}
		});
		menu2.add(item21);
		menu2.add(item22);
		menu2.add(item23);
		menu2.add(item24);
		
		//StartBTN setting, other insert btn will automatically insert above these codes锟斤拷
		START.setBounds(662, 650, 160, 63);
		frame.getContentPane().add(START);
		
		
		//Let cars stop or continue
		JButton STOP = new JButton("");
		STOP.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/Pause.png")));
		STOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				state = !state;
				goStraight.runCar(state);
				goLeft.runCar(state);
				goRight.runCar(state);
				
				goStraight2.runCar(state);
				goRight2.runCar(state);
				goLeft2.runCar(state);
				
				goStraight3.runCar(state);
				goRight3.runCar(state);
				goLeft3.runCar(state);
				
				goStraight4.runCar(state);
				goRight4.runCar(state);
				goLeft4.runCar(state);

			}
		});
		STOP.setBounds(662, 746, 160, 63);
		frame.getContentPane().add(STOP);
		
		JLabel SN = new JLabel("");
		SN.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/logo_SN.jpg")));
		SN.setBounds(10, 650, 50, 80);
		frame.getContentPane().add(SN);
		
		JLabel WE = new JLabel("");
		WE.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/logo_WE.jpg")));
		WE.setBounds(10, 760, 50, 80);
		frame.getContentPane().add(WE);
		
		JLabel compass = new JLabel("");
		compass.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/compass.jpg")));
		compass.setBounds(65, 62, 155, 155);
		frame.getContentPane().add(compass);
		
		//红绿灯速度修改
		JMenuItem item4=new JMenuItem("加快红绿灯变换速度");
		item4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LightController_D.setSpeed(LightController_D.getSpeed()/2);
				LightController_L.setSpeed(LightController_L.getSpeed()/2);
				LightController_R.setSpeed(LightController_R.getSpeed()/2);
				LightController_U.setSpeed(LightController_U.getSpeed()/2);
			}
		});
		JMenuItem item5=new JMenuItem("减慢红绿灯变换速度");
		item5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LightController_D.setSpeed(LightController_D.getSpeed()*2);
				LightController_L.setSpeed(LightController_L.getSpeed()*2);
				LightController_R.setSpeed(LightController_R.getSpeed()*2);
				LightController_U.setSpeed(LightController_U.getSpeed()*2);
				
			}
		});
		menu2.add(item4);
		menu2.add(item5);
		JMenuItem item19=new JMenuItem("加速");
		item19.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//车道加速
				if(goLeft.getSpeed()>=2) {
					goLeft.setSpeed(goLeft.getSpeed()/2);
					goLeft2.setSpeed(goLeft2.getSpeed()/2);
					goLeft3.setSpeed(goLeft3.getSpeed()/2);
					goLeft4.setSpeed(goLeft4.getSpeed()/2);

					goRight.setSpeed(goRight.getSpeed()/2);
					goRight2.setSpeed(goRight2.getSpeed()/2);
					goRight3.setSpeed(goRight3.getSpeed()/2);
					goRight4.setSpeed(goRight4.getSpeed()/2);

					goStraight.setSpeed(goStraight.getSpeed()/2);
					goStraight2.setSpeed(goStraight2.getSpeed()/2);
					goStraight3.setSpeed(goStraight3.getSpeed()/2);
					goStraight4.setSpeed(goStraight4.getSpeed()/2);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "已经是最快速度了", "提示",JOptionPane.WARNING_MESSAGE); 
				}
				
			}
		});
		JMenuItem item20=new JMenuItem("减速");
		item20.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 车道减速
				if(goLeft.getSpeed()<=50) {
					goLeft.setSpeed(goLeft.getSpeed()*2);
					goLeft2.setSpeed(goLeft2.getSpeed()*2);
					goLeft3.setSpeed(goLeft3.getSpeed()*2);
					goLeft4.setSpeed(goLeft4.getSpeed()*2);

					goRight.setSpeed(goRight.getSpeed()*2);
					goRight2.setSpeed(goRight2.getSpeed()*2);
					goRight3.setSpeed(goRight3.getSpeed()*2);
					goRight4.setSpeed(goRight4.getSpeed()*2);

					goStraight.setSpeed(goStraight.getSpeed()*2);
					goStraight2.setSpeed(goStraight2.getSpeed()*2);
					goStraight3.setSpeed(goStraight3.getSpeed()*2);
					goStraight4.setSpeed(goStraight4.getSpeed()*2);
				}
				else {
					JOptionPane.showMessageDialog(null, "已经是最慢速度了", "提示",JOptionPane.WARNING_MESSAGE); 
				}
			}
		});
		menu3.add(item19);
		menu3.add(item20);
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		frame.getContentPane().add(menuBar);
		
		
		//Map background
		JLabel MAP = new JLabel("");
		MAP.setBounds(0, 0, 896, 857);
		frame.getContentPane().add(MAP);
		MAP.setHorizontalAlignment(SwingConstants.CENTER);
		MAP.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/road1.jpg")));
		
	}
}

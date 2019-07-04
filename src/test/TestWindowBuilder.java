package test;
import img.*;
import java.awt.EventQueue;
import test.goStraight;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;


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
		frame.setBounds(100, 100, 618, 647);
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
		JLabel car1 = new JLabel("");
		car1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car1.png")));
		car1.setBounds(0, 334, 70, 30);
		frame.getContentPane().add(car1);
		
		JLabel car2 = new JLabel("");
		car2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car2.png")));
		car2.setBounds(0, 364, 70, 38);
		frame.getContentPane().add(car2);
		
		JLabel car3 = new JLabel("");
		car3.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3.png")));
		car3.setBounds(0, 295, 70, 38);
		frame.getContentPane().add(car3);
		
		JLabel car_s2 = new JLabel("");
		car_s2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
		car_s2.setBounds(460, 237, 70, 38);
		frame.getContentPane().add(car_s2);
		
		JLabel car_r2 = new JLabel("");
		car_r2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
		car_r2.setBounds(460, 198, 70, 38);
		frame.getContentPane().add(car_r2);
		
		//set public driving class
		goStraight gostraight = new goStraight(car1,"car1",10);
		goRight goright = new goRight(car2, "car2",25);
		goLeft goleft= new goLeft(car3, "car3",15);
		
		goStraight2 gostraight2 = new goStraight2(car_s2,"car_s2",25);
		goRight2 goright2 = new goRight2(car_r2, "car_r2",30);
		
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
		START.setBounds(499, 491, 93, 23);
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
		STOP.setBounds(499, 535, 93, 23);
		frame.getContentPane().add(STOP);
		
		
		
		
		//Map background
		JLabel MAP = new JLabel("");
		MAP.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(MAP);
		MAP.setHorizontalAlignment(SwingConstants.LEFT);
		MAP.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/road1.jpg")));
		
		
	}
	public class MyRoundBorder implements Border{
		  int arc=12; 
		  @Override
		  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		   g.drawRoundRect(x + 1, y + 1, width - 1, height - 1, arc, arc);
		  }
		  @Override
		  public Insets getBorderInsets(Component c) {
		   return null;
		  }
		  @Override
		  public boolean isBorderOpaque() {
		   return false;
		  }
}

}

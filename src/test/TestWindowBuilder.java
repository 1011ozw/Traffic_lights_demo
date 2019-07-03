package test;

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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		
		
		//汽车属性设置
		JLabel car1 = new JLabel("");
		car1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car1.png")));
		car1.setBounds(0, 334, 70, 30);
		frame.getContentPane().add(car1);
		
		JLabel car2 = new JLabel("");
		car2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car2.png")));
		car2.setBounds(10, 364, 70, 38);
		frame.getContentPane().add(car2);
		
		
		//设置共有多线程函数
		goStraight gostraight = new goStraight(car1,"car1");
		goRight goright = new goRight(car2, "car2");
		
		
		//开始运行按钮
		JButton START = new JButton("\u5F00\u59CB\u8FD0\u884C");
		START.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gostraight.start();	
				goright.start();
				
			}
		});
		START.setBounds(507, 544, 93, 23);
		frame.getContentPane().add(START);
		
		
		//停止运行按钮
		JButton STOP = new JButton("\u505C\u6B62\u8FD0\u884C");
		STOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				state = !state;
				gostraight.runCar(state);
				goright.runCar(state);
	
			}
		});
		STOP.setBounds(507, 577, 93, 23);
		frame.getContentPane().add(STOP);
		
		
		
		
		//十字路口地图
		JLabel MAP = new JLabel("");
		MAP.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(MAP);
		MAP.setHorizontalAlignment(SwingConstants.CENTER);
		MAP.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/road1.jpg")));
	}
}

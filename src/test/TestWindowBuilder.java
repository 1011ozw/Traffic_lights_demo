package test;
//fuzhenggang 2019/7/3
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
		
		
		//������������
		JLabel car1 = new JLabel("");
		car1.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car1.png")));
		car1.setBounds(0, 334, 70, 30);
		frame.getContentPane().add(car1);
		
		JLabel car2 = new JLabel("");
		car2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/tao.png")));
		car2.setBounds(20, 300, 70, 30);
		frame.getContentPane().add(car2);
		
		car2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car2.png")));
		car2.setBounds(0, 364, 70, 38);
		frame.getContentPane().add(car2);
		
		JLabel car_s2 = new JLabel("");
		car_s2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3.png")));
		car_s2.setBounds(460, 233, 70, 38);
		frame.getContentPane().add(car_s2);
		
		JLabel car_r2 = new JLabel("");
		car_r2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3.png")));
		car_r2.setBounds(460, 198, 70, 38);
		frame.getContentPane().add(car_r2);
		
		//���ù��ж��̺߳���
		goStraight gostraight = new goStraight(car1,"car1");
		goRight goright = new goRight(car2, "car2");
		
		goStraight2 gostraight2 = new goStraight2(car_s2,"car_s2");
		goRight2 goright2 = new goRight2(car_r2, "car_r2");
		
		//set car
		goLeft goleft= new goLeft(car2, "car2");
		//��ʼ���а�ť
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
		
		
		START.setBounds(507, 544, 93, 23);
		frame.getContentPane().add(START);
		
		JButton STOP = new JButton("\u505C\u6B62\u8FD0\u884C");
		STOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				state = !state;
				gostraight.runCar(state);
				goleft.runCar(state);
				goright.runCar(state);

			}
		});
		STOP.setBounds(499, 535, 93, 23);
		frame.getContentPane().add(STOP);
		
		
		
		
		//ʮ��·�ڵ�ͼ
		JLabel MAP = new JLabel("");
		MAP.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(MAP);
		MAP.setHorizontalAlignment(SwingConstants.CENTER);
		MAP.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/road1.jpg")));
	}
}

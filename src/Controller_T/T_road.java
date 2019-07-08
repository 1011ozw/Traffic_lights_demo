package Controller_T;
import img.*;

import java.io.IOException;

import Controller.TestWindowBuilder;
import Controller.goStraight;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class T_road {

	private JFrame frame;
	public static int free;
	private boolean state = true;
	static int swift_speed=6000;
	private JLabel car_down2;
	private final Action action = new SwingAction();
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
		
		JMenuBar menuBar=new JMenuBar();
		menuBar.setLocation(0, 0);
		menuBar.setSize(600, 23);
		menuBar.setBackground(Color.WHITE);
		JMenu menu1=new JMenu("��ʾ");
		menu1.setBackground(Color.LIGHT_GRAY);
		menu1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenu menu2=new JMenu("�ı���̵�");
		menu2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JMenu menu3=new JMenu("��ͼ");
		menu2.setHorizontalAlignment(SwingConstants.LEFT);
		JMenuItem item10=new JMenuItem("����");
		JMenuItem item11=new JMenuItem("���복��");
		JMenuItem item13=new JMenuItem("�˳�");
		JMenuItem item3=new JMenuItem("����任���̵�");
		JMenuItem item22=new JMenuItem("�����󳵵�ֱ�е�ͷ�̵�");
		JMenuItem item24=new JMenuItem("�����ҳ�����ת�̵�");
		JMenuItem item21=new JMenuItem("�����³�����ת�̵�");
		JMenuItem item4=new JMenuItem("�ӿ���̵Ʊ任�ٶ�");
		JMenuItem item5=new JMenuItem("�������̵Ʊ任�ٶ�");
		
		JMenuItem item25=new JMenuItem("�л�ʮ��·��");
		JMenuItem item26=new JMenuItem("�л�T��·��");
		item26.setEnabled(false);
		
		menu1.add(item10);
		menu1.add(item11);
		menu1.add(item13);
		menu1.addSeparator();
		menu2.add(item22);
		menu2.add(item24);
		menu2.add(item21);
		menu2.add(item3);
		menu2.add(item4);
		menu2.add(item5);
		
		menu3.add(item25);
		menu3.add(item26);
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		frame.getContentPane().add(menuBar);
		
		//�˵�������ʵ��
		TestWindowBuilder crossroad = new TestWindowBuilder();
		Refresh refresh = new Refresh();
		
		//���ù���
		item10.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	refresh.main(null);
            }

        });
		
		//�˳�����
		item13.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            }

        });
		
		
		
		
		//��ת����·��
		item25.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                crossroad.main(null);
            }

        });
		
		
		
		//�˵�������ʵ�ֽ���

		
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
		
		JLabel showspeed = new JLabel("");
		showspeed.setForeground(Color.RED);
		showspeed.setBounds(9, 25, 203, 21);
		frame.getContentPane().add(showspeed);
		showspeed.setText("��ǰ�л��ٶȣ�"+swift_speed);
		
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
	

		JButton addcar_ll = new JButton("");
		addcar_ll.setForeground(Color.WHITE);
		addcar_ll.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_ll.setSelectedIcon(null);
		addcar_ll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel car4 = new JLabel("");
				car4.setIcon(new ImageIcon(T_road.class.getResource("/img/car3.png")));
				car4.setBounds(68, 277, 70, 38);
				frame.getLayeredPane().add(car4,new Integer(80));
				frame.validate();
				T_turn tturn2=new T_turn(car4,"car4",5);
				
				System.out.println("��ߺ��̵Ƶ��ж�"+T_LightController_L.judge_l);
				
				tturn2.start();
			
				
			}
		});
		
		//���ú�����
		T_goLeft tgoleft=new T_goLeft(car_down1,"car_down1",5);
		T_goLeft2 tgoLeft2 = new T_goLeft2(car_s2, "car_s2", 5);
		T_goStraight tgoStraight=new T_goStraight(car1, "car1", 5);
		T_goStraight2 tgoStraight2=new T_goStraight2(car_r2, "car_r2", 5);
		T_goRight  tgoRight=new T_goRight(car2, "car2", 5);
		T_goRight2 tgoRight2 = new T_goRight2(car_down2, "car_down2", 5);
		T_turn tturn=new T_turn(car3,"car3",5);
		//���̵Ƶ���
		T_LightController_D tld = new T_LightController_D(Light_D); //�·����̵�
		T_LightController_L tll = new T_LightController_L(Light_L); //�󷽺��̵�
		T_LightController_R tlr = new T_LightController_R(Light_R); //�ҷ����̵�
		//Start button
		JButton START = new JButton("\u5F00\u59CB\u8FD0\u884C");
		START.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				free=0;
				//�����߳�����
				tgoleft.start();
				tgoLeft2.start();
				tgoStraight.start();
				tgoStraight2.start();
				tgoRight.start();
				tgoRight2.start();
				tturn.start();
				//���̵��߳�����
                tld.start();
                tll.start();
                tlr.start();
			}
		});
		//�����󳵵�ֱ�е�ͷ�̵�
				item22.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	free=1;
		            	T_LightController_D tld1 = new T_LightController_D(Light_D); //�·����̵�
		        		T_LightController_L tll1 = new T_LightController_L(Light_L); //�󷽺��̵�
		        		T_LightController_R tlr1 = new T_LightController_R(Light_R); //�ҷ����̵�
		        		tld1.start();
		                tll1.start();
		                tlr1.start();
		                tld.stop();
		                tll.stop();
		                tlr.stop();
		            }

		        });
				//�ӿ���̵Ʊ任�ٶ�
				item4.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	if(swift_speed==2000){
		            		JOptionPane.showMessageDialog(null, "�Ѿ�������л��ٶ���", "��ʾ",JOptionPane.WARNING_MESSAGE);  
		            	}
		            	else{
		            	swift_speed-=2000;
		            	T_LightController_D tld5 = new T_LightController_D(Light_D); //�·����̵�
		        		T_LightController_L tll5 = new T_LightController_L(Light_L); //�󷽺��̵�
		        		T_LightController_R tlr5 = new T_LightController_R(Light_R); //�ҷ����̵�
		        		tld5.start();
		                tll5.start();
		                tlr5.start();
		                tld.stop();
		                tll.stop();
		                tlr.stop();
		                showspeed.setText("��ǰ�л��ٶȣ�"+swift_speed);
		            	}
		            }

		        });
				
				//�������̵Ʊ任�ٶ�
				item5.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	
		            	swift_speed+=2000;
		            	T_LightController_D tld6 = new T_LightController_D(Light_D); //�·����̵�
		        		T_LightController_L tll6 = new T_LightController_L(Light_L); //�󷽺��̵�
		        		T_LightController_R tlr6 = new T_LightController_R(Light_R); //�ҷ����̵�
		        		tld6.start();
		                tll6.start();
		                tlr6.start();
		                tld.stop();
		                tll.stop();
		                tlr.stop();
		                showspeed.setText("��ǰ�л��ٶȣ�"+swift_speed);
		            	}
		        });
				
		addcar_ll.setFont(new Font("����", Font.BOLD, 26));
		addcar_ll.setBounds(10, 277, 50, 50);
		frame.getContentPane().add(addcar_ll);
		
		JButton addcar_ls = new JButton("");
		addcar_ls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel car5 = new JLabel("");
				car5.setIcon(new ImageIcon(T_road.class.getResource("/img/car1.png")));
				car5.setBounds(68, 342, 70, 38);
				frame.getLayeredPane().add(car5,new Integer(80));
				frame.validate();
				T_goStraight tgs=new T_goStraight(car5,"car5",5);
				tgs.start();
				
			}
		});
		addcar_ls.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_ls.setForeground(Color.WHITE);
		addcar_ls.setFont(new Font("����", Font.BOLD, 26));
		addcar_ls.setBounds(10, 334, 50, 50);
		frame.getContentPane().add(addcar_ls);
		
		JButton addcar_lr = new JButton("");
		addcar_lr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car6 = new JLabel("");
				car6.setIcon(new ImageIcon(T_road.class.getResource("/img/car2.png")));
				car6.setBounds(68, 402, 70, 38);
				frame.getLayeredPane().add(car6,new Integer(80));
				frame.validate();
				T_goRight tgr=new T_goRight(car6,"car6",5);
				tgr.start();
			}
		});
		addcar_lr.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_lr.setForeground(Color.WHITE);
		addcar_lr.setFont(new Font("����", Font.BOLD, 26));
		addcar_lr.setBounds(10, 394, 50, 50);
		frame.getContentPane().add(addcar_lr);
		
		JButton addcar_rs = new JButton("");
		addcar_rs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car7 = new JLabel("");
				car7.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_R_road.png")));
				car7.setBounds(717, 128, 70, 38);
				frame.getLayeredPane().add(car7,new Integer(80));
				frame.validate();
				T_goStraight2 tgs2=new T_goStraight2(car7,"car7",5);
				tgs2.start();
			}
		});
		addcar_rs.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_rs.setForeground(Color.WHITE);
		addcar_rs.setFont(new Font("����", Font.BOLD, 26));
		addcar_rs.setBounds(809, 116, 50, 50);
		frame.getContentPane().add(addcar_rs);
		
		JButton addcar_rl = new JButton("");
		addcar_rl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car8 = new JLabel("");
				car8.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_R_road.png")));
				car8.setBounds(717, 214, 70, 38);
				frame.getLayeredPane().add(car8,new Integer(80));
				frame.validate();
				T_goLeft2 tgl2=new T_goLeft2(car8,"car8",5);
				tgl2.start();
			}
		});
		addcar_rl.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_rl.setForeground(Color.WHITE);
		addcar_rl.setFont(new Font("����", Font.BOLD, 26));
		addcar_rl.setBounds(809, 202, 50, 50);
		frame.getContentPane().add(addcar_rl);
		
		JButton addcar_dl = new JButton("");
		addcar_dl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car9 = new JLabel("");
				car9.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_up.png")));
				car9.setBounds(473, 583, 38, 70);
				frame.getLayeredPane().add(car9,new Integer(80));
				frame.validate();
				T_goLeft tgl=new T_goLeft(car9,"car9",5);
				tgl.start();
			}
		});
		addcar_dl.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_dl.setForeground(Color.WHITE);
		addcar_dl.setFont(new Font("����", Font.BOLD, 26));
		addcar_dl.setBounds(473, 718, 50, 50);
		frame.getContentPane().add(addcar_dl);
		
		JButton addcar_dr = new JButton("");
		addcar_dr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car10 = new JLabel("");
				car10.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_up.png")));
				car10.setBounds(556, 583, 38, 70);
				frame.getLayeredPane().add(car10,new Integer(80));
				frame.validate();
			    T_goRight2 tgr2=new T_goRight2(car10,"car10",5);
				tgr2.start();
			}
		});
		addcar_dr.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_dr.setForeground(Color.WHITE);
		addcar_dr.setFont(new Font("����", Font.BOLD, 26));
		addcar_dr.setBounds(556, 718, 50, 50);
		frame.getContentPane().add(addcar_dr);
		
		
		
		
		START.setBounds(684, 707, 93, 23);
		frame.getContentPane().add(START);
		
		//change status button
		JButton STOP = new JButton("\u505C\u6B62\u8FD0\u884C");
		STOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				state = !state;			
				tgoleft.runCar(state);
				tgoLeft2.runCar(state);
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
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

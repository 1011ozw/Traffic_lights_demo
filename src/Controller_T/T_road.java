package Controller_T;
import img.*;

import java.io.IOException;

import Controller.TestWindowBuilder;
import Controller.goStraight;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class T_road {

	public JFrame frame;
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
		JMenu menu1=new JMenu("演示");
		menu1.setBackground(Color.LIGHT_GRAY);
		menu1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenu menu2=new JMenu("改变红绿灯");
		menu2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JMenu menu3=new JMenu("地图");
		menu2.setHorizontalAlignment(SwingConstants.LEFT);
		JMenuItem item10=new JMenuItem("重置");
		JMenuItem item11=new JMenuItem("加入车辆");
		JMenuItem item13=new JMenuItem("退出");
		JMenuItem item3=new JMenuItem("随机变换红绿灯");
		JMenuItem item22=new JMenuItem("设置左车道直行掉头绿灯");
		JMenuItem item24=new JMenuItem("设置右车道左转绿灯");
		JMenuItem item21=new JMenuItem("设置下车道左转绿灯");
		JMenuItem item4=new JMenuItem("加快红绿灯变换速度");
		JMenuItem item5=new JMenuItem("减慢红绿灯变换速度");
		
		JMenuItem item25=new JMenuItem("切换十字路口");
		JMenuItem item26=new JMenuItem("切换T字路口");
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
		
		//菜单栏功能实现
		TestWindowBuilder crossroad = new TestWindowBuilder();
		Refresh refresh = new Refresh();
		
		//重置功能
		item10.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	refresh.main(null);
            }

        });
		
		//退出功能
		item13.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            }

        });
		
		
		
		
		//跳转交叉路口
		item25.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            	
            	crossroad.main(null);
                
                
            }

        });
		
		
		
		//菜单栏功能实现结束

		
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
		car_s2.setBounds(748, 214, 70, 38);
		frame.getContentPane().add(car_s2);
		
		JLabel car_r2 = new JLabel("");
		car_r2.setIcon(new ImageIcon(TestWindowBuilder.class.getResource("/img/car3_R_road.png")));
		car_r2.setBounds(748, 128, 70, 38);
		frame.getContentPane().add(car_r2);
		
		JLabel car_down1 = new JLabel("");
		car_down1.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_up.png")));
		car_down1.setBounds(473, 680, 38, 70);
		frame.getContentPane().add(car_down1);
		
		car_down2 = new JLabel("");
		car_down2.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_up.png")));
		car_down2.setBounds(556, 680, 38, 70);
		frame.getContentPane().add(car_down2);
		
		JLabel showspeed = new JLabel("");
		showspeed.setForeground(Color.RED);
		showspeed.setBounds(9, 25, 203, 21);
		frame.getContentPane().add(showspeed);
		showspeed.setText("当前切换速度："+swift_speed);
		
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
				car4.setBounds(142, 277, 70, 38);
				frame.getLayeredPane().add(car4,new Integer(80));
				frame.validate();
				T_turn tturn2=new T_turn(car4,"car4",5);
				
				System.out.println("左边红绿灯的判断"+T_LightController_L.judge_l);
				
				tturn2.start();
			
				
			}
		});
		
		//调用函数类
		T_goLeft tgoleft=new T_goLeft(car_down1,"car_down1",5);
		T_goLeft2 tgoLeft2 = new T_goLeft2(car_s2, "car_s2", 5);
		T_goStraight tgoStraight=new T_goStraight(car1, "car1", 5);
		T_goStraight2 tgoStraight2=new T_goStraight2(car_r2, "car_r2", 5);
		T_goRight  tgoRight=new T_goRight(car2, "car2", 5);
		T_goRight2 tgoRight2 = new T_goRight2(car_down2, "car_down2", 5);
		T_turn tturn=new T_turn(car3,"car3",5);
		//红绿灯调用
		T_LightController_D tld = new T_LightController_D(Light_D); //下方红绿灯
		T_LightController_L tll = new T_LightController_L(Light_L); //左方红绿灯
		T_LightController_R tlr = new T_LightController_R(Light_R); //右方红绿灯
		//Start button
		JButton START = new JButton("\u5F00\u59CB\u8FD0\u884C");
		START.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				free=0;
				//车辆线程启动
				tgoleft.start();
				tgoLeft2.start();
				tgoStraight.start();
				tgoStraight2.start();
				tgoRight.start();
				tgoRight2.start();
				tturn.start();
				//红绿灯线程启动
                tld.start();
                tll.start();
                tlr.start();
			}
		});
		//加快红绿灯变换速度
		
		item4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(swift_speed==2000){
            		JOptionPane.showMessageDialog(null, "已经是最快切换速度了", "提示",JOptionPane.WARNING_MESSAGE);  
            	}
            	else{
            	swift_speed-=2000;
//            	T_LightController_D tld5 = new T_LightController_D(Light_D); //下方红绿灯
//        		T_LightController_L tll5 = new T_LightController_L(Light_L); //左方红绿灯
//        		T_LightController_R tlr5 = new T_LightController_R(Light_R); //右方红绿灯
//        		tld5.start();
//                tll5.start();
//                tlr5.start();
//                tld.stop();
//                tll.stop();
//                tlr.stop();
                showspeed.setText("当前切换速度："+swift_speed);
            	}
            }

        });
		
		//减慢红绿灯变换速度
		
		item5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	swift_speed+=2000;
//            	T_LightController_D tld6 = new T_LightController_D(Light_D); //下方红绿灯
//        		T_LightController_L tll6 = new T_LightController_L(Light_L); //左方红绿灯
//        		T_LightController_R tlr6 = new T_LightController_R(Light_R); //右方红绿灯
//        		tld6.start();
//                tll6.start();
//                tlr6.start();
//                tld.stop();
//                tll.stop();
//                tlr.stop();
                showspeed.setText("当前切换速度："+swift_speed);
            	}
        });
		//设置左车道直行掉头绿灯
				item22.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	free=1;
		            	T_LightController_D tld1 = new T_LightController_D(Light_D); //下方红绿灯
		        		T_LightController_L tll1 = new T_LightController_L(Light_L); //左方红绿灯
		        		T_LightController_R tlr1 = new T_LightController_R(Light_R); //右方红绿灯
		        		tld1.start();
		                tll1.start();
		                tlr1.start();
		               
		            }

		        });
	
				//设置右车道左转绿灯
				item24.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	free=3;
		            	T_LightController_D tld2 = new T_LightController_D(Light_D); //下方红绿灯
		        		T_LightController_L tll2 = new T_LightController_L(Light_L); //左方红绿灯
		        		T_LightController_R tlr2 = new T_LightController_R(Light_R); //右方红绿灯
		        		tld2.start();
		                tll2.start();
		                tlr2.start();
		                tld.stop();
		                tll.stop();
		                tlr.stop();
		              
		            }

		        });
				
				
				//设置下车道左转绿灯
				item21.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	free=2;
		            	T_LightController_D tld3 = new T_LightController_D(Light_D); //下方红绿灯
		        		T_LightController_L tll3 = new T_LightController_L(Light_L); //左方红绿灯
		        		T_LightController_R tlr3 = new T_LightController_R(Light_R); //右方红绿灯
		        		tld3.start();
		                tll3.start();
		                tlr3.start();
		                tld.stop();
		                tll.stop();
		                tlr.stop();
		              
		            }

		        });
				//设置随机变换红绿灯
				item3.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	free=0;
		            	T_LightController_D tld4 = new T_LightController_D(Light_D); //下方红绿灯
		        		T_LightController_L tll4 = new T_LightController_L(Light_L); //左方红绿灯
		        		T_LightController_R tlr4 = new T_LightController_R(Light_R); //右方红绿灯
		        		tld4.start();
		                tll4.start();
		                tlr4.start();
		                tld.stop();
		                tll.stop();
		                tlr.stop();
		          
		            }
				 });
			
				
		addcar_ll.setFont(new Font("宋体", Font.BOLD, 26));
		addcar_ll.setBounds(40, 277, 50, 50);
		frame.getContentPane().add(addcar_ll);
		
		JButton addcar_ls = new JButton("");
		addcar_ls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel car5 = new JLabel("");
				car5.setIcon(new ImageIcon(T_road.class.getResource("/img/car1.png")));
				car5.setBounds(142, 342, 70, 38);
				frame.getLayeredPane().add(car5,new Integer(80));
				frame.validate();
				T_goStraight tgs=new T_goStraight(car5,"car5",5);
				tgs.start();
				
			}
		});
		addcar_ls.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_ls.setForeground(Color.WHITE);
		addcar_ls.setFont(new Font("宋体", Font.BOLD, 26));
		addcar_ls.setBounds(40, 334, 50, 50);
		frame.getContentPane().add(addcar_ls);
		
		JButton addcar_lr = new JButton("");
		addcar_lr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car6 = new JLabel("");
				car6.setIcon(new ImageIcon(T_road.class.getResource("/img/car2.png")));
				car6.setBounds(142, 402, 70, 38);
				frame.getLayeredPane().add(car6,new Integer(80));
				frame.validate();
				T_goRight tgr=new T_goRight(car6,"car6",5);
				tgr.start();
			}
		});
		addcar_lr.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_lr.setForeground(Color.WHITE);
		addcar_lr.setFont(new Font("宋体", Font.BOLD, 26));
		addcar_lr.setBounds(40, 394, 50, 50);
		frame.getContentPane().add(addcar_lr);
		
		JButton addcar_rs = new JButton("");
		addcar_rs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car7 = new JLabel("");
				car7.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_R_road.png")));
				car7.setBounds(748, 128, 70, 38);
				frame.getLayeredPane().add(car7,new Integer(80));
				frame.validate();
				T_goStraight2 tgs2=new T_goStraight2(car7,"car7",5);
				tgs2.start();
			}
		});
		addcar_rs.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_rs.setForeground(Color.WHITE);
		addcar_rs.setFont(new Font("宋体", Font.BOLD, 26));
		addcar_rs.setBounds(828, 116, 50, 50);
		frame.getContentPane().add(addcar_rs);
		
		JButton addcar_rl = new JButton("");
		addcar_rl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car8 = new JLabel("");
				car8.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_R_road.png")));
				car8.setBounds(748, 214, 70, 38);
				frame.getLayeredPane().add(car8,new Integer(80));
				frame.validate();
				T_goLeft2 tgl2=new T_goLeft2(car8,"car8",5);
				tgl2.start();
			}
		});
		addcar_rl.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_rl.setForeground(Color.WHITE);
		addcar_rl.setFont(new Font("宋体", Font.BOLD, 26));
		addcar_rl.setBounds(828, 202, 50, 50);
		frame.getContentPane().add(addcar_rl);
		
		JButton addcar_dl = new JButton("");
		addcar_dl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car9 = new JLabel("");
				car9.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_up.png")));
				car9.setBounds(473, 680, 38, 70);
				frame.getLayeredPane().add(car9,new Integer(80));
				frame.validate();
				T_goLeft tgl=new T_goLeft(car9,"car9",5);
				tgl.start();
			}
		});
		addcar_dl.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_dl.setForeground(Color.WHITE);
		addcar_dl.setFont(new Font("宋体", Font.BOLD, 26));
		addcar_dl.setBounds(473, 756, 50, 50);
		frame.getContentPane().add(addcar_dl);
		
		JButton addcar_dr = new JButton("");
		addcar_dr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel car10 = new JLabel("");
				car10.setIcon(new ImageIcon(T_road.class.getResource("/img/car3_up.png")));
				car10.setBounds(556, 680, 38, 70);
				frame.getLayeredPane().add(car10,new Integer(80));
				frame.validate();
			    T_goRight2 tgr2=new T_goRight2(car10,"car10",5);
				tgr2.start();
			}
		});
		addcar_dr.setIcon(new ImageIcon(T_road.class.getResource("/img/timg.jpg")));
		addcar_dr.setForeground(Color.WHITE);
		addcar_dr.setFont(new Font("宋体", Font.BOLD, 26));
		addcar_dr.setBounds(556, 756, 50, 50);
		frame.getContentPane().add(addcar_dr);
		
		
		
		
		START.setBounds(723, 637, 93, 23);
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
		STOP.setBounds(723, 711, 93, 23);
		frame.getContentPane().add(STOP);
		
		JLabel tree_icon = new JLabel("");
		tree_icon.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		tree_icon.setBounds(28, 485, 50, 70);
		frame.getContentPane().add(tree_icon);
		tree t=new tree(tree_icon);
		t.start();
		
		JLabel t1 = new JLabel("");
		t1.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t1.setBounds(93, 485, 50, 70);
		frame.getContentPane().add(t1);
		tree tree1=new tree(t1);
		tree1.start();
		
		JLabel t2 = new JLabel("");
		t2.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t2.setBounds(162, 485, 50, 70);
		frame.getContentPane().add(t2);
		tree tree2=new tree(t2);
		tree2.start();
		
		JLabel t3 = new JLabel("");
		t3.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t3.setBounds(228, 485, 50, 70);
		frame.getContentPane().add(t3);
		tree tree3=new tree(t3);
		tree3.start();
		
		JLabel t4 = new JLabel("");
		t4.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t4.setBounds(228, 561, 50, 70);
		frame.getContentPane().add(t4);
		tree tree4=new tree(t4);
		tree4.start();
		
		JLabel t5 = new JLabel("");
		t5.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t5.setBounds(228, 637, 50, 70);
		frame.getContentPane().add(t5);
		tree tree5=new tree(t5);
		tree5.start();
		
		JLabel t6 = new JLabel("");
		t6.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t6.setBounds(228, 722, 50, 70);
		frame.getContentPane().add(t6);
		tree tree6=new tree(t6);
		tree6.start();
		
		JLabel t7 = new JLabel("");
		t7.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t7.setBounds(809, 485, 50, 70);
		frame.getContentPane().add(t7);
		tree tree7=new tree(t7);
		tree7.start();
		
		JLabel t8 = new JLabel("");
		t8.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t8.setBounds(748, 485, 50, 70);
		frame.getContentPane().add(t8);
		tree tree8=new tree(t8);
		tree8.start();
		
		JLabel t9 = new JLabel("");
		t9.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t9.setBounds(694, 485, 50, 70);
		frame.getContentPane().add(t9);
		tree tree9=new tree(t9);
		tree9.start();
		
		JLabel t10 = new JLabel("");
		t10.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t10.setBounds(639, 485, 50, 70);
		frame.getContentPane().add(t10);
		tree tree10=new tree(t10);
		tree10.start();
		
		JLabel t11 = new JLabel("");
		t11.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t11.setBounds(639, 561, 50, 70);
		frame.getContentPane().add(t11);
		tree tree11=new tree(t11);
		tree11.start();
		
		JLabel t12 = new JLabel("");
		t12.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t12.setBounds(639, 638, 50, 70);
		frame.getContentPane().add(t12);
		tree tree12=new tree(t12);
		tree12.start();
		
		JLabel t13 = new JLabel("");
		t13.setIcon(new ImageIcon(T_road.class.getResource("/img/tree0.png")));
		t13.setBounds(639, 722, 50, 70);
		frame.getContentPane().add(t13);
		tree tree13=new tree(t13);
		tree13.start();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(T_road.class.getResource("/img/f.jpg")));
		lblNewLabel.setBounds(27, 600, 185, 124);
		frame.getContentPane().add(lblNewLabel);
		
		
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

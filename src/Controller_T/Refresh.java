package Controller_T;

import java.awt.EventQueue;

public class Refresh {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T_road window = new T_road();
					window.main(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

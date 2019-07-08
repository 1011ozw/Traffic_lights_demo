package Controller;

public class PVController extends Thread{
	private static int pv_L_l;
	private static int pv_L_r;
	private static int pv_L_s;
	
	private static int pv_R_l;
	private static int pv_R_r;
	private static int pv_R_s;
	
	private static int pv_U_l;
	private static int pv_U_r;
	private static int pv_U_s;
	
	private static int pv_D_l;
	private static int pv_D_r;
	private static int pv_D_s;
	
	public PVController() {
		pv_L_l = 1;
		pv_L_r = 1;
		pv_L_s = 1;
		
		pv_R_l = 1;
		pv_R_r = 1;
		pv_R_s = 1;
	
		pv_U_l = 1;
		pv_U_r = 1;
		pv_U_s = 1;
		
		pv_D_l = 1;
		pv_D_r = 1;
		pv_D_s = 1;
	}
	
	public static int getPV_L_l() {
		return pv_L_l;
	}
	public static int getPV_L_r() {
		return pv_L_r;
	}
	public static int getPV_L_s() {
		return pv_L_s;
	}
	
	public static int getPV_R_l() {
		return pv_R_l;
	}
	public static int getPV_R_r() {
		return pv_R_r;
	}
	public static int getPV_R_s() {
		return pv_R_s;
	}
	
	public static int getPV_U_l() {
		return pv_U_l;
	}
	public static int getPV_U_r() {
		return pv_U_r;
	}
	public static int getPV_U_s() {
		return pv_U_s;
	}
	
	public static int getPV_D_l() {
		return pv_D_l;
	}
	public static int getPV_D_r() {
		return pv_D_r;
	}
	public static int getPV_D_s() {
		return pv_D_s;
	}
	
	public static void setPV_L_l(int pv_L_l_new) {
		pv_L_l = pv_L_l_new;
	}
	public static void setPV_L_r(int pv_L_r_new) {
		pv_L_r = pv_L_r_new;
	}
	public static void setPV_L_s(int pv_L_s_new) {
		pv_L_s = pv_L_s_new;
	}
	
	public static void setPV_R_l(int pv_R_l_new) {
		pv_R_l = pv_R_l_new;
	}
	public static void setPV_R_r(int pv_R_r_new) {
		pv_R_r = pv_R_r_new;
	}
	public static void setPV_R_s(int pv_R_s_new) {
		pv_R_s = pv_R_s_new;
	}
	
	public static void setPV_U_l(int pv_U_l_new) {
		pv_U_l = pv_U_l_new;
	}
	public static void setPV_U_r(int pv_U_r_new) {
		pv_U_r = pv_U_r_new;
	}
	public static void setPV_U_s(int pv_U_s_new) {
		pv_U_s = pv_U_s_new;
	}
	
	public static void setPV_D_l(int pv_D_l_new) {
		pv_D_l = pv_D_l_new;
	}
	public static void setPV_D_r(int pv_D_r_new) {
		pv_D_r = pv_D_r_new;
	}
	public static void setPV_D_s(int pv_D_s_new) {
		pv_D_s = pv_D_s_new;
	}
	
	
}

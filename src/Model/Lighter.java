package Model;


public class Lighter extends Thread{

	public String state;			//����ǰ�Ƶ�״̬
	private String top_left;		//�����ϳ��������
	private String top_straghter;	//�����ϳ���ֱ�еƺ������
	private String right_left;		//�����ҳ��������
	private String right_straight;	//�����ҳ���ֱ�е�
	private String down_left;		//�����³��������
	private String down_straight;	//�����³���ֱ�е�
	private String left_left;		//�����󳵵������
	private String left_straight;	//�����󳵵�ֱ�е�
//	public Lighter(String top_left,String top_straghter,String right_left,String right_straight,String down_left,String down_straight,String left_left,String left_straight) 
//	{
//		this.top_left=top_left;
//		this.top_straghter=top_straghter;
//		this.right_left=right_left;
//		this.right_straight=right_straight;
//		this.down_left=down_left;
//		this.down_straight=down_straight;
//		this.left_left=left_left;
//		this.left_straight=left_straight;
//	}
	public void run() {
		while(true) {
			try {
				//��ʼ״̬��Ϊ���³�����������̵ƣ�ֱ�еơ�����ƺ�ƣ�
				state="top-down-left";
				System.out.println("���������³���������̵�");
				this.top_left="green";
				this.top_straghter="red";
				this.right_left="red";
				this.right_straight="red";
				this.down_left="green";
				this.down_straight="red";
				this.left_left="red";
				this.left_straight="red";
				Thread.sleep(10*1000);//10���Ӻ�Ʊ����ɫ�ģ�����ɫʱ��λ5��
				
				//���³���������ƺ�ƣ�ֱ�еơ�������̵ƣ� 
				state="top-down-straight";
				System.out.println("���������³���ֱ�е��̵�");
				this.top_left="red";
				this.top_straghter="green";
				this.right_left="red";
				this.right_straight="red";
				this.down_left="red";
				this.down_straight="green";
				this.left_left="red";
				this.left_straight="red";
				Lighter.sleep(5*1000);
				
				//���ҳ�����������̵ƣ�ֱ�еơ�����ƺ�ƣ�
				state="left-right-left";
				System.out.println("���������ҳ���ֱ�е��̵�");
				this.top_left="red";
				this.top_straghter="red";
				this.right_left="green";
				this.right_straight="red";
				this.down_left="red";
				this.down_straight="red";
				this.left_left="green";
				this.left_straight="red";
				Lighter.sleep(5*1000);
				
				//���ҳ�����������̵ƣ�ֱ�еơ�����ƺ�ƣ�
				state="left-right-left";
				System.out.println("���������ҳ���ֱ�е��̵�");
				this.top_left="red";
				this.top_straghter="red";
				this.right_left="green";
				this.right_straight="red";
				this.down_left="red";
				this.down_straight="red";
				this.left_left="green";
				this.left_straight="red";
				Lighter.sleep(5*1000);
				
				//���ҳ���������ƺ�ƣ�ֱ�еơ�������̵ƣ�
				state="left-right-left";
				System.out.println("���������ҳ���ֱ�е��̵�");
				this.top_left="red";
				this.top_straghter="red";
				this.right_left="red";
				this.right_straight="green";
				this.down_left="red";
				this.down_straight="red";
				this.left_left="red";
				this.left_straight="green";
				Lighter.sleep(5*1000);
			}catch (Exception e) {
				// ������
				System.out.println("������:"+e);
			}
		}
	}
}

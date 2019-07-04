package Model;


public class Lighter extends Thread{

	public String state;			//代表当前灯的状态
	private String top_left;		//代表上车道左向灯
	private String top_straghter;	//代表上车道直行灯和右向灯
	private String right_left;		//代表右车道左向灯
	private String right_straight;	//代表右车道直行灯
	private String down_left;		//代表下车道左向灯
	private String down_straight;	//代表下车道直行灯
	private String left_left;		//代表左车道左向灯
	private String left_straight;	//代表左车道直行灯
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
				//初始状态设为上下车道（左向灯绿灯，直行灯、右向灯红灯）
				state="top-down-left";
				System.out.println("现在是上下车道左向灯绿灯");
				this.top_left="green";
				this.top_straghter="red";
				this.right_left="red";
				this.right_straight="red";
				this.down_left="green";
				this.down_straight="red";
				this.left_left="red";
				this.left_straight="red";
				Thread.sleep(10*1000);//10秒钟后灯变成绿色的，设绿色时间位5秒
				
				//上下车道（左向灯红灯，直行灯、右向灯绿灯） 
				state="top-down-straight";
				System.out.println("现在是上下车道直行灯绿灯");
				this.top_left="red";
				this.top_straghter="green";
				this.right_left="red";
				this.right_straight="red";
				this.down_left="red";
				this.down_straight="green";
				this.left_left="red";
				this.left_straight="red";
				Lighter.sleep(5*1000);
				
				//左右车道（左向灯绿灯，直行灯、右向灯红灯）
				state="left-right-left";
				System.out.println("现在是左右车道直行灯绿灯");
				this.top_left="red";
				this.top_straghter="red";
				this.right_left="green";
				this.right_straight="red";
				this.down_left="red";
				this.down_straight="red";
				this.left_left="green";
				this.left_straight="red";
				Lighter.sleep(5*1000);
				
				//左右车道（左向灯绿灯，直行灯、右向灯红灯）
				state="left-right-left";
				System.out.println("现在是左右车道直行灯绿灯");
				this.top_left="red";
				this.top_straghter="red";
				this.right_left="green";
				this.right_straight="red";
				this.down_left="red";
				this.down_straight="red";
				this.left_left="green";
				this.left_straight="red";
				Lighter.sleep(5*1000);
				
				//左右车道（左向灯红灯，直行灯、右向灯绿灯）
				state="left-right-left";
				System.out.println("现在是左右车道直行灯绿灯");
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
				// 出错报错
				System.out.println("出错了:"+e);
			}
		}
	}
}

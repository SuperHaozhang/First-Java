import java.util.*;

public class Test{
	public static void main(String[] args) {
		Loging b = new Loging();
		b.showMainMenu();
	}
}
/*
*
* 注册信息
*/
class Name{

	String name; //用户名
	String pass; //用户密码
	int num ;	 //用户积分
	int age;	 //用户年龄
	int card;    //会员卡号
	double zhifubao; //支付宝金额
	double weixin;	 //微信金额
	double yinlianka;//银联卡金额


	public void print(){	
		System.out.println(name+"\t"+pass+"\t"+age+"\t"+num+"\t\t"+card+"\t\t"+zhifubao+"\t\t"+weixin+"\t\t"+yinlianka);
	}
}
/**
*
* 注册登录模块
*/
class Loging{
	Scanner sc = new Scanner(System.in);	
	Random rd = new Random();
	MemberNum s = new MemberNum();	
	Commodity s1 = new Commodity();
	public void showMainMenu(){
		boolean b = true;
		do{
			System.out.println("\t1.系统登录模块\n\t2.会员信息管理模块\n\t3.购物管理");
			System.out.print("\t4.真情回馈\n\t5.退出\n请选择输入数字:");
			int num = sc.nextInt();
			switch(num){
				case 1:landing();
					break;
				case 2:
					if(!(s.ss==null)){
						infor();
					}
					break;
				case 3:shopping();
					break;
				case 4:feedback();
					break;
				case 5:
					b = false;
					break;
			}
		}while(b);
	}
	//主界面1
	public void landing(){
		String y = "y";
		System.out.println("我行我素购物系统>系统登录");
		while(y.equals("y")){		
			System.out.print("\t1:登录：\n\t2:修改管理员密码\n\t0:退出\n请选择对应功能:");
			int num1 = sc.nextInt();
			switch(num1){
				case 1:denglu();
					break;
				case 2:if(!(s.ss==null)){
						xiugai();
					}	
					break;				
				case 0:y="n";
					break;
			}		
		}
	}
	//注册方法
	public void registered(){
		Name a = new Name();
		System.out.println("欢迎注册我行我素购物系统！");
		System.out.print("请输入你的注册账号：");
		a.name = sc.next();
		System.out.print("请输入你的注册密码：");
		a.pass = sc.next();
		System.out.print("请输入你的真实年龄：");
		a.age = sc.nextInt();
		a.card = rd.nextInt(9999)+1000;
		a.zhifubao = 200000;
		a.weixin = 200000;
		a.yinlianka = 200000;
		s.account(a);
		System.out.println("注册成功！！！请牢记你的会员卡号及密码");
	}
	//登录界面展示
	public void denglu(){
		System.out.println("请输入账号：");
		String name1 = sc.next();
		System.out.println("请输入密码：");
		String pass1 = sc.next();
		if(s.ss==null){
			s.ss = s.signin1();
		}
		if(s.deng(name1,pass1))
		{
			System.out.println("登陆成功");
		}
		else
		{
			System.out.println("登陆失败");
		}

	}
	//修改管理员密码界面展示
	public void xiugai(){
		System.out.println("请输入账号：");
		String name1 = sc.next();
		System.out.println("请输入密码：");
		String pass1 = sc.next();
		System.out.print("请输入新密码:");
		String pass2 = sc.next();
		if(s.xiu(name1,pass1,pass2)){
			System.out.println("密码修改成功");
		}
		else{
			System.out.println("你没有权限修改!!!");
		}
	}

	//会员信息管理
	//主界面2
	public void infor(){
		String y = "y";
		while(y.equals("y")){
			System.out.println("***************************************");
			System.out.println("我行我素购物系统>会员信息管理");		
			System.out.println("\t1:显示所有会员信息\n\t2:统计会员年龄层次");
			System.out.println("\t3:添加会员信息\n\t4:查询会员积分");
			System.out.println("\t5:系统积分年度升级\n\t6:注册\n\t0:退出");
			System.out.println("****************************************");	
			System.out.print("请选择对应功能:");	
			int num1 = sc.nextInt();
			switch(num1){
				case 1:print1(); //1:显示所有会员信息
					break;
				case 2:print2(); //2:统计会员年龄层次
					break;
				case 3:print3(); //3:添加会员信息
					break;
				case 4:print4(); //4:查询会员积分
					break;
				case 5:print5(); //5:系统积分年度升级
					break;
				case 6:registered(); //6:注册
					break;
				case 0:y="n";
					break;

			}		
		}
	}
	//1:显示所有会员信息
	public void print1(){
		s.print0();
	}

	//2:统计会员年龄层次
	public void print2(){
		System.out.println("18岁至30岁会员占比："+s.age(1)+"%");
		System.out.println("30岁至40岁会员占比："+s.age(2)+"%");
		System.out.println("40岁至50岁会员占比："+s.age(3)+"%");
		System.out.println("50岁以上会员占比："+s.age(4)+"%");
	}

	//3:添加会员信息
	public void print3(){
		Name a = new Name();
		System.out.print("请输入你的添加账号：");
		a.name = sc.next();
		System.out.print("请输入你的账号密码：");
		a.pass = sc.next();
		System.out.print("请输入你的真实年龄：");
		a.age = sc.nextInt();
		System.out.print("添加会员积分:");
		a.num = sc.nextInt();
		System.out.print("添加会员卡号:");
		a.card = sc.nextInt();
		System.out.print("添加支付宝金额:");
		a.zhifubao = sc.nextInt();
		System.out.print("添加微信金额:");
		a.weixin = sc.nextInt();
		System.out.print("添加银联卡金额:");
		a.yinlianka = sc.nextInt();
		s.account(a);
	}

	//4:查询会员积分
	public void print4(){
		System.out.println("请输入你想查询积分的卡号:");
		int card1 = sc.nextInt();
		System.out.println("你查询的卡号"+card1+"会员积分为:"+s.inQuire(card1));
	}

	//5:系统积分年度升级
	public void print5(){
		
	}

	//购物管理
	//主界面3
	public void shopping(){
		String y = "y";
		s1.shop1();
		while(y.equals("y")){
			System.out.println("***************************************");
			System.out.println("我行我素购物系统>购物管理");		
			System.out.println("\t1:查询商品价格\n\t2:购物结算计算");
			System.out.println("\t3:当月购物金额\n\t4:设置特价商品\n\t0:退出");
			System.out.println("****************************************");	
			System.out.print("请选择对应功能:");	
			int num1 = sc.nextInt();
			switch(num1){
				case 1:shop1(); //1:查询商品价格
					break;
				case 2:shop2(); //2:购物结算计算
					break;
				case 3:shop3(); //3:当月购物金额
					break;
				case 4:shop4(); //4:设置特价商品
					break;
				case 0:y="n";
					break;

			}		
		}
	}
	//查询商品价格
	public void shop1(){
		s1.shop2();
	}
	//购物结算计算
	public void shop2(){
		double money2=0;
		s1.shop2();
		System.out.print("你想购买什么商品:请选择对应编号:");
		int num1 = sc.nextInt();
		System.out.print("你想购买多少:");
		int num2 = sc.nextInt();
		money2=s1.shop3(num1,num2);
		System.out.println("你一共需要支付："+money2);
		System.out.print("请输入你的会员卡号：");
		int card2= sc.nextInt();
		if(s.lottery(card2)){
			for(int i=0;i<s.a1.length;i++){
				if(card2==s.a1[i].card){
					System.out.println("请选择使用哪种支付工具支付:1.支付宝\t2.微信\t3.银联卡");
					int z = sc.nextInt();
					switch(z){
						case 1:
							s.zhfubao(i,money2);
							break;
						case 2:
							s.weixin(i,money2);
							break;
						case 3:
							s.weixin(i,money2);
							break;
					}
					s.a1[i].num+=(int)money2/100;
					s1.money=0;
					break;
				}
			}
		}
		else{
			System.out.println("你输入的卡号错误！！！");
		}

	}
	//当月购物金额
	public void shop3(){
		
	}
	//设置特价商品
	public void shop4(){		
		shop1();
		System.out.print("请选择对应编号设置特价商品:");
		int num1 = sc.nextInt();
		System.out.print("请输入商品新的价格:");
		double money1 = sc.nextDouble();
		s1.shop4(num1,money1);
		s1.shop2();

	}

	//真情回馈
	//主界面4
	public void feedback(){
		String y = "y";
		while(y.equals("y")){
			System.out.println("***************************************");
			System.out.println("我行我素购物系统>真情回馈");		
			System.out.println("\t1:幸运抽奖\n\t2:礼品馈赠");
			System.out.println("\t3:查找幸运会员\n\t0:退出");
			System.out.println("****************************************");	
			System.out.print("请选择对应功能:");	
			int num1 = sc.nextInt();
			switch(num1){
				case 1:feed(); //1:幸运抽奖
					break;
				case 2:feed1(); //2:礼品馈赠
					break;
				case 3:feed2(); //3:查找幸运会员
					break;
				case 0:y="n";
					break;

			}		
		}
	}

	//幸运抽奖
	public void feed(){
		System.out.print("请输入你的卡号:");
		int card1 = sc.nextInt();
		if(s.lottery(card1)){
			int[] num = new int[5];
			for(int i=0;i<5;i++){
				num[i]=rd.nextInt(9000)+1000;
				System.out.print(num[i]+",");
			}
			if(card1==num[0]||card1==num[1]||card1==num[2]||card1==num[3]||
				card1==num[4]){
				System.out.println("中奖！！");
			}
			else{
				System.out.println("没！！");
			}

		}
		else{
			System.out.println("你输入的卡号错误！！！");
		}
		System.out.println();
		
	}

	//礼品馈赠
	public void feed1(){

	}

	//查找幸运会员
	public void feed2(){

	}
}
/**
*
* 商品信息管理
*/
class Commodity{
	String shopName;
	double shopmoney;
	double money;
	Commodity[] cd = new Commodity[10];;
	public void shop1(){
		
		cd[0] = new Commodity();
		cd[0].shopName = "电风扇";
		cd[0].shopmoney = 124.23;

		cd[1] = new Commodity();
		cd[1].shopName = "洗衣机";
		cd[1].shopmoney = 4500.0;

		cd[2] = new Commodity();
		cd[2].shopName = "电视机";
		cd[2].shopmoney = 8800.9;

		cd[3] = new Commodity();
		cd[3].shopName = "冰箱";
		cd[3].shopmoney = 5000.88;

		cd[4] = new Commodity();
		cd[4].shopName = "空调";
		cd[4].shopmoney = 4456.0;

	} 

	public void shop2(){
		System.out.println("商品名称");
		for(int i=0;i<cd.length;i++){
			if(cd[i]!=null){
				System.out.println("\tNO."+(i+1)+":"+cd[i].shopName+"\t"+cd[i].shopmoney);
			}
		}
	}

	//购物清算
	public double shop3(int num1,int num2){
		money +=cd[num1-1].shopmoney*num2;
		return money;
	}

	//特价商品
	public double shop4(int num1,double money){
		return cd[num1-1].shopmoney=money;
	}
}

/**
*
* 会员信息存储
*/
class MemberNum implements Zhifu{
	String user;
	String pass;
	int count1;
	MemberNum[] ss;
	Name[] a1 = new Name[10];
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	//注册存储
	public void account(Name a){
		for(int i=0;i<a1.length;i++){
			if(a1[i]==null){
				a1[i]=a;
				count1++;
				break;
			}
		}
	}
	//显示账户信息
	public void print0(){
		System.out.println("用户名\t密码\t年龄\t会员积分\t会员卡号\t支付宝余额\t微信余额\t银联卡余额");
		for(int i=0;i<a1.length;i++){
			if(a1[i]!=null){
				a1[i].print();
			}
		}
	}
	//管理员账户密码
	public MemberNum[] signin1(){
		ss = new MemberNum[2];

		ss[0] = new MemberNum();
		ss[0].user = "admin1";
		ss[0].pass = "123456";

		ss[1] = new MemberNum();
		ss[1].user = "admin2";
		ss[1].pass = "123456";

		return ss;
	}
	//登录数据处理
	public boolean deng(String name,String pass1){
		for(MemberNum s1 : ss){
			if(s1.user.equals(name)&&s1.pass.equals(pass1)){
				return true;
			}
		}
		return false;	
	}
	//修改密码数据处理
	public boolean xiu(String name,String pass1,String pass2){
		for(int i=0;i<ss.length;i++){
			if(ss[i].user.equals(name)&&ss[i].pass.equals(pass1)){
				ss[i].pass = pass2;
				return true;
			}
		}

		return false;
	}
	//会员年龄层次查询
	public double age(int a){
		double count=0;
		if(a==1){
			for(int i=0;i<a1.length;i++){
				if(a1[i]!=null){
					if(a1[i].age>=18&&a1[i].age<=30)
						count++;
				}	
			}
			return count%10*10;
		}
		else if(a==2){
			for(int i=0;i<a1.length;i++){
				if(a1[i]!=null){
					if(a1[i].age>30&&a1[i].age<=40)
						count++;
				}	
			}
			return count%10*10;
		}
		else if(a==3){
			for(int i=0;i<a1.length;i++){
				if(a1[i]!=null){
					if(a1[i].age>40&&a1[i].age<=50)
						count++;
				}	
			}
			return count%count1*10;
		}
		else{
			for(int i=0;i<a1.length;i++){
				if(a1[i]!=null){
					if(a1[i].age>50)
						count++;
				}	
			}
			return count%10*10;			
		}
	}

	//添加会员信息
	public void addTo(String name1,String pass1,int s){
		for(int i=0;i<a1.length;i++){
			if(a1[i]!=null){
				if(a1[i].name.equals(name1)&&a1[i].pass.equals(pass1)){
					if(s==1){//1为添加客户积分
						System.out.print("请添加客户积分:");
						a1[i].num = sc.nextInt();
					}
					else if(s==2){//2修改客户卡号
						System.out.print("请修改客户卡号:");
						a1[i].card = sc.nextInt();
					}
					else{
						break;
					}
				}
			}
		}
	}

	//查询会员积分
	public int inQuire(int card1){
		for(int i=0;i<a1.length;i++){
			if(a1[i]!=null){
				if(a1[i].card==card1){
					return a1[i].num;
				}
			}
		}
		return 0;
	}

	//系统积分年度升级
	public void upGrade(){
		
	}

	//真情回馈大抽奖
	public boolean lottery(int card1){
		for(int i=0;i<a1.length;i++){
			if(a1[i]!=null){
				if(card1==a1[i].card){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void zhfubao(int i,double money2){
		if(a1[i].weixin>money2){
			System.out.println("使用支付宝支付成功,扣除"+money2+"元");
			a1[i].weixin-=money2;
		}
		else{
			System.out.println("余额不足，请重新支付！！");
		}
	}
	@Override
	public void weixin(int i,double money2){
		if(a1[i].weixin>money2){
			System.out.println("使用微信支付成功,扣除"+money2+"元");
			a1[i].weixin-=money2;
		}
		else{
			System.out.println("余额不足，请重新支付！！");
		}
		
	}
	@Override
	public void yinlian(int i,double money2){
		if(a1[i].weixin>money2){
			System.out.println("使用银联卡支付成功,扣除"+money2+"元");
			a1[i].weixin-=money2;
		}
		else{
			System.out.println("余额不足，请重新支付！！");
		}
	}
}

interface Zhifu{
	public void zhfubao(int i,double a);

	public void weixin(int i,double a);

	public void yinlian(int i,double a);
}
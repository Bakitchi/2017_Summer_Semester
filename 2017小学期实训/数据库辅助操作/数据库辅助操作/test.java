
import java.sql.SQLException;
import java.util.ArrayList;

import dao.*;
import bean.*;
public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try {
		DaoSql db = new DaoSql();
		
		//获取所有商品
		System.out.println("获取所有商品");
		
		ArrayList<Stuff> stuffList=db.getStuffsAll();
		for (int i = 0; i < stuffList.size(); i++) {
			Stuff tempStuff=stuffList.get(i);
		System.out.println("商品id："+tempStuff.getSid()+"  商品名"+tempStuff.getSname()+"   商品价格："+tempStuff.getPrice());	
		}
		
		//获取帐号为白靖的收藏商品：
		System.out.println("获取帐号为白靖的收藏商品：");
		
		String uid="baijing";
		
		ArrayList<Stuff> stuffListcs=db.getStuffsSC(uid);
		for (int i = 0; i < stuffListcs.size(); i++) {
			Stuff tempStuff=stuffListcs.get(i);
		System.out.println("商品id："+tempStuff.getSid()+"  商品名:"+tempStuff.getSname()+"   商品价格："+tempStuff.getPrice());	
		}
		
		//获取帐号为baijing的购物车商品：
		System.out.println("获取帐号为白靖的购物车商品：");
		ArrayList<Stuff> stuffListgwc=db.getStuffsGWC(uid);
		for (int i = 0; i < stuffListgwc.size(); i++) {
			Stuff tempStuff=stuffListgwc.get(i);
		System.out.println("商品id："+tempStuff.getSid()+"  商品名:"+tempStuff.getSname()+"   商品价格："+tempStuff.getPrice()+"  购买数量："+tempStuff.getNum());	
		}
		
		//获取草莓味商品
		String taste="草莓";
		System.out.println("获取草莓味商品：");
		ArrayList<Stuff> stuffListTaste=db.getStuffsByTaste(taste);
		for (int i = 0; i < stuffListTaste.size(); i++) {
			Stuff tempStuff=stuffListTaste.get(i);
		System.out.println("商品id："+tempStuff.getSid()+"  商品名:"+tempStuff.getSname()+"   商品价格："+tempStuff.getPrice()+"  购买数量："+tempStuff.getNum());	
		}
		
		//获取yoghourt类型商品
		String type="yoghourt";
		System.out.println("获取yoghourt类型商品");
		ArrayList<Stuff> stuffListType=db.getStuffsByType(type);
		for (int i = 0; i < stuffListType.size(); i++) {
			Stuff tempStuff=stuffListType.get(i);
		System.out.println("商品id："+tempStuff.getSid()+"  商品名:"+tempStuff.getSname()+"   商品价格："+tempStuff.getPrice()+"  购买数量："+tempStuff.getNum());	
		}
				
		//检验baijing帐号是否已存在
		System.out.println("\n检验白靖帐号是否已存在\n");
		uid="baijing";
		if(db.checkRegister(uid))
			System.out.println("帐号baijing已存在");
		else 
			System.out.println("帐号baijing不存在");
		
		//检验baijing帐号密码是否正确
		System.out.println("\n检验帐号baijing密码baijing111是否正确\n");
		uid="baijing";
		String password ="baijing111";
		if(db.checkLogin(uid, password))
		System.out.println("帐号和密码正确");
		else 
		System.out.println("帐号或密码不正确");
		
		//获取baijing帐号信息
		System.out.println("\n获取baijing帐号信息\n");
		if(db.checkLogin(uid, password)){
		User user = db.getUser(uid, password);
		System.out.println("   帐号：    "+user.getUid()+"  密码：    "+user.getPassword()+"   电话：    "+user.getPhone()+"   头像路径 ：    "+user.getHeadphoto()+"   签名：    "+user.getText());
		}
		else 
		System.out.println("帐号或密码不正确");
		
		//获取baijing帐号地址信息
		System.out.println("\n获取baijing帐号地址信息\n");
		ArrayList<Address> addressesList=db.getAddressesByUid(uid);
		for (int i = 0; i < addressesList.size(); i++) {
			int j=i+1;
			if (addressesList.get(i).getDeft())
			System.out.println("第"+j+"个地址为："+addressesList.get(i).getAddress()+"  是默认地址");
			else 
			System.out.println("第"+j+"个地址为："+addressesList.get(i).getAddress()+"  不是默认地址");	
		
		}
		
		//获取单个商品的信息
		System.out.println("\n获取单个商品的信息\n");
		Stuff tempStuff =db.getStuffBySid(1);
		System.out.println("商品id："+tempStuff.getSid()+"  商品名:"+tempStuff.getSname()+"   商品价格："+tempStuff.getPrice()+"  购买数量："+tempStuff.getNum());	
		
		//插入一条收藏纪录
		System.out.println("\n插入一条收藏纪录\n");
		if(db.setScById(2, "xinghy"))
			System.out.println("\n插入收藏成功\n");
		else 
			System.out.println("\n插入收藏失败\n");
		
		//插入订单纪录
		System.out.println("\n插入订单纪录\n");
		db.setDdById(2, "xinghy", 3);
		System.out.println("\n插入订单成功\n");
		//加入一条购物车纪录
		System.out.println("\n加入一条购物车纪录\n");
		db.setGwcById(2, "xinghy", 3);
		System.out.println("\n插入购物车成功\n");
		//更改一条购物车纪录
		System.out.println("\n加入一条购物车纪录\n");
		db.setGwcNum(2, "xinghy", 3);
		System.out.println("\n更改成功\n");
		//删除一条收藏纪录
		System.out.println("\n删除一条收藏纪录\n");
		db.deletScById(2, "xinghy");
		System.out.println("\n删除成功\n");
		//删除一条购物车纪录
		System.out.println("\n删除一条购物车纪录\n");
		db.deletGwcById(2, "xinghy");
		System.out.println("\n删除成功\n");
		
		//检查收藏纪录
		System.out.println("\n检查收藏纪录\n");
		if(db.checkScById(20, "xinghy"))
			System.out.println("\n收藏存在\n");
		else
			System.out.println("\n收藏不存在\n");
		

		//获取帐号为baijing的订单商品：
		System.out.println("获取帐号为白靖的订单商品：");
		ArrayList<Stuff> stuffListdd=db.getStuffsDd(uid);
		for (int i = 0; i < stuffListdd.size(); i++) {
			 tempStuff=stuffListdd.get(i);
		System.out.println("商品id："+tempStuff.getSid()+"  商品名:"+tempStuff.getSname()+"   商品价格："+tempStuff.getPrice()+"  购买数量："+tempStuff.getNum()+"  订单编号： "+tempStuff.getDid());	
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.print("类加载出错");
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.print("数据库访问出错");
		e.printStackTrace();
	}     
 }
}

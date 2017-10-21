package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import java.util.ArrayList;

import bean.Stuff;
import bean.User;
import bean.Address;

public class DaoSql {
	 private Connection conn=null;
	 private Statement state=null;
	 private String url="jdbc:mysql://192.168.0.19/mall";
	 private String user="cyz";
	 private String password="qsdb";
	 private String sql="";
	 //初始化连接
	 public DaoSql() throws ClassNotFoundException, SQLException{
		 Class.forName("com.mysql.jdbc.Driver");
		 conn=DriverManager.getConnection(url, user, password);
	 }
	 //关闭连接
	 public void Close() throws SQLException{
		 conn.close();

	 }
	 //获取收藏商品
	 public ArrayList<Stuff> getStuffsSC(String uid) throws SQLException{
		 ArrayList<Stuff> stuffsList=new ArrayList<Stuff>();	 
		 state=conn.createStatement();
		  sql="select stuff.sid,sname,sphoto,price from stuff,sc where stuff.sid=sc.sid and uid="+"'"+uid+"'";
		  ResultSet rs=state.executeQuery(sql);
		  while (rs.next()){
			  stuffsList.add(new Stuff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4)));
		  }
		 rs.close();
		 return stuffsList;
	 }
	 //获取购物车中的商品
	 public ArrayList<Stuff> getStuffsGWC(String uid) throws SQLException{
		 ArrayList<Stuff> stuffsList=new ArrayList<Stuff>();	
		 state=conn.createStatement();
		 sql="select stuff.sid,sname,sphoto,price,num from stuff,gwc where stuff.sid=gwc.sid and uid="+"'"+uid+"'";
		 ResultSet rs=state.executeQuery(sql);
		 while (rs.next()){
			 stuffsList.add(new Stuff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5)));
		 }
		 rs.close();
		 return stuffsList;
	 }
	 //获取订单商品
	 public ArrayList<Stuff> getStuffsDd(String uid) throws SQLException{
		 ArrayList<Stuff> stuffsList=new ArrayList<Stuff>();	
		 state=conn.createStatement();
		 sql="select stuff.sid,sname,sphoto,price,num,did from stuff,dd where dd.sid=stuff.sid and dd.uid='"+uid+"'";
		 ResultSet rs=state.executeQuery(sql);
		 while (rs.next()){
			 stuffsList.add(new Stuff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6)));
		 }
		 rs.close();
		 return stuffsList;
	 }
	 //获取所有商品
	 public ArrayList<Stuff> getStuffsAll() throws SQLException{
		 ArrayList<Stuff> stuffsList=new ArrayList<Stuff>();	
		 state=conn.createStatement();
		 sql="select sid,sname,sphoto,price from stuff";
		 ResultSet rs=state.executeQuery(sql);
		 while (rs.next()){
			 stuffsList.add(new Stuff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4)));
		 }
		 rs.close();
		 return stuffsList;
	 }
	 //检验注册是否合法
	 public boolean checkRegister(String uid) throws SQLException{
		 sql ="select * from user where uid="+"'"+uid+"'";
		 ResultSet rs =state.executeQuery(sql);
		 while (rs.next()){
			 return true;
		 }
		 return false;
	 }
	 //检测登陆是否合法
	 public boolean checkLogin(String uid,String password) throws SQLException{
		 sql ="select * from user where uid="+"'"+uid+"'and password = '"+password+"'";
		 ResultSet rs =state.executeQuery(sql);
		 while (rs.next()){
			 return true;
		 }
		 return false;
	 }
	 //按口味获取商品
	 public ArrayList<Stuff> getStuffsByTaste(String taste) throws SQLException{
		 ArrayList<Stuff> stuffsList=new ArrayList<Stuff>();	
		 state=conn.createStatement();
		 sql="select sid,sname,sphoto,price from stuff where taste = '"+taste+"'";
		 ResultSet rs=state.executeQuery(sql);
		 while (rs.next()){
			 stuffsList.add(new Stuff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4)));
		 }
		 rs.close();
		 return stuffsList;
	 }
	 //按类型获取商品
	 public ArrayList<Stuff> getStuffsByType(String type) throws SQLException{
		 ArrayList<Stuff> stuffsList=new ArrayList<Stuff>();	
		 state=conn.createStatement();
		 sql="select sid,sname,sphoto,price from stuff where stype = '"+type+"'";
		 ResultSet rs=state.executeQuery(sql);
		 while (rs.next()){
			 stuffsList.add(new Stuff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4)));
		 }
		 rs.close();
		 return stuffsList;
	 }
	 //获取用户
	 public User getUser(String uid,String password) throws SQLException{
		 User user = null;
		 state=conn.createStatement();
		 sql="select uid,password,phone,headphoto,text from user where uid = '"+uid+"'and password ='"+password+"'";
		 ResultSet rs=state.executeQuery(sql);
		 while(rs.next()){
			user=new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
		 }
		 return user;
	 }
	 //获取用户地址
	 public ArrayList<Address> getAddressesByUid(String uid) throws SQLException{
		 ArrayList<Address> addressesList =new ArrayList<Address>();
		 state=conn.createStatement();
		 
		 sql="SELECT address,deft FROM address WHERE uid='"+uid+"'";
		 ResultSet rs= state.executeQuery(sql);
		 while(rs.next()){
			 addressesList.add(new Address(rs.getString(1), rs.getBoolean(2)));
		 }
		 return addressesList;
	 }
	//获取单个商品的信息
	public Stuff getStuffBySid(int sid) throws SQLException{
		Stuff stuff=null;
		state=conn.createStatement();
		sql="select sid,sname,sphoto,price from stuff where sid = '"+sid+"'";
		ResultSet rs= state.executeQuery(sql);
		while(rs.next()){
			stuff=new Stuff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
		}
		return stuff;
	}
	//插入收藏纪录
	public boolean setScById(int sid,String uid) throws SQLException{
		state=conn.createStatement();
		sql="select * from sc  where sid = '"+sid+"' and uid = '"+uid+"'";
		ResultSet rs =state.executeQuery(sql);
		while(rs.next()){
			return false;
		}
		
		sql="INSERT INTO sc VALUES("+sid+",'"+uid+"')";
		state.executeUpdate(sql);
		return true;
	}
	//插入订单纪录
	public boolean setDdById(int sid,String uid,int num) throws SQLException{
		state=conn.createStatement();		
		sql="INSERT INTO dd (sid,uid,num) VALUES("+sid+",'"+uid+"',"+num+")";
		state.executeUpdate(sql);
		return true;
	}
	//插入购物车纪录
	public boolean setGwcById(int sid,String uid,int num) throws SQLException{
		state=conn.createStatement();
		sql="select * from sc  where sid = "+sid+" and uid = '"+uid+"'";
		ResultSet rs =state.executeQuery(sql);
		while(rs.next()){
			sql="UPDATE gwc  SET num = num + "+num+" WHERE sid = "+sid+" AND uid='"+ uid+"'";
		    state.executeUpdate(sql);
		    return true;
		}
		
		sql="INSERT INTO gwc (sid,uid,num) VALUES("+sid+",'"+uid+"',"+num+")";
		state.executeUpdate(sql);
		return true;
	}
	//更改购物车纪录
	public boolean setGwcNum(int sid,String uid,int num) throws SQLException{
		state=conn.createStatement();
		sql="select * from sc  where sid = "+sid+" and uid = '"+uid+"'";
		ResultSet rs =state.executeQuery(sql);
		while(rs.next()){
			sql="UPDATE gwc  SET num = "+num+" WHERE sid = "+sid+" AND uid='"+ uid+"'";
		    state.executeUpdate(sql);
		    return true;
		}
		return false;
	}
	//删除一条收藏纪录
	public boolean deletScById(int sid,String uid) throws SQLException{
		state=conn.createStatement();
		sql="select * from sc  where sid = "+sid+" and uid = '"+uid+"'";
		ResultSet rs =state.executeQuery(sql);
		while(rs.next()){
			sql="delete  from sc where sid ="+sid+" and uid = '"+uid+"'";
			state.execute(sql);
			return true;
		}  
	
		return false;
	}
	//删除一条购物车纪录
	public boolean deletGwcById(int sid,String uid) throws SQLException{
		state=conn.createStatement();
		sql="select * from sc  where sid = "+sid+" and uid = '"+uid+"'";
		ResultSet rs =state.executeQuery(sql);
		while(rs.next()){
		    return false;
		}  
		sql="delete  from gwc where sid ="+sid+" and uid = '"+uid+"'";
		state.executeUpdate(sql);
		return true;
	}
	//检查商品是否已收藏
	public boolean checkScById(int sid,String uid) throws SQLException{
		state=conn.createStatement();
		sql="select * from sc  where sid = "+sid+" and uid = '"+uid+"'";
		ResultSet rs =state.executeQuery(sql);
		while(rs.next()){
		    return true;
		}  
		return false;
	}
}

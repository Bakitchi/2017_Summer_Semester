<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException" %>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.sql.Connection"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delete.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%! private static String user="zyh";
	    private static String pass="qsdb";
	    private static String url="jdbc:mysql://192.168.0.19:3306/mall";
	    private static String driver="com.mysql.jdbc.Driver";
	 %>
    <%
    String s=null;
    request.setCharacterEncoding("utf-8");
    s=request.getParameter("id1");
    Object ss = session.getAttribute("username");
    String name=ss.toString();
    Class.forName(driver);
	Connection conn = null;
	Statement sql;
	conn = DriverManager.getConnection(url, user, pass);	
	sql=conn.createStatement();
	sql.executeUpdate("delete from sc where sid ='"+s+"'and uid ='"+name+"'");
	response.sendRedirect("Profile.jsp");
     %>
     
     删除成功
  </body>
</html>

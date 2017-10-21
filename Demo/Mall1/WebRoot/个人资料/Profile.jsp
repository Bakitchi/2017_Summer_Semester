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
<%@page import="dao.*" %>
<%@page import="bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>轻食|我的轻食</title>
<!-- load stylesheets -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
<link rel="stylesheet" href="css/bootstrap.min.css">                                      <!-- Bootstrap style -->
<link rel="stylesheet" href="css/magnific-popup.css">                                <!-- Magnific pop up style, http://dimsemenov.com/plugins/magnific-popup/ -->
<link rel="stylesheet" href="css/templatemo-style.css">                                   <!-- Templatemo style -->
<link rel="stylesheet" href="css/button.css">                                   <!-- button style -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- <script type="text/javascript" src="./js/Profile.js"> -->
<link rel="stylesheet" href="css/button.css">
<link rel="stylesheet" href="css/myCart.css">
<script type="text/javascript" src="./js/myCart.js"></script>
</head>
<body> 
<%! private static String user="zyh";
	    private static String pass="qsdb";
	    private static String url="jdbc:mysql://192.168.0.19:3306/mall";
	    private static String driver="com.mysql.jdbc.Driver";
	 %>
	 <%
	 Object obj = session.getAttribute("username");
 	String uname=obj.toString();     
	 DaoSql daosql3=new DaoSql(); 
	User users=daosql3.getUser1(uname);

	
	%>
	     
<div class="container">
	<div class="row">
		<div class="tm-left-right-container">
			<!-- Left column: logo and menu -->
			<div class="tm-blue-bg tm-left-column">                        
				
				<nav class="tm-main-nav">
					<ul class="tm-main-nav-ul">
						<li class="tm-nav-item">
								<div class="tm-logo-div text-xs-center" onclick="window.location='../index.jsp'">
									<img src="img/9-zonelogo.png" alt="Logo">
								</div>
						</li>
						<li class="tm-nav-item">
							<a href="#welcome" class="tm-nav-item-link" >个人资料</a>
						</li>
						<li class="tm-nav-item">
							<a href="#galleryone" class="tm-nav-item-link">我的收藏</a>
						</li>
						<li class="tm-nav-item">
							<a href="#secondgallery" class="tm-nav-item-link">购物车</a>
						</li>
						<li class="tm-nav-item">
							<a href="#thirdgallery" class="tm-nav-item-link">我的订单</a>
						</li>
					</ul>
				</nav>                                         
			</div> <!-- Left column: logo and menu -->
			<!-- Right column: content -->
			<div class="tm-right-column">

				<div class="tm-content-div">
					<!-- Profile section -->
					<div>
					<section id="welcome" class="tm-section">
						<header>
						
							<h2 class="tm-blue-text tm-welcome-title"><%=uname %>的个人资料</h2>
							<hr/>
						</header>
						<form action="Update.jsp" method="post" class="contact-form" onsubmit="return phone_tip()">
							<div class="form-group">
							
								</br>
								
							</div>
							<div class="form-group hint">
								<h4 class="float-right">电话号码<h4/>
								<input type="text" id="contact_email" name="contact_email" class="form-control" value="<%=users.getPhone() %>"  required/>
							</div>
							<div class="form-group hint">
								<h4 class="float-right">个性签名<h4/>
								<textarea id="contact_message" name="contact_message" class="form-control" rows="9"><%=users.getText() %></textarea>
							</div>

							<button type="submit" class="float-right tm-button" >保存</button>
							<script type="text/javascript">
							function phone_tip(){
								var phone=document.getElementById("contact_email").value;
								if(phone=="")
								{
									alert("手机号码不能为空！");
									return false;
								}else if(!/^1[3|4|5|7|8][0-9]{9}$/.test(phone)) 
								{  
									alert("手机号码格式不正确！");
									return false;  
								}else{
								alert("资料更改成功！")
								return true;}
	
							}
							</script>
						</form>
					
							
								<hr/>
								                                                
							
						
					</section>
		

					<!-- Gallery One section -->     
					<section id="galleryone" class="tm-section">
						<header><h2 class="tm-blue-text tm-welcome-title" >我的收藏</h2><hr/></header>
						
						<div class="search" style="width: 600px;">
        					<div class="search d7">
								<form>
		  							<input type="text" placeholder="搜索我的收藏...">
		  							<button type="submit"></button>
		  							<!-- <div class="button_base b06_3d_swap add btn-div-2">
       								 	<div class="">搜索</div>
        								<div class="">搜索</div>
   									</div> -->
								</form>
							</div>
        				</div>

						<div class="tm-gallery-container tm-gallery-1" ">
						<%		
    							ArrayList<Stuff> list =daosql3.getStuffsSC(uname);
    			
    							for(int i=0;i<list.size();i++)
    							{
    							
  								%>
   								
							<div class="tm-img-container tm-img-container-1">
								<a href="<%=list.get(i).getSphoto() %>"><img src="<%=list.get(i).getSphoto() %>" alt="Image" class="img-fluid tm-img-tn"></a>
								<p style="padding-right: 70%;color: red; font-weight: 800;font-family: 'Open Sans';">￥<%=list.get(i).getPrice() %></p>
								<p style="text-align:left; line-height: 80%;width: 220px;"><a href="" class="dcname"><font color="#000000" style="text-decoration: none;font-size: 1rem;" id="+i+"><%=list.get(i).getSname() %></font></a></p>
								<div class="button_base b06_3d_swap-cancel " onclick="quxiaoshoucang('<%=list.get(i).getSid() %>')" >
       								 <div class="btn-div">取消收藏</div>
        							<div class="btn-div">取消收藏</div>
   								</div> 
   							</div>
								<%
								} 
						%>									                                    
						</div>
						<script type="text/javascript">
						function quxiaoshoucang(obj){
						var ob=obj;
						if(confirm("确定删除该项收藏吗？"))
  						{
   						window.location.href="http://localhost:8080/Mall/个人资料/delete.jsp?id1="+ob;
 						 }
						
						}
						
						
						
						
						</script>
					</section>
						
					<!-- Second Gallery section -->     
					<section id="secondgallery" class="tm-section">
						<header ><h2 class="tm-blue-text tm-welcome-title">购物车</h2><hr/></header>
						<div id="content">
						<div class="search" style="width: 600px;">
        					<div class="search d7">
								<form>
		  							<input type="text" placeholder="搜索购物车...">
		  							<button type="submit"></button>
		  							<!-- <div class="button_base b06_3d_swap add btn-div-2">
       								 	<div class="">搜索</div>
        								<div class="">搜索</div>
   									</div> -->
								</form>
							</div>
        				</div>
 							<table width="100%" border="0" cellspacing="0" cellpadding="0" id="shopping">
 								<form action="" method="post" name="myform">
								  <tr>
								    <td class="title_1"><input id="allCheckBox" type="checkbox" value="" onclick="selectAll()" />全选</td>
								    <td class="title_2" colspan="2">商品</td>
								    <td class="title_3">单价（元）</td>
								    <td class="title_4">数量</td>
								    <td class="title_5">小计（元）</td>
								    
								  </tr>
								  <tr>
								    <td colspan="8" class="line"></td>
								  </tr>
								  
								  <%
    								ArrayList<Stuff> list1 =daosql3.getStuffsGWC(uname);
    			
    							for(int i=0;i<list1.size();i++)
    							{
    							
  								%><tr id="product"+"<%=list1.get(i).getSid() %>">
								    <td class="cart_td_1"><input name="cartCheckBox" type="checkbox" value="<%=list1.get(i).getSid() %>" onclick="selectSingle()" /></td>
								    <td class="cart_td_2"><img src="<%=list1.get(i).getSphoto() %>" alt="shopping"/></td>
								    <td class="cart_td_3"><a href="#"><%=list1.get(i).getSname() %></a><br/></td>
								    <td class="cart_td_5"><%=list1.get(i).getPrice() %></td>
								    <td class="cart_td_6"><img src="img/taobao_minus.jpg" alt="minus" onclick="changeNum('<%=list1.get(i).getSid() %>','minus')" class="hand"/> <input id="<%=list1.get(i).getSid() %>" type="text"  value="<%=list1.get(i).getNum() %>" class="num_input" readonly="readonly"/> <img src="img/taobao_adding.jpg" alt="add" onclick="changeNum('<%=list1.get(i).getSid() %>','add')"  class="hand"/></td>
								    <td class="cart_td_7"></td>
								    
								    
								  </tr><%
								  }
								  
								   %>
								  
								  
								  
								  
								   
  
								   <tr>
								   <td  colspan="3">
								  	<div class="button_base b06_3d_swap-cancel" onclick="deletesel()">
       								 	<div class="btn-div">删除所选</div>
        								<div class="btn-div">删除所选</div>
   									</div>
   									</td>
								    <td colspan="5" class="shopend">商品总价（不含运费）：<label id="total" class="yellow"></label> 元<br />
								    <div class="button_base b06_3d_swap-submit" style="float: right;" onclick="adddd()">
       								 	<div class="btn-div">加入订单</div>
        								<div class="btn-div">加入订单</div>
   									</div>
								  </tr>
  								</form>
							</table>
						</div>

							
					</section>

					<!-- Third Gallery section -->     
					<section id="thirdgallery" class="tm-section">
						<header><h2 class="tm-blue-text tm-welcome-title tm-margin-b-30">我的订单</h2><hr/></header>
							<table width="100%" border="0" cellspacing="0" cellpadding="0" id="dd1" >
 								<form action="" method="post" name="myform">
								  <tr>
								    

								    <td class="title_2" colspan="2">商品</td>
								    <td class="title_3">单价（元）</td>
								    <td class="title_4">数量</td>
								    <td class="title_5">小计（元）</td>
								  	<td class="title_2">订单编号</td>
								    
								  </tr>
								  <tr>
								    <td colspan="8" class="line"></td>
								  </tr>
								  
								  
								  <%
    								ArrayList<Stuff> list2 =daosql3.getStuffsDD(uname);
    			
    							for(int i=0;i<list2.size();i++)
    							{
    							%> <tr>
								    
								    <td class="cart_td_2"><img src="<%=list2.get(i).getSphoto() %>" alt="shopping"/></td>								    
								    <td class="cart_td_3"><a href="#"><%=list2.get(i).getSname() %></a><br/></td>
								    <td class="cart_td_5"><%=list2.get(i).getPrice() %></td>
								    <td class="cart_td_6"><%=list2.get(i).getNum() %></td>
								    <td class="cart_td_7"><%=list2.get(i).getPrice()*list2.get(i).getNum() %></td>
								    <td class="cart_td_2"><a href="#"><%=list2.get(i).getDid() %></a><br/></td>
								    <td class="cart_td_8"><a href="javascript:deleteRow('product1');"></a></td>
								    
								  </tr><%
								  }
								   %>
								  
								  
								  
								  
								  
								  
								  
								   
								 
  
								   <tr>
								   <td  colspan="3">
   									</td>
								    <td colspan="5" class="shopend"><br />
								    
								  </tr>
  								</form>
							</table>
					</section>
					</div>
					<footer>
						<p class="tm-copyright-p">Copyright &copy; 2017.轻食 All rights reserved.</p>
					</footer>
				</div>  
				
			</div> <!-- Right column: content -->
		</div>
	</div> <!-- row -->
</div> <!-- container -->
		
<!-- load JS files -->
<script src="js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
<script src="js/jquery.magnific-popup.min.js"></script>     <!-- Magnific pop-up (http://dimsemenov.com/plugins/magnific-popup/) -->
<script src="js/jquery.singlePageNav.min.js"></script>      <!-- Single Page Nav (https://github.com/ChrisWojcik/single-page-nav) -->
<script>     

	$(document).ready(function(){

		// Single page nav
		$('.tm-main-nav').singlePageNav({
			'currentClass' : "active",
			offset : 20
		});

		// Magnific pop up
		$('.tm-gallery-1').magnificPopup({
		  delegate: 'a', // child items selector, by clicking on it popup will open
		  type: 'image',
		  gallery: {enabled:true}
		  // other options
		}); 

		$('.tm-gallery-2').magnificPopup({
		  delegate: 'a', // child items selector, by clicking on it popup will open
		  type: 'image',
		  gallery: {enabled:true}
		  // other options
		}); 

		$('.tm-gallery-3').magnificPopup({
		  delegate: 'a', // child items selector, by clicking on it popup will open
		  type: 'image',
		  gallery: {enabled:true}
		  // other options
		}); 

		$('.tm-current-year').text(new Date().getFullYear());  

		$('.add-container .show-add').click(function() {
					$(this).css('background', 'url("img/mail_1.jpg") no-repeat').siblings('.show-add').css('background', 'url("img/mail.jpg") no-repeat')
		})             
	});
</script>
<%daosql3.Close();  %>            
</body>
</html>


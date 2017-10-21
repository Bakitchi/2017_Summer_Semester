<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/shangping.css">
    <link rel="stylesheet" type="text/css" href="zjl/css/smohan.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/common.js"></script>
	<script type="text/javascript">
	  $(document).ready(function(){
		  var showproduct = {
			  "boxid":"showbox",
			  "sumid":"showsum",
			  "boxw":450,//宽度,该版本中请把宽高填写成一样
			  "boxh":450,//高度,该版本中请把宽高填写成一样
			  "sumw":90,//列表每个宽度,该版本中请把宽高填写成一样
			  "sumh":90,//列表每个高度,该版本中请把宽高填写成一样
			  "sumi":30,//列表间隔
			  "sums":4,//列表显示个数
			  "sumsel":"sel",
			  "sumborder":1,//列表边框，没有边框填写0，边框在css中修改
			  "lastid":"showlast",
			  "nextid":"shownext"
			  };//参数定义	  
		 $.ljsGlasses.pcGlasses(showproduct);//方法调用，务必在加载完后执行
	  });	
			
			
	</script>
	
  </head>
  
  <body>
  <div>
  <div class="topbar">
    		<div class="wraper">
        		<a href="" class="logo"><img src="src/9-zonelogo.png" width="140px" height="140px" border="0"></a>
        		<div class="nav">
            		<ul class="parent">
               		 	<li ><a href="" class="items">首页</a><span class="lines"></span></li>
                		<li><a href="" class="items">所有商品</a><span class="lines"></span></li>
                		<li><a href="" class="items">商品分类</a><span class="lines"><ul class="hid"> 
								<li><a href="#" >按口味</a></li>
								<li><a href="#" >按种类</a></li>							
							</ul>
                		</span></li>
                		<li><a href="" class="items">关于轻食</a><span class="lines"></span></li>
               
            		</ul>
        		</div>
        		<div class="search">
        			<div class="search d7">
						<form>
		  					<input type="text" placeholder="搜索商品...">
		  					<button type="submit"></button>
						</form>
					</div>
        		</div>
        		<div class="login">
        			<a href="" class="alogin">注册</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
        			<a href="" class="alogin">登录</a>
        		</div>
        
    		</div>
		</div>
  </div>
  <div class="wrap" >
  
  <div class="leftcontain">
  
  <div class="left">
  <div class="picbig" id="showbox">
  <img src="src/picshow1.jpg" width="450" height="450" />
  <img src="src/picshow2.jpg" width="450" height="450" />
  <img src="src/picshow3.jpg" width="450" height="450" />
  <img src="src/picshow4.jpg" width="450" height="450" />
  </div>
  <div class="picsmallcontain" id="showsum">   
  </div>
  <div  style="margin-top:30px;"><img src="src/leftbottom.png"></div>
  </div>
  <div class="mid">
  
  	<div class="title">乐纯滤乳清元气希腊酸奶6盒装 益生发酵菌酸牛奶冷链包邮</div>
  	<div class="btitle">工厂新鲜直销&nbsp;全程冷链物流 </div> 
  	<div class="informblock" >
  	<div class="informbar">	<div class="pricetext">价格：</div><div class="price">￥69.00</div></div>
  	<div class="informbar"><div class="youhui">优惠：</div>满399减50，满699减120，满999减200 </div>
  	<div class="informbarfix"><div class="kefutext">联系客服：</div><div class="kefu"><a><img style="cursor: pointer;" src="src/kefu.png"> </a></div></div>
   </div>
   <form action=""style="float:left;">
  <div class="formblock">
  <div class="formbar"><div class="text" id="textfix1">购买数量：<span class="numdecrease"><b>-</b></span><input type="text" class="num" value="1"><span class="numincrease"><b>+</b></span></div></div>
  <div class="formbar">
  <div class="text">选择地址：</div>
  <select name="adress" ><option value="0">xxxxxxxxxxxxx</option><option value="0">***********</option></select>
  <div class="text"> 运费：</div>￥10.00
  </div>
  <div class="formbar">
  <div class="button" id="buy">&nbsp;&nbsp;&nbsp;现在购买&nbsp;&nbsp;&nbsp;</div>
  <div class="button" id="prebuy">&nbsp;加入购物车&nbsp;</div>
  <div class="button" id="collect">&nbsp;&nbsp;&nbsp;收藏商品&nbsp;&nbsp;&nbsp;</div>
  </div>
  </div>
  </form>
  <div class="bottom">
  <div class="informbar"><div class="text" id="smalltext1">服务承诺:</div><img alt="" src="src/bottom1.png"></div>

  <div class="informbar"><div class="text" id="smalltext2">支付方式:</div><img alt="" src="src/bottom2.png"></div>
  </div>
  </div>
  </div>
  
  <div class="rightcontain">
  <div class="text" id="righttitle">-----------&nbsp;&nbsp;&nbsp;猜你喜欢&nbsp;&nbsp;&nbsp;-------------</div>
  <div style="margin-top: 60px">
  <div class="picright"><img class="fillparent"  src="src/picright1.jpg"><a href="" class="righttext">乐纯滤乳清元气希腊抹茶榴莲网</a></div>
  <div class="picright"><img class="fillparent"  src="src/picright2.jpg"><a href="" class="righttext">乐纯滤乳清元气希腊抹茶榴莲网</a></div>
  <div class="picright"><img class="fillparent"  src="src/picright3.jpg"><a href="" class="righttext">乐纯滤乳清元气希腊抹茶榴莲网</a></div>
  <div class="picright"><img class="fillparent"  src="src/picright4.jpg"><a href="" class="righttext">乐纯滤乳清元气希腊抹茶榴莲网</a></div>
  </div>
  </div>
  </div>
  <div class="detailwrap">
  <div class="detail">
  <img src="src/detail1.jpg">
  <img src="src/detail2.jpg">
  <img src="src/detail3.jpg">
  <img src="src/detail4.jpg">
  </div>  
  </div>
  <div style="height: 300px;width: 100%;background: #303030;margin-top: 100px;margin-left: 0;text-align: center;">
    	<div style="height: 300px;width:1000px;margin:0 auto;text-align: center;">
    		<div style="height: 300px;width: 270px;float: left;text-align: left;">
    			<br />
    			<h3 style="color: white;">联系方式</h3>
    			<p style="font-size: 9px;color: #EEE5DE;">+QQ 673716884</p>

                <p style="font-size: 9px;color: #EEE5DE;">673716884@qq.com</p>

                <p style="font-size: 9px;color: #EEE5DE;">陕西省西安市西安交通大学软件学院</p>
    		</div>
    		<div style="height: 300px;width: 200px;float: left;text-align: left;">
    			<br />
    			<h3 style="color: white;">合作</h3>
    			<a href="" style="font-size: 9px;color: #EEE5DE;text-decoration: none;">关于我们</a>
    		</div>
    		<div style="height: 300px;width: 200px;float: left;text-align: left;">
    			<br />
    			<h3 style="color: white;">帮助</h3>
    			<p style="font-size: 9px;color: #EEE5DE;">其实也没啥可帮助的</p>
    		</div>
    		<div style="height: 300px;width: 200px;float: right;text-align: left;">
    			<br />
    			<h2 style="color: white;">关注我们</h2>
    			<div style="height: 100px;width:100px;background: url(src/weixin.jpg);margin-top: 50px;"></div>
    		</div>
    	</div>
    </div>
  
  </body>
</html>

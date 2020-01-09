<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<link href="login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="ccps_11_lanseshuziOA/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<div class="login_box">
      <div class="login_l_img"><img src="images/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
          <div class="login_name">
               <p>在线考试系统</p>
          </div>
          <form method="post" action="RegsterServlet" id="Register">
              <input class="username" name="username" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
              <span class="usernametips"></span>
              <script type="text/javascript">
              	$(function(){
              		$(".username").blur(function(){
              			var name=$(".username").val();
              			$.ajax({
              					type:"post",
              					url:"HaveUserNameServlet",		
              					data:{"username":name},
              					async:true,
              					success:function(data){
              						var flag=data.haveUser;
                      				//回调函数
                      				if(flag){
                      					$(".usernametips").html("用户名已存在");	
                      				}else{
                      					$(".usernametips").html("");
                      				}
                      					
                      			},
                      			dataType:"json"         			
              			});
              			
              		});
              	})
              </script>
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
			  <input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
              <input value="注册" style="width:100%;" type="submit">
          </form>
          <div class="already">
               <p><a href="Login.jsp">已注册</a></p>
          </div>
      </div>
</div>
</body>
</html>
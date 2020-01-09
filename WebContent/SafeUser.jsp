<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改个人信息</title>
<link rel=stylesheet type=text/css href="./lib/movie.css">
</head>


<body bgcolor="#F4FFFE">
<% User u=(User)session.getAttribute("user");
%>

<div align="center"><br>
<h3>修改个人账户</h3>
<form name="loginForm" method="post" action="SafeUserServlet">

<table width="40%" border="0">



<tr>
<td width="50%" align="right" height="25">请输入新密码：</td>
<td width="50%" align="left" height="25"><input name="Password1" type="password" size="20" ><font color="#ff0000"></font></td>
</tr>
<tr>
<td width="50%" align="right" height="25">请确认密码：</td>
<td width="50%" align="left" height="25"><input name="Password2" type="password" size="20" ></td>
</tr>
<input type="hidden" name="id" value="<%=u.getId()%>">


<tr>

<td width="100" height="50" align="right" > &nbsp;<input type="reset" name="res" value="重填"  ></td>

<td width="20" height="10" align="left"><input type="submit" id="form" class="tdBtn" value="保存" target="_top" onclick="check()"/></td>

</tr>

</table>

</form>
</div>
</body>


</html>
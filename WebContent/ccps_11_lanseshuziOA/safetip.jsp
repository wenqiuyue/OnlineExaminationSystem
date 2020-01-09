<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码成功</title>
<link rel=stylesheet type=text/css href="./lib/movie.css">

</head>
<body bgcolor="#F4FFFE">
<div align="center" ><br>
<h3>修改密码成功！</h3>
<form name="loginForm" method="post" action="../SelectTeacherServlet?t_name=<%=request.getParameter("t_name")%>&&sub_id=<%=request.getParameter("sub_id") %>">
<table width="40%" border="0">
<tr>

<td width="100" height="50" align="center" >
<a href='../Login.jsp' target="_top" onclick="jinru()">重新登录</a>
</td>

</tr>
</table>

</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试提示</title>
<link rel=stylesheet type=text/css href="./lib/movie.css">

</head>
<body bgcolor="#F4FFFE">
<div align="center" ><br>
<h3>您要进入考试吗？</h3>
<form name="loginForm" method="post" action="../SelectTeacherServlet?t_name=<%=request.getParameter("t_name")%>&&sub_id=<%=request.getParameter("sub_id") %>">
<table width="40%" border="0">
<tr>

<td width="100" height="50" align="center" ><input type="submit" name="res" value="进入"  ></td>

</tr>
</table>

</form>
</div>
</body>
</html>
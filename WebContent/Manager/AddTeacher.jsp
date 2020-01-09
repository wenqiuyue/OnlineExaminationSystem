<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教师用户</title>
<link rel=stylesheet type=text/css href="./lib/movie.css">

</head>
<body bgcolor="#F4FFFE">
<% List<Subject> subject=(List<Subject>)session.getAttribute("subjectLists");%>
<div align="center"><br>
<h3>添加教师用户</h3>
<form name="loginForm" method="post" action="../AddTeacherServlet">
<table width="40%" border="0">


<tr>
<td width="40%" align="right" height="25">分配账号：</td>
<td width="40%" align="left" height="25"><input name="zhanghao" type="text" size="20"><font color="#ff0000"></font></td>
</tr>
<tr>
<td width="50%" align="right" height="25">分配密码：</td>
<td width="50%" align="left" height="25"><input name="Password" type="text" size="20" ><font color="#ff0000"></font></td>
</tr>
<tr>
<td width="50%" align="right" height="25">姓名：</td>
<td width="50%" align="left" height="25"><input name="name" type="text" size="20" ><font color="#ff0000"></font></td>
</tr>
<tr>
<td width="50%" align="right" height="25">所在院系：</td>
<td width="50%" align="left" height="25"><input name="yuanxi" type="text" size="20" ><font color="#ff0000"></font></td>
</tr>
<tr>
<td width="50%" align="right" height="25">任教科目：</td>
<td>
  <select name="kemu">
  <% 

if(subject!=null){
for(int i=0;i<subject.size();i++){ 
	Subject s=subject.get(i); 
 %>
   <option value="<%=s.getId() %>"><%=s.getSubject_name() %></option>
 <%}}  %>
  </select>
</td>
</tr>

<tr>

<td width="100" height="50" align="right" > &nbsp;<input type="reset" name="res" value="重填"  ></td>

<td width="20" height="10" align="left"><input type="submit" name="sub" value="添加" ></td>


</tr>
</table>

</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.js"></script>
<script src="../js/public.js"></script>
<title>成绩列表</title>
</head>
<body>
<%
	List<User> uli=(List<User>)session.getAttribute("t_u");
User u=(User)session.getAttribute("user");
%>
<div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>成绩列表</em></span>
  </div>
  <div class="operate"> 
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>编号</th>
    <th>学生</th>
    <th>成绩</th>
   </tr>
   
<!-- 列表根据数据库数据显示 -->
<% 
int index=1;
if(uli!=null){
for(int i=0;i<uli.size();i++){ 
	User q=uli.get(i);
 %>
 <tr>
	<th><%=index++ %></th>
	<th><%=q.getReal_name() %></th>
	<th><%=q.getScore() %></th>
   </tr>
 <%}}%>
 </table>
 </div>
</body>
</script>
</html>
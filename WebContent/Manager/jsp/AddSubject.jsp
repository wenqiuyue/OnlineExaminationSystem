 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.js"></script>
<script src="../js/public.js"></script>
<title>GoodsManager</title>
</head>
<body>
<%
	List<User> sub=(List<User>)session.getAttribute("addsubjectList");
    User us=(User)session.getAttribute("user");
%>
<div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>科目列表</em></span>
    
  </div>
  <div class="operate"> 
  	
    <tr>

    <input type="button"  value="刷新" class="tdBtn" onclick="shuaxin()"/>
    </tr>
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>编号</th>
    <th>科目名称</th>
    <th>开课学院</th>
    <th>任课教师</th>
    <th>操作</th>
   </tr>
   
<!-- 列表根据数据库数据显示 -->
<% 
int index=1;
if(sub!=null){
for(int i=0;i<sub.size();i++){ 
   User u=sub.get(i);
 %>
 <tr>
	<th><%=index++ %></th>
	<th><%=u.getSubject_name() %></th>
	<th><%=u.getSubject_xueyuan() %></th>
	<th><%=u.getReal_name() %></th>
	

	<!--操作  -->	
    <th class="center">
     <a href="../../AddSubjectStudentServlet?user_id=<%=us.getId() %>&&subject_name=<%=u.getSubject_name() %>&&subject_xueyuan=<%=u.getSubject_xueyuan() %>&&teacher_name=<%=u.getReal_name() %>" >+加入我的课程</a>
    </th>
   </tr>
 <%}} %>
 </table>
 </div>
</body>



<script type="text/javascript">
function serch(){	
	var key=document.getElementById("key").value;	
	window.location.href = '../FindGoodsServlet?key='+key;	
}
function empty(){
	document.getElementById("key").value="";	
}
function shuaxin(){	
	window.location.href = '../../AddSubjectLieBiaoServlet';	
}
</script>
</html>
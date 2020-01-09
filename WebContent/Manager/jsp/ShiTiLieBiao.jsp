<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.js"></script>
<script src="../js/public.js"></script>
<title>试题列表</title>
</head>
<body>
<%
	List<Question> question=(List<Question>)session.getAttribute("questionList");
User u=(User)session.getAttribute("user");
%>
<div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>试题列表</em></span>
  </div>
  <div class="operate"> 
    <tr>
    <input type="button" value="生成试卷" class="tdBtn" onclick="make()"/>
    <input type="button" value="查看试卷" class="tdBtn" onclick="see()"/>
    <input type="button"  value="刷新" class="tdBtn" onclick="shuaxin()"/>
    </tr>
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>编号</th>
    <th>试题</th>
    <th>题型</th>
    <th>答案</th>
    <th>分值</th>
    <th>操作</th>
   </tr>
   
<!-- 列表根据数据库数据显示 -->
<% 
int index=1;
if(question!=null){
for(int i=0;i<question.size();i++){ 
	Question q=question.get(i); 
 %>
 <tr>
	<th><%=index++ %></th>
	<th><% String str1=q.getQuestion();     /* 判断多余字符用省略号显示 */
			String s1="";
			if(str1.length()>10){
				s1=str1.substring(0,10)+"...";}
				else{
					s1=str1;}%>
	<%=s1 %></th>
	<th><%=q.getTixing() %></th>
	<th><%=q.getAnswer() %></th>
	<th><%=q.getScore() %></th>

	<!--操作  -->	
    <th class="center">
    <!--编辑信息  -->
     	<a href="../../UpdateQuestionChangeServlet?Id=<%=q.getId() %>" title="编辑信息" >
     	<img src="../images/icon_edit.gif"/></a>
     <!--删除  -->	
     	<a href="../../DeleteQuestionServlet?Id=<%=q.getId() %>" title="删除">
     	<img src="../images/icon_drop.gif"/></a>
    </th>
   </tr>
 <%}}%>
 </table>
 </div>
</body>



<script type="text/javascript">
function make(){	
	window.location.href = '../../MakeShiJuanServlet?userid=<%=u.getId()%>';	
}
function see(){	
	window.location.href = '../../SeeShiJuanServlet?userid=<%=u.getId()%>';	
}
function shuaxin(){	
	window.location.href = '../../AllQuestionServlet?userid=<%=u.getId()%>';	
}
</script>
</html>
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
	List<Subject> sub=(List<Subject>)session.getAttribute("subjectList1");
    //Subject sub=(Subject)session.getAttribute("subject");
%>
<div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>科目列表</em></span>
    <span class="modular fr"><a href="../../ccps_11_lanseshuziOA/AddSubjectForm.jsp" class="pt-link-btn">+添加科目</a></span>
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
    <th>操作</th>
   </tr>
   
<!-- 列表根据数据库数据显示 -->
<% 
int index=1;
if(sub!=null){
for(int i=0;i<sub.size();i++){ 
 Subject s=sub.get(i); 
 %>
 <tr>
	<th><%=index++ %></th>
	<th><%=s.getSubject_name() %></th>
	<th><%=s.getSubject_xueyuan() %></th>

	<!--操作  -->	
    <th class="center">
    <!--编辑信息  -->
     	<a title="编辑信息" target="mainCont">
     	<img src="../images/icon_edit.gif"/></a>
     <!--删除  -->	
     	<a href="../../DeleteSubjectServlet?id=<%=s.getId() %>" title="删除">
     	<img src="../images/icon_drop.gif"/></a>
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
	window.location.href = '../../SubjectLieBiao';	
}
</script>
</html>
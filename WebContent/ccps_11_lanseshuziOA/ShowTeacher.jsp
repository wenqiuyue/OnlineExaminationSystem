<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息表</title>
	<style>

body{
	margin:0;
	padding:0;
}

td{
	width:160px;
	height:30px;
	font-size:20px;
}	
		 .buttonc {
    text-align: center;
    padding-top: 10px;
    padding-bottom: 15px;
}
input.button, a.button {
    background: url("../image/module_button_bg.jpg") repeat-x scroll left top;
    height: 20px;
    overflow: visible;
    padding: 0 10px;
    border: 1px solid #CCC;
    line-height: 20px !important;
    color: #333;
    letter-spacing: 2px;
    font-size: 12px;
    cursor: pointer;
    *line-height: 18px !important: ;
    display: -moz-inline-stack;
    display: inline-block;
    *display:inline: ;
    *zoom:1: ;
}
	</style>

</head>
<body>
<% User u=(User)session.getAttribute("user");
   User t=(User)session.getAttribute("teacherinfo");
%>
	<table border=1; cellpadding=12; cellspacing=0; align=center>

		<tr align=center>
			<td colspan="5">基本信息</td>
		</tr>
		
		<form method="get" action="../SearchTeacherServlet">
		<tr align=center>
			<td  style="background-color:#ededed">用户名</td><td>
			<input type="text"  style="background:none;border:0;" disabled="disabled" name="username" id="textfield" value="<%=t.getUsername()%>" ></td>
			<td  style="background-color:#ededed">真实姓名</td><td>
			<input type="text" style="background:none;border:0;" disabled="disabled" name="real_name" id="textfield" value="<%=t.getReal_name()%>"></td>
		</tr>
		<tr align=center>
			<td  style="background-color:#ededed">Mail:</td><td>
			<input type="text" style="background:none;border:0;" disabled="disabled" name="mail" id="textfield" value="<%=t.getMail()%>"></td>
			<td  style="background-color:#ededed">院系:</td><td>
			<input type="text" style="background:none;border:0;" disabled="disabled" name="yuan_xi" id="textfield" value="<%=t.getYuan_xi()%>"></td>
		</tr>
		<tr align=center>
			<td  style="background-color:#ededed">性别:</td><td>
			<input type="text" style="background:none;border:0;" disabled="disabled" name="sex" id="textfield" value="<%=t.getSex()%>"></td>
			<td style="background-color:#ededed">电话:</td><td>
			<input type="text" style="background:none;border:0;" disabled="disabled" name="zhuan_ye" id="textfield" value="<%=t.getPhone()%>"></td>
		</tr>
		<input type="hidden" name="id" value="<%=u.getId()%>">

	</table>
    
<div class="buttonc">
            <input class="button" onclick="location.href='TeacherTable.jsp?from=welcomepage&amp;SID=47349'" type="button" value="修改">
            
            
        </div>

</form>
</body>
</html>
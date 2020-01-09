<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<Question> xz_question=(List<Question>)session.getAttribute("xz_shijuan_list");
	List<Question> pd_question=(List<Question>)session.getAttribute("pd_shijuan_list");
	List<Question> jd_question=(List<Question>)session.getAttribute("jd_shijuan_list");
	int index=1;
%>
<form id="form1" name="form1" action="ShiTiLieBiao.jsp"">
 <div> 
    <p>一、选择顾(本大题有7个小题，每小题5分，共35分小题给出的四个选项中，只有一项是符合题目要求的) </p>
  </div>
<!-- 列表根据数据库数据显示 -->
<% 

if(xz_question!=null){
for(int i=0;i<xz_question.size();i++){ 
	Question q=xz_question.get(i); 
 %>
  <table width="300" border="1">
    <tr>
      <th scope="col" height="100"><label for="textarea"></label>
      <textarea name="textarea" id="textarea" cols="100" rows="10" disabled="disabled"><%=index+++"、"+q.getQuestion()%></textarea></th>
    </tr>
    <tr>
      <td height="50">答案
        <label for="textfield"></label>
      <input type="text" style="background:none;border:0;" disabled="disabled" name="textfield" id="textfield" value="<%=q.getAnswer()%>"/></td>
    </tr>
  </table>
   <%}}%>
   <div> 
    <p>二、判断题(本大题有7个小题，每小题5分，共35分正确答案T,错误答案F) </p>
  </div>
<!-- 列表根据数据库数据显示 -->
<% 

if(pd_question!=null){
for(int i=0;i<pd_question.size();i++){ 
	Question q=pd_question.get(i); 
 %>
  <table width="300" border="1">
    <tr>
      <th scope="col" height="100"><label for="textarea"></label>
      <textarea name="textarea" id="textarea" cols="100" rows="10" disabled="disabled"><%=index+++"、"+q.getQuestion()%></textarea></th>
    </tr>
    <tr>
      <td height="50">答案
        <label for="textfield"></label>
      <input type="text" style="background:none;border:0;" disabled="disabled" name="textfield" id="textfield" value="<%=q.getAnswer()%>"/></td>
    </tr>
  </table>
   <%}}%>
   <div> 
    <p>三、填空题(本大题有3个小题，每小题10分，共30分</p>
  </div>
<!-- 列表根据数据库数据显示 -->
<% 

if(jd_question!=null){
for(int i=0;i<jd_question.size();i++){ 
	Question q=jd_question.get(i); 
 %>
  <table width="300" border="1">
    <tr>
      <th scope="col" height="100"><label for="textarea"></label>
      <textarea name="textarea" id="textarea" cols="100" rows="10" disabled="disabled"><%=index+++"、"+q.getQuestion()%></textarea></th>
    </tr>
    <tr>
      <td height="50">答案
        <label for="textfield"></label>
      <input type="text" style="background:none;border:0;" disabled="disabled" name="textfield" id="textfield" value="<%=q.getAnswer()%>"/></td>
    </tr>
  </table>
   <%}}%>
  <p>
    <input type="submit" name="button" id="button"  value="返回" />
  </p>
</form>

 </table>
 </div>
</body>
</html>
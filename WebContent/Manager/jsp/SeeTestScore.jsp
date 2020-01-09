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
	String [] xz_array=(String [])session.getAttribute("xz_array");
	String [] pd_array=(String [])session.getAttribute("pd_array");
	String [] jd_array=(String [])session.getAttribute("jd_array");
	User u=(User)session.getAttribute("user");
	User t_id=(User)session.getAttribute("u");
	Score score=(Score)session.getAttribute("score");
	int index=1;
	int xz_dex=0;
	int pd_dex=0;
	int jd_dex=0;
%>
<form id="form1" name="form1" method="post" action="../../ScoreServlet">
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
      <input type="text" style="background:none;border:0;" disabled="disabled" name="xz_answer" id="textfield" value=<%=q.getAnswer() %> >
      您的答案
      <label for="textfield"></label>
      <input type="text" style="background:none;border:0;" disabled="disabled" name="jd_answer" id="textfield" value=<%=xz_array[xz_dex++] %>>
      </td>
      <input type="hidden" name="T_xz_answer" value=<%=q.getAnswer() %>>
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
      <input type="text" style="background:none;border:0;" disabled="disabled" name="pd_answer" id="textfield" value=<%=q.getAnswer() %>>
      您的答案
      <label for="textfield"></label>
      <input type="text" style="background:none;border:0;" disabled="disabled" name="jd_answer" id="textfield" value=<%=pd_array[pd_dex++] %>></td>
     <input type="hidden" name="T_pd_answer" value=<%=q.getAnswer() %>>
     
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
      <input type="text" style="background:none;border:0;" disabled="disabled" name="jd_answer" id="textfield" value=<%=q.getAnswer() %>>
      您的答案
      <label for="textfield"></label>
      <input type="text" style="background:none;border:0;" disabled="disabled" name="jd_answer" id="textfield" value=<%=jd_array[jd_dex++] %>>
      </td>
      
     <input type="hidden" name="T_jd_answer" value=<%=q.getAnswer() %>>
    </tr>
  </table>
   <%}}%>
  <input type="hidden" name="userid" value=<%=u.getId() %>>
  <input type="hidden" name="t_id" value=<%=t_id.getId() %>>
  
 <tr>
      <td height="50">总分
        <label for="textfield"></label>
      <input type="text" style="background:none;border:0;" name="jd_answer" id="textfield" value="<%=score.getAscore()%>"></td>
</form>

 </table>
 </div>
</body>
</html>
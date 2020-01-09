<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/form.css" />
<link href="umeditor/themes/default/_css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
window.UMEDITOR_HOME_URL = 'umeditor/';  // 请换成绝对路径
</script>
<script type="text/javascript" src="js/umeditor.config.js"></script>
<script type="text/javascript" src="js/editor_api.js"></script>
<script type="text/javascript" src="umeditor/lang/zh-cn/zh-cn.js"></script>
<title>添加试题</title>
</head>
<body>
<% User u=(User)session.getAttribute("user");%>
<form method="post" action="../AddQuestionsServlet" >
<div id="container">
	<div id="hd">
    </div>
    <div id="bd">
    	<div id="main">  
    	<div class="subfild-content base-info">
    
            <h2 class="subfild">
            	<span>添加试题</span>
            </h2>
            <div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>正确答案</label>
                	<div class="kv-item-content">
                    	<input type="text" name="answer" placeholder="正确答案" />
                    </div>
                </div>
                <div class="kv-item ue-clear time">
                	<label><span class="impInfo">*</span>分值</label>
                	<div class="kv-item-content">
                    	<input type="text" name="score" placeholder="分值" />
                       
                    </div>
                </div>
               <div class="kv-item ue-clear time">
                	<label><span class="impInfo">*</span>题型</label>
                	<div class="kv-item-content">
                    	<select name="tixing">

							<option>-请选择题型-</option>
							
							<option value="选择题">选择题</option>		
							<option value="判断题">判断题</option>
							<option value="填空题">填空题</option>
					</select>               
                    </div>
                </div>
            <div class="subfild-content remarkes-info">
            	<div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>试题内容</label>
                	<div class="kv-item-content">
                    	<textarea name="question" placeholder="试题内容" id="content" style="width:800px;height:240px;"></textarea>
                    </div>
                </div>
            </div>
            <input type="hidden" name="id" value="<%=u.getId()%>">
            <div class="buttons">
                <input class="button" type="submit" value="确认添加" />
            </div>
        </div>
    </div>
</div>
</form>
</body>
<script type="text/javascript">
	$('select').select();
	showRemind('input[type=text],textarea','color5');
	UM.getEditor('content');
</script>
</html>
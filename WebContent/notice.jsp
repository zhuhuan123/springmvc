<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/js/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/js/ueditor/lang/zh-cn/zh-cn.js"></script>

<title>公告模块</title>
<style type="text/css">
	td{
		padding: 3px
	}
</style>
</head>
<script type="text/javascript">
$(function(){
	$("#savid").click(function(){
		$.post('insertNoticeSelective',$("#form1").serialize(),function(data){
			if(data.code==200){
				//$("#center").load("NoticeUI.jsp");
				window.parent.document.getElementById("tab5").src="NoticeUI.jsp";
			}else{
				alert(data.msg);
			}
		});
	});
});
</script>
<body>
<form action="insertNoticeSelective" id="form1" method="post">
	<table>
	<tr>
		<td>标题</td>
		<td><input type="text" name="title" size=30></td>
	</tr>
	<tr>
		<td>内容</td>
		<td>
		<div>
    		<!-- <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script> -->
    		<textarea name="content" id="myEditor"></textarea> 
		</div>
	</td>
	</tr>
	<!-- <tr>
		<td></td>
		<td><input type="button" value="保存文本内容" onclick="javascript:fun()"></td>
	</tr> -->
	<tr>
		<td></td>
		<!-- <td><input type="submit" value="提交" ></td> -->
 		<td><input type="button" value="提交" id="savid"></td> 
	</tr>
	</table>
	</form>


<script type="text/javascript">
	/* var ue = UE.getEditor('editor'); */
	var editor = new UE.ui.Editor();  
    editor.render("myEditor"); 
</script>
<!-- <form action="con" id="form1" method="post">
	<input id="con1" name="con" type="text" value="">
	<input type="submit" value="提交">
</form> -->
<script type="text/javascript">
	function fun(){
		var e = UE.getEditor('editor').getContent();
		//alert(e);
		$("#con1").attr("value",e)
	}
</script>
</body>
</html>
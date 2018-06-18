<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/ueditor.config.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/js/ueditor/lang/zh-cn/zh-cn.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>notice Show </title>
</head>
<body>
<script type="text/javascript">
function sav(){
	$.post('updateNoticeSelective',$("#form1").serialize(),function(data){
		alert(data.msg);
		
	});
}
</script>
<script type="text/javascript">
	/* var ue = UE.getEditor('editor'); */
	var editor = new UE.ui.Editor();  
    editor.render("myEditor"); 
    //editor.setContent(${notice.content});
</script>
<form action="updateNoticeSelective" id="form1" method="post">
	<input type="hidden" name="id" value="${notice.id }">
	<table>
	<tr>
		<td>标题</td>
		<td><input type="text" name="title" value="${notice.title }"></td>
	</tr>
	<tr>
		<td>内容</td>
		<td>
		<div>
    		<textarea name="content" id="myEditor" >${notice.content}</textarea> 
		</div>
	</td>
	</tr>
	 
	<tr>
		<td></td>
		<td><input type="submit" value="提交" ></td>
<!-- 		<td><input type="button" value="提交" onclick="javascript:sav()"></td> -->
	</tr>
	</table>
	</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="jshead.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add Department page</title>
<style type="text/css">

	td{
		padding: 3px
	}
</style>
<script type="text/javascript">
	$(function(){
		$("#depaddid").click(function(){
			$.post("insertDepartmentsSelective",$("#fordepartmid").serialize(),function(data){
				if(data.code==200){
					//$("#center").load("departmentUIAjax.jsp");  这个是原生的不使用tab    
					window.parent.document.getElementById("tab14").src="departmentUIAjax.jsp";
					//下面这个是使用了tab
				}else{
					alert("添加失败!");
				}
			});
		});
	});
</script>
</head>
<body>
<form action="insertDepartmentsSelective" method="post" id="fordepartmid">
<table>
	<tr>
		<td>部门名称<span style="color:red">*</span></td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>部门编号<span style="color:red">*</span></td>
		<td><input type="text" name="code"></td>
	</tr>
	<tr>
		<td><input type="button" value="提交" id="depaddid"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
</table>
</form>
</body>
</html>
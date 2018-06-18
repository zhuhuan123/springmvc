<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="jshead.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	td{
	padding: 5px}
</style>
<title>update Resource</title>
</head>
<script type="text/javascript">
$(function(){
	$("#resourcebuttonupdate").click(function(){
		//alert($("#idv").val());   根据id 值更新资源信息
		$.post('updateResourceByPrimaryKey',{"id":$("#idv").val()},function(data){
			alert(data.code+" : "+data.msg);
		}); 
	});
});
</script>
<body>
<div class="liger-form" id="foridresource" >
	<form action="updateResourceByPrimaryKey"  method="post" id="formresource">
	<input type="hidden" id="idv" value="1" name="id">
	<table>
		<tr>
			<td>资源名称</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>资源url</td>
			<td><input type="text" name="url"></td>
		</tr>
		<tr>
			<td>资源描述</td>
			<td><input type="text" name="description"></td>
		</tr>
		<tr>
			<td>资源类型</td>
			<td>
				目录<input value="1" type="radio" name="resourceType">
				按钮<input value="2"  type="radio" name="resourceType">
			</td>
		</tr>
		<tr>
			<td><input type="button" value="提交" id="resourcebuttonupdate"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>
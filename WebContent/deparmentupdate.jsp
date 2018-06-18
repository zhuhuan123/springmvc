<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Departments update</title>
</head>
<body>
<form action="updateByPrimaryKeySelective" method="post">
<input type="hidden" name="id" value="${departments.id }">
<table>
	<tr>
		<td>部门名称</td>
		<td><input type="text" value="${departments.name }" name="name"></td>
	</tr>
	<tr>
		<td>部门编号</td>
		<td><input type="text" value="${departments.code}" name="code"></td>
	</tr>
	<tr>
		<td><input type="submit" value="提交"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
</table>
</form>
</body>
</html>
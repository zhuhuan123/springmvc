<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add page</title>
</head>
<body>
<form action="addUser" method="post">
<table>
	<tr>
		<td>登陆名</td>
		<td><input type="text" name="loginName"></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td>用户名</td>
		<td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td>生日</td>
		<td><input type="date" name="birthday"></td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>男<input type="radio"  name="sex" value="1">
		女<input type="radio"  name="sex" value="2"></td>
	</tr>
	
	<tr>
		<td>住址</td>
		<td><input type="text" name="address"></td>
	</tr>
	<tr>
		<td>部门</td>
		<td>
		<select name="dep_id">
		<c:forEach items="${list}" var="one">
			<option value="${one.id }">${one.name }</option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="提交"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
</head>
<body>
<center>
	<a href="addUsertopage">新增用户</a>
	<table border="1">
	<%-- <%=request.getAttribute("users") %> --%>
	<tr>
		<td>id</td>
		<td>用户名</td>
		<td>生日</td>
		<td>性别</td>
		<td>住址</td>
		<td colspan="2">相关操作</td>
	</tr>
	 <c:forEach items="${users }" var="user">
		<tr>
			<td>${user.id }</td>
			<td>${user.username }</td>
			<td><fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/></td>
			<c:if test="${user.sex==1 }">
				<td>男</td>
			</c:if>
			<c:if test="${user.sex==2 }">
				<td>女</td>
			</c:if>
			<td>${user.address }</td>
			<td><a href="updateUserToPage?id=${user.id}">更新</a></td>
			<td><a href="deleteUser?id=${user.id}">删除</a></td>
		</tr>	
	</c:forEach>

	</table>
</center>
</body>
</html>
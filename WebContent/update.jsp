<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="init.jsp" %>
 <%@ include file="jshead.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>update page</title>
<style type="text/css">
	td{
		padding: 5px
	}
</style>
</head>
<body>
<%
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	User u = (User)request.getAttribute("user");
	Date da =u.getBirthday();
	String date= format.format(da);
%>
<form action="updateUser" method="post" id="formid">
	<input type="hidden" name="id" value="${user.id}">
<table>
	<tr>
		<td>用户名</td>
		<td><input type="text" name="username" value="${user.username}"></td>
	</tr>
	<tr>
		<td>生日</td>
		<td><input type="date" name="birthday" value="<%=date%>"></td>
	</tr>
	
	<tr>
		<td>性别</td>
		<td><c:if test="${user.sex==1}">
			男<input type="radio"  name="sex" value="1" checked="checked">
			女<input type="radio"  name="sex" value="2" >
			</c:if>
			<c:if test="${user.sex==2}">
			男<input type="radio"  name="sex" value="1" >
			女<input type="radio"  name="sex" value="2" checked="checked">
			</c:if>
		</td>
	</tr>
	
	<tr>
		<td>住址</td>
		<td><input type="text" name="address" value="${user.address}"></td>
	</tr>
	<tr>
		<td>部门</td>
		<td>
		<select name="dep_id" >
		<c:forEach items="${list}" var="one">
			<c:if test="${one.id==user.dep_id }">
				<option value="${one.id }" selected="selected">${one.name }</option>
			</c:if>
			<c:if test="${one.id!=user.dep_id }">
				<option value="${one.id }">${one.name }</option>
			</c:if>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="提交">
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	$(function(){
		$("formid").ligerForm();
	});
</script>
</body>
</html>
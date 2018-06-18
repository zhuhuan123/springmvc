<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<style type="text/css">
	td{
		padding: 3px
	}
</style>
</head>

<body>
<%
String loginName="";
String password="";
Cookie [] cookies = request.getCookies();
if(cookies!=null) {
	for(Cookie c:cookies) {
		String name = c.getName();
		if(name.equals("loginName")) {
//			request.getSession().setAttribute("username", loginName);
//			return "loginSuccess";
			loginName = c.getValue();
		}
		if(name.equals("password")) {
			password = c.getValue();
		}
	}
}
%>
<form action="login" method="post" id="formid">
<table align="center">
	<tr><td colspan="2"><font color="red">${error }</font></td></tr>
	<tr>
		<td>用户名</td>
		<td><input type="text" name="loginName" value="<%=loginName %>" ></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="password" name="password" value="<%=password%>"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="checkbox" name="remember">记住用户名和密码</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="提交">
		</td>
		<td>
			<input type="reset" value="重置">
		</td>
	</tr>
	<tr>
		<td>
		</td>
		<td align="right">
			<a style="text-decoration: none" href="register" >用户注册</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>
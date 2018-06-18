<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%!
	String name ="zhuhuan";
%>
头部数据
接收到的参数值为 ${name}

<br>
使用jsp 表达式 得到给定的值  <%=name %>
</body>
</html>
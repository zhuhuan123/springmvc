<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page errorPage="error.jsp" %>
    <%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面包含设置</title>
</head>
<body>
这是主体的数据值<br>
动态导入页面
<%! int a =1,b=0; %>
<%
	
		int c = 1/b;
		out.println("输出给定的值 ");
%>
<jsp:include page="head.jsp"></jsp:include>
</body>
</html>
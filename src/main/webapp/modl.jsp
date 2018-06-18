<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ModelAndView</title>
</head>
<body>
ModelAndView  的使用<br>
username :<%=request.getAttribute("user") %>
<br>
age:  <%=request.getAttribute("age") %>
<br>
${pageContext.request}<br>
${requestScope.user}<br>
${user}
</body>
</html>
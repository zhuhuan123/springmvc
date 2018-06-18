<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp 文件测试</title>
</head>
<body>

<c:set var="a" value="age"></c:set>
通过set 命令设置的东西  ${a }<br>
<%
	out.println("{\"name\":\"zhu\",\"age\":123}<br>");
	out.println("test<br>");
	out.println("123456<br>");
%>

<%! int a=1; %>
<% if(a==1) {%>
	<font color="red">test<font>
 <%}else{ %>
	<font color="blue">test<font>
<%} %>
<form action="gpo" method="post" enctype="multipart/form-data">
<input type="text" name="name"><br>
<input type="file" name="filename"><br>
<input type="submit" value="提交">
<input type="reset" value="重置">
</form>


<script type="text/javascript">
params=[{"na":"_z"},{"age":23},
	<c:if test="${ag!=null}">{"ag":"${ag}"}</c:if>];
//alert(params);

alert(params[0]['na']);
//alert(params[1]);
</script>
<div id=""></div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="addRole.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	$(function(){
		$("#roleadd").css({"display":"block"});
		/* $.ligerDialog.open({
    		target: $("#roleadd"),
    		height: 260,
    		width: 400,
    		title: "添加",
    		showMax: true, showToggle: true, showMin: true,
    		 isResize:true 
    	}); */
	});
</script>
</body>
</html>
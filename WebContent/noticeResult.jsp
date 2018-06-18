<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告展示</title>
</head>
<body>
<%-- <table>
	<tr>
		<td><font color="red">标题:</font></td><td>${notice.title }</td>
	</tr>
	<tr>
		<td><font color="red">内容:</font></td><td></td>
	</tr>
</table> --%>
<h2><center>${notice.title }</center></h2>
${notice.content}
</body>
</html>
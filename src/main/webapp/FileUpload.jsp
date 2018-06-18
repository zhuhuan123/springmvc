<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>file upload</title>
<style type="text/css">
	td {
		padding: 3px
	}
</style>
</head>
<body>
<form action="fileUpload" method="post" enctype="multipart/form-data">
	<table>
		<tr><td><input type="file" name="upfile"></td></tr>
		<tr><td><input type="file" name="upfile"></td></tr>
		<tr><td><input type="file" name="upfile"></td></tr>
		<tr><td><input type="submit" value="上传"></td></tr>
	</table>
</form>
</body>
</html>
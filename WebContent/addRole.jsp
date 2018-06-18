<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="jshead.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
		padding: 3px;
	}
</style>
</head>
<script type="text/javascript" src="app.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#busub").click(function(){
			
			/* alert(" tab  "+tab);
			 var c = liger.get("parent.center");
			alert("liger  get"+c); */ 
			/* var l =parent.$("#center");
			alert(l+" "+l.src); */
			/* alert(window.parent.document.getElementById("roleadd"));
			alert(); */
			
			//parent.$("#center").load("RoleUI.jsp");
			$.post('addRole',$("#addRoleForm").serialize(),function(data){
				if(data.code==200){
					alert(data.code+" "+data.msg);
					window.parent.document.getElementById("tab9").src="RoleUI.jsp";
				}else{
					alert(data.code+" "+data.msg);
				}
			});
			//$("#center").load("RoleUI.jsp");
		});
	});
</script>
<body>
<div id="roleadd"  class="liger-form" >
	<form  method="post" id="addRoleForm">
	<table>
	<tr>
		<td>角色名称<span style="color:red">*</span></td>
		<td><input type="text" name="name" ></td>
	</tr>
	<tr>
		<td>角色描述</td>
		<td><input type="text" name="description"></td>
	</tr>
	<tr>
		<td>状态 <span style="color:red">*</span></td>
		<td><input type="text" name="status"></td>
	</tr>
	<tr>
		<td><input type="button" value="提交" id="busub"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
	</table>
	</form>
</div>
</body>
</html>
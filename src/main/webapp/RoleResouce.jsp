<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="jshead.jsp" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色与资源管理管理</title>
<style type="text/css">
	td{
		padding: 5px
	}
</style>


</head>
<body>


<form  method="post" id="addRoleForm" action="saveRoleResource">
	<table>
	
	<tr>
		<td>角色名称</td>
		<!-- <td>资源名称</td> -->
		<!-- <td>已经选中的资源名称</td> -->
		<td>角色资源树</td>
	</tr>
	<tr>
		<td>
			<select name="roleId" id="roleselectid">
				<c:forEach items="${roles}" var="role">
					<option value="${role.id }">${role.name }</option>
				</c:forEach>
			</select>
		</td>
		<%--<td>
			<c:forEach items="${resources}" var="resource">
				${resource.name}   <input type="checkbox" value="${resource.id }" name="resourceId"><br>
			</c:forEach>
		</td>
		 <td>
			<div id="seldiv"></div>
			
		</td> --%>
		<td><ul id="tree"></ul></td>
	</tr>
	
	<tr>
		<td><input type="button" value="关联角色与资源" id="busub"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
	</table>
</form>
<script type="text/javascript">
var tree;
	$("#busub").click(function(){
		var d= tree.getChecked();
		//alert(d);
		var re=[];
		for(var i=0;i<d.length;i++){
			re.push(d[i].data.id);
		}
		//alert(re);
		//alert($("#roleselectid").val());
		 $.post('saveRoleResourceTree',{"roleId":$("#roleselectid").val(),"resourceId":re.toString()},function(data){
			alert(data.code+"  :  "+data.msg);
		}); 
	});
	
	$("#tree").ligerTree({
	    checkbox: true,
	    parentIDFieldName:'pid',
	    idFieldName: 'id',
	    textFieldName:'text' , //指定数据中要显示的属性名，默认为"text"
	   // data: treeData,
	   	//url:'treesRole',
	    onSelect: function (node)
	    {
	        if (!node.data.name) {
	         return
	        };
	    }
	});
	tree = $("#tree").ligerGetTreeManager();
</script>
<script type="text/javascript">

//loadData(node, url, param)

$(function(){
	var sd = $("#roleselectid").find("option:selected").val();
	tree.loadData($("#tree"),'treesRole',{"id":sd});
	$("#roleselectid").bind("change",function(){
		var sd = $("#roleselectid").find("option:selected").val();
		
		tree.setData({});
		tree.loadData($("#tree"),'treesRole',{"id":sd});
	});
});

/* $(function(){
	var tem="" ;
	var sd = $("#roleselectid").find("option:selected").val(); //$("#roleselectid").
	//alert(sd);
	$.post('getRoleResourceById',{"id":sd},function(data){
		for(var i=0;i<data.length;i++){
			tem=tem+data[i].name+"  <input type='checkbox' value='"+data[i].id+"' name='resourceId' checked=checked><br>";
		}
		$("#seldiv").html(tem);
	});
	$("#roleselectid").bind("change",function(){
		tem="";
		var sd = $("#roleselectid").find("option:selected").val(); //$("#roleselectid").
		
		$.post('getRoleResourceById',{"id":sd},function(data){
			for(var i=0;i<data.length;i++){
				tem=tem+data[i].name+"  <input type='checkbox' value='"+data[i].id+"' name='resourceId' checked=checked><br>";
			}
			$("#seldiv").html(tem);
		});
	});
}); */
</script>
</body>
</html>
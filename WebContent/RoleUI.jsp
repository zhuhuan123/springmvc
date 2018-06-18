<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<%@ include file="jshead.jsp" %>
<head>
<style type="text/css">
	td{
		padding: 3px
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<script type="text/javascript">
	var grid ;
	var di;
	var updi;
	$(function(){
		 grid = $("#maingrid").ligerGrid({
	        columns:[
	            {display:"id",name:"id"},
	            {display:"角色名称",name:"name"},
	            {display:"角色描述",name:"description"},
	            {display:"状态",name:"status",render:function(rowData){
	                if(rowData.status=="0"){
	                    return "有效";
	                }else{
	                    return "无效";
	             }}},
	            {display:"操作",render:function(rowData){
return "<input value='更新' type='button' onclick='javascript:updat("+rowData.id+")'>  | <input value='删除' type='button' onclick='javascript:delet("+rowData.id+")'>"
	            }}
	        ],
	        url:'getRoles',
	        pageSize:"5",
	        toolbar: {
	        items: [
	        	{ text: '增加', click: AddRole },
	          ]
	        }
	    });
		
		
		function AddRole(){
			var fo1 = liger.get("roleadd");
			fo1.setData({"name":"","description":""});
			if(di==null){
				di = $.ligerDialog.open({
		    		target: $("#roleadd"),
		    		height: 260,
		    		width: 400,
		    		title: "添加",
		    		showMax: true, showToggle: true, showMin: true,
		    		 isResize:true 
		    	});
			}
			di.show();
		}
		
		$("#busub").click(function(){
			$.post('addRole',$("#addRoleForm").serialize(),function(data){
				alert(data.msg);
				di.hide();
				grid.loadData();
			});
		});
		$("#busubupdate").click(function(){
			$.post('updateRolById',$("#updateRoleForm").serialize(),function(data){
				alert(data.msg);
				updi.hide();
				grid.loadData();
			});
		});
		
	});
	

</script>
</head>
<body>

<div id="roleadd"  class="liger-form" style="display: none">
	<form  method="post" id="addRoleForm">
	<table>
	<tr>
		<td>角色名称</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>角色描述</td>
		<td><input type="text" name="description"></td>
	</tr>
	<tr>
		<td>状态</td>
		<td><input type="text" name="status"></td>
	</tr>
	<tr>
		<td><input type="button" value="提交" id="busub"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
	</table>
	</form>
</div>

<div id="roleupdate"  class="liger-form" style="display: none">
	<form  method="post" id="updateRoleForm">
	<input type="hidden" name="id">
	<table>
	<tr>
		<td>角色名称</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>角色描述</td>
		<td><input type="text" name="description"></td>
	</tr>
	<tr>
		<td>状态</td>
		<td><input type="text" name="status"></td>
	</tr>
	<tr>
		<td><input type="button" value="提交" id="busubupdate"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
	</table>
	</form>
</div>

<div id="maingrid"></div>
<script type="text/javascript">
function updat(id){
	var fo12 = liger.get("roleupdate");
	$.post('UpdateRole',{"id":id},function(data){
		if(updi==null){
			updi = $.ligerDialog.open({
	    		target: $("#roleupdate"),
	    		height: 260,
	    		width: 400,
	    		title: "更新",
	    		showMax: true, showToggle: true, showMin: true,
	    		 isResize:true 
	    	});	
		}
		//alert(data['status']+" : "+data['name']);
		data['status'] =String(data['status']);   
		//alert(data['status']+" : "+data['name']);
		fo12.setData(data);
		updi.show();
	});
}
function delet(id){
	question = confirm("确实要删除吗?") 
	if (question !="0"){
		$.post('DeletRole',{"id":id},function(data){
			alert(data.msg);
			grid.loadData();
		});
	}
	
}
</script>
</body>
</html>
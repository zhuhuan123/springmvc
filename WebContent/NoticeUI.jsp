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
<title>公告管理</title>
<script type="text/javascript">
	var grid ;
	var di;
	var updi;
	$(function(){
		 grid = $("#maingrid").ligerGrid({
	        columns:[
	            {display:"id",name:"id"},
	            {display:"公告标题",name:"title"},
	            {display:"公告创建时间",name:"createDate"},
	            
	            {display:"操作",render:function(rowData){
return "<a href='getContentByNoticeId?id="+rowData.id+"' target=_blank>更新</a> || <input value='删除' type='button' onclick='javascript:delet("+rowData.id+")'>"
	            }}
	        ],
	        url:'selectNoticeByExample',
	        pageSize:"5",
	        toolbar: {
	        items: [
	        	{ text: '增加', click: AddRole },
	          ]
	        } 
	    });
		
		
		function AddRole(){
			window.location.href="notice.jsp";
			/* var fo1 = liger.get("roleadd");
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
			di.show(); */
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



<div id="maingrid"></div>
<script type="text/javascript">
function updat(id){
	
	$.post('getContentByNoticeId',{"id":id},function(data){
		alert(data);
	});
}
function delet(id){
	question = confirm("确实要删除吗?") 
	if (question !="0"){
		$.post('deletNotice',{"id":id},function(data){
			alert(data.msg);
			grid.loadData();
		});
	}
	
}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="js/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script src="js/lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script>  
<script src="js/lib/jquery.cookie.js"></script>
<script src="js/lib/json2.js"></script>
<style type="text/css">
	td{
		padding: 3px
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源列表</title>
</head>
<body>
<div id="maingrid"></div>
<script type="text/javascript"></script>
<script type="text/javascript">
var diglogupdate ;
var di ;

$(function(){
    var grid = $("#maingrid").ligerGrid({
        columns:[
            {display:"id",name:"id"},
            {display:"资源名称",name:"name"},
            {display:"资源URL",name:"url"},
            {display:"资源描述",name:"description"},
            {display:"资源创建时间",name:"createTime"},
            {display:"操作",render:function(rowData){
return "<input value='更新' type='button' onclick='javascript:updateResouce("+rowData.id+")'>  | <input value='删除' type='button' onclick='javascript:delet("+rowData.id+")'>"
            }}
        ],
        url:'selectByResourceExample',
        pageSize:"5",
        toolbar: {
        items: [
        	{ text: '增加', click: AddResource},
          ]
        }
    });
    
    function AddResource(){
    	var foridresource = liger.get("foridresource");
    	//alert(foridresource);
    	foridresource.setData({});
    	if(di==null){
    		di = $.ligerDialog.open({
	    		target: $("#foridresource"),
	    		height: 260,
	    		width: 400,
	    		title: "添加",
    		});	
    	}
    	di.show();
    }
    
   
    $("#resourcebutton").click(function(){
    	$.post('insertResourceSelective',$("#formresource").serialize(),function(data){
			alert(data.msg);
			di.hide();
			grid.loadData();
		});
    });
    $("#resourceUpdatebutton").click(function(){
    	$.post('updateResourceByPrimaryKey',$("#updateFormidform").serialize(),function(data){
			alert(data.msg);
			diglogupdate.hide();
			grid.loadData();
		});
    }); 
    
    });
</script>
<div class="liger-form" id="foridresource" style="display: none">
	<form action="insertResourceSelective"  method="post" id="formresource">
	<table>
		<tr>
			<td>资源名称</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>资源url</td>
			<td><input type="text" name="url"></td>
		</tr>
		<tr>
			<td>资源描述</td>
			<td><input type="text" name="description"></td>
		</tr>
		<tr>
			<td>资源类型</td>
			<td>
				目录<input value="1" type="radio" name="resourceType">
				按钮<input value="2"  type="radio" name="resourceType">
			</td>
		</tr>
		<tr>
			<td><input type="button" value="提交" id="resourcebutton"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	</form>
</div>
<div id="updateResourceFormid" class="liger-form"  style="display: none" >
	<form action="updateByPrimaryKeySelective" id="updateFormidform" method="post">
	<input type="hidden" name="id">
	<table>
		<tr>
			<td>资源名称</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>资源url</td>
			<td><input type="text" name="url"></td>
		</tr>
		<tr>
			<td>资源描述</td>
			<td><input type="text" name="description"></td>
		</tr>
		
		<tr>
			<td><input type="button" value="提交" id="resourceUpdatebutton"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	</form>
</div>
<script type="text/javascript">
	function updateResouce(id){
		var updform = liger.get("updateResourceFormid");
		$.post('toUpdateResourceByPrimaryKeySelective',{"id":id},function(data){
			if(diglogupdate==null){
				diglogupdate = $.ligerDialog.open({
		    		target: $("#updateResourceFormid"),
		    		height: 260,
		    		width: 400,
		    		title: "更新",
		    		showMax: true, 
		    		showToggle: true, 
		    		showMin: true,
		    		 isResize:true 
		    		});	
			}
			updform.setData(data);
			diglogupdate.show();
		}); 
	}
	
	function delet(id){
		question = confirm("确实要删除吗?") 
		if (question !="0"){
			$.post('deleteResourceByPrimaryKey',{"id":id},function(data){
				alert(data.msg);
				grid.loadData();
			});
		}
	}
</script>
</body>
</html>
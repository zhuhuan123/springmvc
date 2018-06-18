<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="jshead.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	td{
	padding: 5px}
</style>
<title>add Resource</title>
</head>
<script type="text/javascript">
$(function(){
	$("#resourcebutton").click(function(){
		$.post('insertResourceSelective',$("#formresource").serialize(),function(data){
			alert(data.code+" : "+data.msg);
		});
	});
});
</script>
<body>
<div class="liger-form" id="foridresource" >
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
			<td>父类别</td>
			<td><input type="text" name="pid" id="pidtext"></td>
		</tr>
		<tr>
			<td><input type="button" value="提交" id="resourcebutton"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	</form>
</div>

<div id="tree">tree</div>


<script type="text/javascript">
var tree;
var di;
$(function(){
	
	$("#pidtext").click(function(){
		alert("点击");
		$("#tree").ligerTree({
		    checkbox: true,
		    parentIDFieldName:'pid',
		    idFieldName: 'id',
		    textFieldName:'text' , //指定数据中要显示的属性名，默认为"text"
		   // data: treeData,
		   	url:'trees',
		    onSelect: function (node)
		    {
		    	var d = tree.getChecked();
		        alert(d);
		        if (!node.data.name) {
		         return
		        };
		        //$("#pidtext").val()
		        di.hide();
		        
		    }
		});
		tree = $("#tree").ligerGetTreeManager();
		di = $.ligerDialog.open({
    		target: $("#tree"),
    		height: 500,
    		width: 400,
    		title: "选择父类别",
    		showMax: true,
    		showToggle: true,
    		showMin: true,
    		 isResize:true 
    	});	
	});
});
</script>
</body>
</html>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门列表</title>
</head>
<body>
<div id="maingrid"></div>
<script type="text/javascript"></script>
<script type="text/javascript">
$(function(){
    var grid = $("#maingrid").ligerGrid({
        columns:[
            {display:"id",name:"id"},
            {display:"姓名",name:"name"},
            {display:"编码",name:"code"},
            
            {display:"操作",render:function(rowData){
            	return "<a target='_blank' href='toUpdateByPrimaryKeySelective?id="+rowData.id+"'>更新<a/>  |  <a target='_blank' href='ddeleteByPrimaryKey?id="+rowData.id+"'>删除<a/>"
            }}
        ],
        url:'selectDepartmentsByExample',
        pageSize:"5",
        toolbar: {
        items: [
        	{ text: '增加', click: AddDeparment },
          ]
        }
    	
    });
    var di ;
    function AddDeparment(){
    	di = $.ligerDialog.open({
    		target: $("#forid"),
    		height: 260,
    		width: 400,
    		title: "添加",
    		isHidden: false
    		});	
    }
    $("#departbutton").click(function(){
    	$.post('insertDepartmentsSelective',$("#forid").serialize(),function(data){
			alert(data.msg);
			di.hide();
			grid.loadData();
		});
    });
    
    });
</script>

<form action="insertDepartmentsSelective" id="forid" method="post" style="display: none">
<table>
	<tr>
		<td>部门名称</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>部门编号</td>
		<td><input type="text" name="code"></td>
	</tr>
	<tr>
		<td><input type="button" value="提交" id="departbutton"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
</table>
</form>
</body>
</html>
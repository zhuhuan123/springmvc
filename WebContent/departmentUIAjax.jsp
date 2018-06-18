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
<title>部门列表</title>
</head>
<body>
<div id="maingrid"></div>
<script type="text/javascript"></script>
<script type="text/javascript">
var diglogupdate ;
var grid;

$(function(){
	grid = $("#maingrid").ligerGrid({
        columns:[
            {display:"id",name:"id"},
            {display:"部门名称",name:"name"},
            {display:"部门编码",name:"code"},
            {display:"操作",render:function(rowData){
return "<input value='更新' type='button' onclick='javascript:updateDeparment("+rowData.id+")'>  | <input value='删除' type='button' onclick='javascript:delet("+rowData.id+")'>"
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
    
   /*  function UpdateDeparment(){
    	diglogupdate = $.ligerDialog.open({
    		target: $("#updateFormid"),
    		height: 260,
    		width: 400,
    		title: "更新",
    		isHidden: false
    		});	
    } */
    $("#departbutton").click(function(){
    	$.post('insertDepartmentsSelective',$("#forid").serialize(),function(data){
			alert(data.msg);
			di.hide();
			grid.loadData();
		});
    });
     $("#departmentUpdatebutton").click(function(){
    	$.post('updateByPrimaryKeySelective',$("#updateFormidform").serialize(),function(data){
			alert(data.msg);
			diglogupdate.hide();
			grid.loadData();
		});
    }); 
    
    });
</script>

<form action="insertDepartmentsSelective" class="liger-form" id="forid" method="post" style="display: none">
<table>
	<tr>
		<td>部门名称</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>部门编码</td>
		<td><input type="text" name="code"></td>
	</tr>
	<tr>
		<td><input type="button" value="提交" id="departbutton"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
</table>
</form>
<div id="updateFormid" class="liger-form"  style="display: none" >
	<form action="updateByPrimaryKeySelective" id="updateFormidform" method="post">
	<input type="hidden" name="id">
	<table>
		<tr>
			<td>部门名称</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>部门编码</td>
			<td><input type="text" name="code"></td>
		</tr>
		<tr>
			<td><input type="button" value="提交" id="departmentUpdatebutton"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	</form>
</div>
<script type="text/javascript">
function updateDeparment(id){
	
	var updform = liger.get("updateFormid");
	
	$.post('toUpdateByPrimaryKeySelective',{"id":id},function(data){
		if(diglogupdate==null){
			diglogupdate = $.ligerDialog.open({
	    		target: $("#updateFormid"),
	    		height: 260,
	    		width: 400,
	    		title: "更新",
	    		showMax: true, showToggle: true, showMin: true,
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
		$.post('deleteDepartmentByPrimaryKey',{"id":id},function(data){
			alert(data.msg);
			grid.loadData();
		});
	}
}
</script>
</body>
</html>
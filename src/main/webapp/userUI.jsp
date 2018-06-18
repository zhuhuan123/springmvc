<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="js/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script src="js/lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script>  
<script src="js/lib/jquery.cookie.js"></script>
<script src="js/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
<script src="js/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="js/lib/json2.js"></script>
<head>
<style type="text/css">
	td{
		padding: 3px
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User ligerUI demo</title>
</head>
<script type="text/javascript">
	$(function(){
		 var addUserForm = $("#addUserForm").ligerForm();
		 var combo = $("#dep_selectid").ligerComboBox({   
	          url: 'selectDepartments',
	          onSelected: function (newvalue)
	           {
	              $("input[name='dep_id']").attr("value",newvalue);
	              //alert($("input[name='dep_id']").val());
	              var d = addUserForm.getData();
	              //alert("form  表单的数据值  "+d['sex']+" : "+d['username']+" : "+d['address']);
	           }
	       }); 
		
		
	});
</script>
<body>
<%-- ${name}  name值<br>
<%=request.getAttribute("name") %><br> --%>
<div id="mainsearch"></div>

<div id="winAdd" >
    <table class="tb" >
       <tr class="tr">
    	<td class="td">ID：</td>
	<td>
                 <input id="id" /></td>
        </tr>
        <tr class="tr">
            <td class="td">名字：</td>
            <td>
                <input id="username" type="text" /></td>
        </tr>
        <tr class="tr">
             <td colspan="2">
                 <button id="btnConfirm" class="ui-button">搜索</button>
                
            </td>
         </tr>
     </table>
</div>
<div id="useradd" style="display: none">
	<form action="addUser" method="post" id="addUserForm">
	<input type="hidden" name="dep_id" value="">
	<table>
	<tr>
		<td>用户名</td>
		<td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td>生日</td>
		<td><input type="date" name="birthday"></td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>男<input type="radio"  name="sex" value="1">
		女<input type="radio"  name="sex" value="2"></td>
	</tr>
	<tr>   
		<td>部门</td>
		<td>
		<div id="dep_selectid"></div>
		<!-- <select id="dep_selectid" name="dep_id">
			<option value="1">技术</option>
			<option value="2">测试</option>
		</select> -->
		
		</td>
	</tr>
	<tr>
		<td>住址</td>
		<td><input type="text" name="address"></td>
	</tr>
	<tr>
		<td><input type="button" value="提交" id="usebu"></td>
		<td><input type="reset" value="重置"></td>
	</tr>
</table>
</form>
</div>
 
<div id="maingrid"></div>

<script type="text/javascript">

$(function(){
	//depsel
	 
    var grid = $("#maingrid").ligerGrid({
       
        columns:[
            {display:"学号",name:"id"},
            {display:"姓名",name:"username"},
            {display:"生日",name:"birthday"},
            {display:"性别",name:"sex",
            	render:function(rowData){
                if(rowData.sex=="1"){
                    return "男";
                }else{
                    return "女";
                }
            }},
            {display:"操作",render:function(rowData){
return "<a target='_blank' href='updateUserToPage?id="+rowData.id+"'>更新<a/>  |  <a target='_blank' href='deleteUser?id="+rowData.id+"'>删除<a/>"
            }}
        ],
        url:'selectByPager',
        pageSize:"5",
        toolbar: {
        items: [
        	{ text: '增加', click: AddRole },
          ]
        }
    	
    });
    
    $("#btnConfirm").click(function(){
		var idvalue = $("#id").val();
		var namevalue = $("#username").val();
		
		grid.set({
			parms:[
	        	{name:"id",value:idvalue},
	        	{name:"username",value:namevalue},
	        	]
		});
		grid.loadData();
	});
    var di ;
    function AddRole(){
    		di = $.ligerDialog.open({
    		target: $("#useradd"),
    		height: 260,
    		width: 400,
    		title: "添加",
    		showMax: true, showToggle: true, showMin: true,
    		 isResize:true 
    		});	
    }
    
    $("#usebu").click(function(){
		 $.post('addUserAjax',$("#addUserForm").serialize(),function(data){
				alert(data.msg);
				di.hide();
				grid.loadData();
			});
	 });
    function ModifyRole(){
    	alert("Modify");
    }
    function DeleteRole(){
    	alert("Delete");
    }
});
</script>
</body>
</html>
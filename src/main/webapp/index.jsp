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
<title>主页面</title>
<script type="text/javascript">

$(function() {  
    $("#container").ligerLayout({  
        leftWidth : 200,  
        isScroll:true,  
        isLeftCollapse:false,  
        allowLeftResize:false,  
        allowRightResize:false,  
        allowTopResize:true,  
        allowBottomResize:true 
    });   
    function onSelect(note)
    {
    	
    	if(note.data.resourceType==2 || note.data.resourceType==0){
        	$('#center').load(note.data.url,function(responseTxt,statusTxt,xhr){
            	if(statusTxt=="success")
              
              	if(statusTxt=="error")
                	alert("Error: "+xhr.status+": "+xhr.statusText);
            });
    	}
    }
    $("#tree1").ligerTree({  
        url:'trees', 
        idFieldName :'id',
        checkbox:false,   //左侧菜单栏不设置复选框
        parentIDFieldName :'pid',
        onSelect:onSelect,
        }
        );
    $('#center').load('welcome.jsp',function(responseTxt,statusTxt,xhr){
        if(statusTxt=="success")
          
          if(statusTxt=="error")
            alert("Error: "+xhr.status+": "+xhr.statusText);
        });
});  
</script>
</head>
<body>
<div id="container">  
        <div position="top" ><div><center><h1>员工管理基本功能界面</h1></center></div>
        	<div align="right"><a style="text-decoration: none" href="logOut">退出登录</a></div>
        </div>  
        <div id="tree1" position="left">  
        </div>  
        <div position="center" id="center">  
        </div>  
        <div position="bottom" title="底部">  
    </div>  
</body>
</html>
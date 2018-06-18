<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="jshead.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tree Test</title>
</head>

<script type="text/javascript">
var tree;
treeData=[{"id":0,"name":"text1","ischecked":true},{"id":1,"name":"text2"}
,{"pid":1,"id":2,"name":"text3","ischecked":true}
,{"pid":1,"id":5,"name":"text5","ischecked":true}
,{"pid":1,"id":6,"name":"text6","ischecked":true}
,{"id":3,"name":"text4"}]
$(function(){
	$("#tree").ligerTree({
	    checkbox: true,
	    parentIDFieldName:'pid',
	    idFieldName: 'id',
	    textFieldName:'text' , //指定数据中要显示的属性名，默认为"text"
	   // data: treeData,
	   url:'treesRole',
	    onSelect: function (node)
	    {
	        if (!node.data.name) {
	         return
	        };
	        alert("点击事件");
	        //处理导航树的点击事件TODO
	         
	    }
	});
	tree = $("#tree").ligerGetTreeManager();
});
function f(){
	var e = tree.getChecked();
	for(var i=0;i<e.length;i++){
		alert(e[i].data.id+"  : "+e[i].data.text);
	}
}
</script>
<body>
<div id="tree"></div>
<input type="button" value="点击" onclick="f()">
</body>
</html>
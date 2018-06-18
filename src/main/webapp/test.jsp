<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="jshead.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
var da = ["aa","bb"];
	$.each(da,function(){
  		alert(this);
	});
function getCountryData()
{
   return [
    { Name: '中国', Code: 'ZG' },
    { Name: '德国', Code: 'DG' },
    { Name: '美国', Code: 'MG' },
    { Name: '澳大利亚', Code: 'ADLY' },
    { Name: '加拿大', Code: 'JND' }
    ];
}
</script>
<script type="text/javascript">
$(function ()
{   
    var data = [];
      
    data.push({ id: 1, pid: 0, text: '1' });
    data.push({ id: 2, pid: 1, text: '1.1' });
    data.push({ id: 4, pid: 2, text: '1.1.2' });
    data.push({ id: 5, pid: 2, text: '1.1.2' });      
    data.push({ id: 10, pid: 8, text: 'wefwfwfe' });
    data.push({ id: 11, pid: 8, text: 'wgegwgwg' });
    data.push({ id: 12, pid: 8, text: 'gwegwg' });

    data.push({ id: 6, pid: 2, text: '1.1.3', ischecked: true });
    data.push({ id: 7, pid: 2, text: '1.1.4' });
    data.push({ id: 8, pid: 7, text: '1.1.5' });
    data.push({ id: 9, pid: 7, text: '1.1.6' });

    $("#tree1").ligerTree({  
    url:'trees', 
    idFieldName :'id',
    parentIDFieldName :'pid'
    }
    );
});
</script>

<div id="tree1"></div>
<form action="fomda" method="post" style="display: none">
 	<div id="form1" class="liger-form" >
        <div class="fields">
             <input data-type="text" data-label="标题" data-name="Title" />
             <input data-type="date" data-label="入职日期" data-name="addDate" data-newline="false"/>
             <div data-type="select" data-label="国家" data-name="Country" >
                 <input class="editor"  data-data="getCountryData()" data-textField="Name" data-valueField="Code"/> 
             </div>
             <div data-type="select" data-label="城市" data-name="City">
                 <input class="editor"  data-textField="City" data-valueField="City"/>  
             </div>
        </div>  
     </div>
     <input type="submit" value="提交">
  </form> 
</body>
</html>
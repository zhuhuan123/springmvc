<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>

<frameset  cols="10%,*">
<iframe  name="idframe1" id="ididframe1">
	<a href="re.jsp" target="idframe">测试</a>
	<a href="">笔试</a>
</iframe>

<iframe   name="idframe" id="ididframe" src="login.html"></iframe>
</frameset> 

 <!-- <frameset rows="10%,90%">
            <frame src="head.jsp" name="top"/>
            <frameset cols="15%,*">
                    <frame src="gle.html" name="home"/>
                        <frame src="login.html" name="index1"/>
            </frameset>
        
            <noframes>
                <body>
                你的浏览器不支持frame
                </body>
            </noframes>
            
        </frameset> -->
</body>
</html>
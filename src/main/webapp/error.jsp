<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#img2 {
	position: absolute;
	left: 430px;
	top: 130px;
	height: 200px;
	width: 200px;
	height: 200px;
	height: 200px
}
</style>
</head>
<body>
	<img alt="" src="<%=basePath%>img/qxbz.jpg">
	<a href="<%=basePath%>usercontrol/exitlogin.spring"><img id="img2"
		alt="返回登录" onclick="sds.jsp" src="<%=basePath%>img/dianji.jpg"></a>
</body>
</html>
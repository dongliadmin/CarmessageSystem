<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/Css/style.css" />
<script type="text/javascript" src="<%=path%>/Js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="<%=path%>/Js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/Js/ckform.js"></script>
<script type="text/javascript" src="<%=path%>/Js/common.js"></script>

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>

<body>
	<form class="form-inline definewidth m20" action="index.html"
		method="get"></form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>ID</th>
				<th>用户名</th>
				<th>密码</th>
				<th>状态</th>
				<th colspan="2" style="">操作</th>
			</tr>
		</thead>
		<c:forEach items="${list }" var="item">
		
			<tr>
				<td><c:out value="${item.user_id }"></c:out></td>
				<td><c:out value="${item.username }"></c:out></td>
				<td><c:out value="********"></c:out></td>
				<c:if test="${item.state==1 }">
					<td><c:out value="未通过审核"></c:out></td>
				</c:if>
				<c:if test="${item.state==2 }">
					<td><c:out value="通过审核"></c:out></td>
				</c:if>
				<td><a
					href="<%=path%>/usercontrol/deleteuser.spring?id=${item.user_id }">删除</a></td>
				<td><a
					href="<%=path%>/usercontrol/selectuser.spring?id=${item.user_id }">更新</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
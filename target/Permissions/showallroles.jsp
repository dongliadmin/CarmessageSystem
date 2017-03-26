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
	&nbsp;&nbsp;&nbsp;
	<a href="<%=basePath%>/addroles.jsp"
		class="btn btn-primary">添加角色</a>

	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>id</th>
				<th>角色名称</th>
				<th>角色描述</th>
				<th colspan="3" style="text-align: center;">操作</th>
			</tr>
		</thead>
		<c:forEach items="${list }" var="item">
			<tr>
				<td><c:out value="${item.role_id }"></c:out></td>
				<td><c:out value="${item.name }"></c:out></td>
				<td><c:out value="${item.description }"></c:out></td>
				<td><a
					href="<%=path %>/rolesControl/deleteRoles.spring?id=${item.role_id }">删除</a></td>
				<td><a
					href="<%=path %>/rolesControl/selectRolesByid.spring?id=${item.role_id }">更新</a></td>
				<td><a
					href="<%=path %>/rolesControl/selectRAFunctionByid.spring?id=${item.role_id }">角色功能管理</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
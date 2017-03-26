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
	<form action="<%=path%>/usercontrol/updateuser.spring" method="post"
		class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td class="tableleft">用户名</td>
				<td><input type="text" name="username" value="${user.username}" /></td>
				<td class="tableleft">密码</td>
				<td><input type="text" name="password"
					value="${user.password }" /></td>
			</tr>
			<tr>
				<td class="tableleft">状态</td>
				<td><c:if test="${user.state==1}">
						<select name="state">
							<option value='2' />&nbsp;通过
							<option selected="selected" value='1' />&nbsp;未通过
						</select>
					</c:if> <c:if test="${user.state==2}">
						<select name="state">
							<option selected="selected" value='2' />&nbsp;通过
							<option value='1' />&nbsp;未通过
						</select>
					</c:if></td>
				<td class="tableleft">用户ID</td>
				<td><input name="user_id" value="${user.user_id }"
					readonly="true" /></td>

			</tr>
			<tr>
				<td class="tableleft">用户角色</td>
				<td>
					<select name="role_id">
						<c:forEach items="${role }" var="temp">
							<option  value='${temp.role_id }' />&nbsp;${temp.name }
						</c:forEach>
				</select>
				</td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
	$(function() {
		$('#backid').click(function() {
			window.location.href = "<%=path%>
	/usercontrol/showuser.spring";
		});
	});
</script>
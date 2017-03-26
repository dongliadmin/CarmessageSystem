<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="com.yzk.carsystem.model.Module_functions"%>
<%@ page import="java.util.*"%>
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
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<script>
	function selectAll(form, elementName) {
		for (var i = 0; i < form.elements.length; i++) {
			var e = form.elements[i];
			if (e.name == elementName) {
				e.checked = form.chkall.checked;
			}
		}
	}
</script>
</head>

<body>
	<form id="form1" name="form1" method="post"
		action="<%=basePath%>rolesControl/submitfunction.spring">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><label> 全选&nbsp;&nbsp;<input name="chkall" type="checkbox"
							id="chkall" value=""
							onclick="javascript:selectAll(form1,'selectId')" />
					</label></th>
					<th>方法代码</th>
					<th>描述</th>
				</tr>
				<%
					String color = "";
					int c = 1;
				%>

				<%
					List<Module_functions> allLists = (List<Module_functions>) request.getAttribute("allflist");
					for (Module_functions function : allLists) {
				%>
				<%
					if (c == 1) {
							color = "#ffffff";
							c = 0;
						} else {
							color = "#f5f5f5";
							c = 1;
						}
				%>

				<tr>
					<%
						int z = 0;
							List<Module_functions> lists = (List<Module_functions>) request.getAttribute("roleflist");
							for (Module_functions f : lists) {
								if (f.getFid() == function.getFid()) {
									z = 1;
								}
							}
					%>

					<%
						if (z == 1) {
					%>
					<td bgcolor="<%=color%>"><input name="selectId"
						type="checkbox" value="<%=function.getFid()%>" checked="checked" /></td>
					<%
						} else {
					%>
					<td bgcolor="<%=color%>"><input name="selectId"
						type="checkbox" value="<%=function.getFid()%>" /></td>
					<%
						}
					%>
					<td bgcolor="<%=color%>"><div align="center"><%=function.getFunctions_code()%></div></td>
					<td bgcolor="<%=color%>" style="word-break: break-all;"><%=function.getDescription()%></td>
				</tr>

				<%
					}
				%>
				<tr>
					<td><button type="submit" class="btn btn-primary"
							type="button">保存</button></td>
					<td>
						<button type="button" class="btn btn-success" name="backid"
							id="backid">返回列表</button>
					</td>
					<td>&nbsp;<input type="hidden" name="roleId" value="${id}"></td>
				</tr>
		</table>
	</form>
</body>
</html>
<script>
	$(function() {
		$('#backid').click(function() {
			window.location.href = "<%=basePath%>
	/rolesControl/showallRoles.spring";
						});
	});
</script>

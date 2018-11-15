<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>

<head>
<title>洗车管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>/assets/css/dpl-min.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/assets/css/bui-min.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/assets/css/main-min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="header">
		<div class="dl-title"></div>
		<div class="dl-log">
			欢迎您 <span class="dl-log-user">${username }</span> <a
				href="<%=basePath%>usercontrol/exitlogin.spring" title="退出系统"
				class="dl-log-quit">[退出]</a>
		</div>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title"></div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected">
					<div class="nav-item-inner nav-home">车主管理</div>
				</li>
				<li class="nav-item dl-selected">
					<div class="nav-item-inner nav-order">用户管理</div>
				</li>
				<li class="nav-item dl-selected">
					<div class="nav-item-inner nav-order">权限管理</div>
				</li>
				<li class="nav-item dl-selected">
					<div class="nav-item-inner nav-order">员工管理</div>
				</li>

			</ul>
		</div>

		<ul id="J_NavContent" class="dl-tab-conten">
		</ul>
	</div>

	<script type="text/javascript"
		src="<%=basePath%>/assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/assets/js/bui-min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/assets/js/common/main-min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/assets/js/config-min.js"></script>
	<script>
		BUI.use('common/main', function() {
			var config = [ {
				id : '1',
				homePage : '2',
				menu : [ {
					text : '车主管理',
					items : [ {
						id : '2',
						text : '所有车主',
						href : '<%=basePath%>/carcontrol/showcar.spring'
					}, {
						id : '3',
						text : '查找车主',
						href : '<%=basePath%>./selectshowcar.jsp'
					}, {
						id : '4',
						text : '添加车主',
						href : '<%=basePath%>/carcontrol/main.spring'
					} ]
				} ]
			},{
				id : '7',
				homePage : '9',
				menu : [ {
					text : '用户管理',
					items : [ {
						id : '9',
						text : '所有用户',
						href : '<%=basePath%>/usercontrol/showuser.spring'
					}, {
						id : '',
						text : '添加用户',
						href : '<%=basePath%>/rolesControl/showallRolesname.spring'
					} ]
				} ]
			}, {
				id : '8',
				 homePage : '13', 
				menu : [ {
					text : '权限管理',
					items : [ {
						id : '13',
						text : '角色管理',
						href : '<%=basePath%>/rolesControl/showallRoles.spring'
					}, {
						id : '14',
						text : '模块管理',
						href : '<%=basePath%>/modulescontrol/showallModules.spring'
					},{
						id : '14',
						text : '添加用户',
						href : '<%=basePath%>/rolesControl/showallRolesname.spring'
					} ]
				} ]
			}, {
				id : '9',
				 homePage : '14', 
				menu : [ {
					text : '员工管理',
					items : [ {
						id : '14',
						text : '所有员工',
						href : '<%=basePath%>/employeesControl/main.spring'
					},{
						id : '15',
						text : '添加员工',
						href : '<%=basePath%>/addEmployees.jsp'
					} ]
					} ]
			} ];
				new PageUtil.MainPage({
				modulesConfig : config
							});
						});
	</script>
</body>

</html>
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

#vip {
	width: 30px;
	height: 30px;
}
</style>
</head>
<body>
	<form class="form-inline definewidth m20"
		action="<%=path%>/carcontrol/selectcarbytype.spring" method="post">
		<select name="type" style="width: 79px">
			<option value='name' />姓名
			<option value='number' />车牌号
			<option value='tel' />手机号
		</select> <input type="text" name="value" id="rolename"
			class="abc input-default" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
	</form>
	<c:if test="${carmaster.name!=null }" var="results">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th>客户姓名</th>
					<th>电话</th>
					<th>住址</th>
					<th>汽车品牌</th>
					<th>车型</th>
					<th>备注</th>
					<th colspan="2" style="">操作</th>
				</tr>
			</thead>
			<tr>
				<td><c:if test="${carmaster.getVip().getId()==1 }">
						<img id="vip" alt="This is VIP"
							src="<%=basePath%>/assets/img/ordinaryvip.png">
					</c:if> <c:if test="${carmaster.getVip().getId()==2 }">
						<img id="vip" alt="This is VIP"
							src="<%=basePath%>/assets/img/gold.png">
					</c:if> <c:if test="${carmaster.getVip().getId()==3 }">
						<img id="vip" alt="This is VIP"
							src="<%=basePath%>/assets/img/platinum.png">
					</c:if> <c:if test="${carmaster.getVip().getId()==4 }">
						<img id="vip" alt="This is VIP"
							src="<%=basePath%>/assets/img/ordinary.png">
					</c:if> <c:out value="${carmaster.name }"></c:out></td>
				<td><c:out value="${carmaster.tel}"></c:out></td>
				<td><c:out value="${carmaster.addres}"></c:out></td>
				<td><c:out value="${carmaster.carbrand}"></c:out></td>
				<td><c:out value="${carmaster.number}"></c:out></td>
				<td><c:out value="${carmaster.note}"></c:out></td>
				<td><a
					href="./caruser_deleteCarUser.do?carMaster.id=${carmaster.id }">删除</a></td>
				<td><a
					href="./caruser_selectCarUser.do?carMaster.id=${carmaster.id }">更新</a></td>
			</tr>
		</table>
	</c:if>
	<c:if test="${identifier=='identifier' }" var="result">
		<h2 style="text-align: center;">没有此客户</h2>
	</c:if>
</body>
</html>
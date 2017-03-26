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
<script type="text/javascript">
	function checkInput() {
		var name = document.form1.name.value;
		var addres = document.form1.addres.value;
		var tel = document.form1.tel.value;
		var carbrand = document.form1.carbrand.value;
		var number = document.form1.number.value;
		if(name=="")
			{
			alert("姓名不能为空");
			return false;
			}else if(name.length>4){
				alert("姓名错误");
				return false;
			}else if(addres==""){
				alert("请输入住址");
				return false;
			}else if(tel==""||tel.length!=11){
					alert("电话错误");
					return false;
			}else if(carbrand==""){
					alert("请输入汽车品牌");
					return false;
			}else if(number==""){
				alert("请输入车牌号");
				return false;
			}else{
				return true;
			}
	}
</script>
</head>
<body>
	<form action="<%=path%>/carcontrol/addcaruser.spring" method="post"
		name="form1" onsubmit="return checkInput()">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">姓名</td>
				<td><input type="text" name="name" id="name" /></td>
				<td class="tableleft">住址</td>
				<td><input type="text" name="addres" id="addres" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">电话</td>
				<td><input type="text" name="tel" id="tel" /></td>
				<td class="tableleft">汽车品牌</td>
				<td><input type="text" name="carbrand" id="carbrand" /></td>
			</tr>
			<tr>
				<td class="tableleft">车牌号</td>
				<td><input type="text" name="number" id="number" /></td>
				<td class="tableleft">客户备注</td>
				<td><input type="text" name="note" id="note" /></td>
			</tr>
			<tr>
				<td class="tableleft">客户类型</td>
				<td><select name="level"><c:forEach items="${list }"
							var="temp">
							<option value="${temp }" />&nbsp;${temp}
					</c:forEach></select></td>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
					<h4 style="color: red">${error }</h4>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
	$(function() {
		$('#backid').click(function() {
			window.location.href = "<%=path%>/carcontrol/showcar.spring";
		});
	});
</script>

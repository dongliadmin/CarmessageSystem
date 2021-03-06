<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.yzk.carsystem.model.Module_functions"%>
<%@ page import="java.util.*"%>
<%
	String contextPath = request.getContextPath();
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>演示：jQuery实现的全选、反选和不选功能</title>
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<style>
.demo {
	width: 520px;
	margin: 40px auto 0 auto;
	min-height: 250px;
}

ul li {
	line-height: 30px;
	padding: 4px 0;
	font-size: 14px
}

.btn {
	overflow: hidden;
	display: inline-block;
	*display: inline;
	padding: 4px 20px 4px;
	font-size: 14px;
	line-height: 18px;
	*line-height: 20px;
	color: #fff;
	text-align: center;
	vertical-align: middle;
	cursor: pointer;
	background-color: #5bb75b;
	border: 1px solid #cccccc;
	border-color: #e6e6e6 #e6e6e6 #bfbfbf;
	border-bottom-color: #b3b3b3;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	margin-left: 2px
}
</style>
<script type="text/javascript" src="assets/js/jquery-3.1.1.min.js"></script>
<script>
	$(function() {
		//全选或全不选
		$("#all").click(function() {
			if (this.checked) {
				$("#list :checkbox").attr("checked", true);
			} else {
				$("#list :checkbox").attr("checked", false);
			}
		});
		//全选  
		$("#selectAll").click(function() {
			$("#list :checkbox,#all").attr("checked", true);
		});
		//全不选
		$("#unSelect").click(function() {
			$("#list :checkbox,#all").attr("checked", false);
		});
		//反选 
		$("#reverse").click(function() {
			$("#list :checkbox").each(function() {
				$(this).attr("checked", !$(this).attr("checked"));
			});
			allchk();
		});

		//设置全选复选框
		$("#list :checkbox").click(function() {
			allchk();
		});

		//获取选中选项的值
		$("#getValue").click(function() {
			var valArr = new Array;
			$("#list :checkbox[checked]").each(function(i) {
				valArr[i] = $(this).val();
			});
			var vals = valArr.join(',');
			alert(vals);
		});
	});
	function allchk() {
		var chknum = $("#list :checkbox").size();//选项总个数
		var chk = 0;
		$("#list :checkbox").each(function() {
			if ($(this).attr("checked") == true) {
				chk++;
			}
		});
		if (chknum == chk) {//全选
			$("#all").attr("checked", true);
		} else {//不全选
			$("#all").attr("checked", false);
		}
	}
</script>
</head>

<body>
	<div id="header">
		<div id="logo">
			<h1>
				<a href="http://www.helloweba.com" title="返回helloweba首页">helloweba</a>
			</h1>
		</div>
		<div class="demo_topad">
			<script src="/js/ad_js/demo_topad.js" type="text/javascript"></script>
		</div>
	</div>

	<div id="main">
		<h2 class="top_title">
			<a href="http://www.helloweba.com/view-blog-254.html">jQuery实现的全选、反选和不选功能</a>
		</h2>
		<div class="demo">
			<ul id="list">
				<li><label><input type="checkbox" value="1">
						1.时间都去哪儿了</label></li>
				<li><label><input type="checkbox" value="2">
						2.海阔天空</label></li>
				<li><label><input type="checkbox" value="3">
						3.真的爱你</label></li>
				<li><label><input type="checkbox" value="4">
						4.不再犹豫</label></li>
				<li><label><input type="checkbox" value="5">
						5.光辉岁月</label></li>
				<li><label><input type="checkbox" value="6">
						6.喜欢妳</label></li>
			</ul>
			<input type="checkbox" id="all"> <input type="button"
				value="全选" class="btn" id="selectAll"> <input type="button"
				value="全不选" class="btn" id="unSelect"> <input type="button"
				value="反选" class="btn" id="reverse"> <input type="button"
				value="获得选中的所有值" class="btn" id="getValue">
		</div>
		<br />
		<div class="ad_76090">
			<script src="/js/ad_js/bd_76090.js" type="text/javascript"></script>
		</div>
		<br />
	</div>

	<div id="footer">
		<p>
			Powered by helloweba.com 允许转载、修改和使用本站的DEMO，但请注明出处：<a
				href="http://www.helloweba.com">www.helloweba.com</a>
		</p>
	</div>
	<p id="stat">
		<script type="text/javascript" src="/js/tongji.js"></script>
	</p>
</body>
</html>

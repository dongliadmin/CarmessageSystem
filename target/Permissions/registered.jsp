<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>CarMessageSystem</title>
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
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"], .form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<style type="text/css">
.code {
	background: url(code_bg.jpg);
	font-family: Arial;
	font-style: italic;
	color: blue;
	font-size: 30px;
	border: 0;
	padding: 2px 3px;
	letter-spacing: 3px;
	font-weight: bolder;
	float: left;
	cursor: pointer;
	width: 90px;
	height: 30px;
	line-height: 60px;
	text-align: center;
	vertical-align: middle;
}

a {
	text-decoration: none;
	font-size: 12px;
	color: #288bc4;
}

a:hover {
	text-decoration: underline;
}
</style>
<script type="text/javascript">
	var code;
	function createCode() {
		code = "";
		var codeLength = 6; //验证码的长度
		var checkCode = document.getElementById("checkCode");
		var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c',
				'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A',
				'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //所有候选组成验证码的字符，当然也可以用中文的
		for (var i = 0; i < codeLength; i++) {
			var charNum = Math.floor(Math.random() * 52);
			code += codeChars[charNum];
		}
		if (checkCode) {
			checkCode.className = "code";
			checkCode.innerHTML = code;
		}
	}
	function validateCode() {
		var inputCode = document.getElementById("inputCode").value;
		var username = $("#username").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();
		$("#msg").remove();/* 删除元素 */
		if ("" == username) {
			$("#username").after("<span id='msg' style='color:red;font-size:15px'>用户名不能为空!</span>");
			return false;
		}
		$("#msg").remove();/* 删除元素 */
		if (username.length<10) {
			$("#username").after("<span id='msg' style='color:red;font-size:15px'>用户名太短!</span>");
			return false;
		}
		if(/.*[\u4e00-\u9fa5]+.*$/.test(username))
		{
			$("#username").after("<span id='msg' style='color:red;font-size:15px'>不能包含汉字!</span>");
			return false; 
		}
		
		$("#msg").empty();
		if ("" == password) {
			$("#password").after("<span id='msg' style='color:red;font-size:15px'>密码不能为空!</span>");
			return false;
		}
		$("#msg").empty();
		if (password.length<8) {
			$("#password").after("<span id='msg' style='color:red;font-size:15px'>密码不能小于8位!</span>");
			return false;
		}
		$("#msg").empty();
		if (password != password2) {
			$("#msg").empty();
			$("#password2").after("<span id='msg' style='color:red;font-size:15px'>两次密码不一致!</span>");
			return false;
		}
		if (inputCode.length <= 0) {
			alert("请输入验证码！");
			return false;
		} else if (inputCode.toUpperCase() != code.toUpperCase()) {
			alert("验证码输入有误！");
			createCode();
			return false;
		} else {
			return true;
		}
	}
</script>
<script type="text/javascript">
	window.onload = function() {
		createCode();
	}
</script>
<script>
$.validator.setDefaults({
    submitHandler: function1() {
      alert("提交事件!");
      return false;
    }
});
$().ready(function() {
    $("#commentForm").validate();
});
</script>
</head>
<body>
	<div class="container">
		<form class="form-signin"
			action="<%=path%>/usercontrol/registered.spring"
			onsubmit="return validateCode()" method="post">
			<h2 class="form-signin-heading">用户注册</h2>
			<input type="text" name="username" id="username"
				class="input-block-level" placeholder="账号"> <input
				type="password" id="password" name="password"
				class="input-block-level" placeholder="密码"> <input
				type="password" name="password2" id="password2"
				class="input-block-level" placeholder="验证密码"><br> <input
				type="text" name="verify" class="input-medium" placeholder="验证码"
				id="inputCode"><br>
			<div class="code" id="checkCode" onclick="createCode()"></div>
			<br> <br> <br>
			<p>
				<button class="btn btn-large btn-primary" type="submit">注册</button>
				<a href="./login.jsp">已有账号?点我登录</a>
			</p>
			<h4 style="color: red">${error }</h4>
		</form>
	</div>
</body>
</html>
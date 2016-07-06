<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String BASE_PATH = "/";
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("CONTEXT", basePath);
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="${CONTEXT}">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>Bootstrap后台登录界面模板 - 源码之家</title>

<link href="static/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="static/module/login/css/signin.css" rel="stylesheet">

</head>

<body>

<div class="signin">
	<div class="signin-head" style="height: 150px;">
<!-- 	<p>微信公众号管理后台</p> -->
		<img src="static/module/login/images/test/head_120.png" alt="" class="img-circle">
	</div>
	<form class="form-signin" role="form">
		<input type="text" class="form-control" placeholder="用户名" required autofocus />
		<input type="password" class="form-control" placeholder="密码" required />
		<button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
		<label class="checkbox">
			<input type="checkbox" value="remember-me"> 记住我
		</label>
	</form>
</div>

<div style="text-align:center;">
<!-- <p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p> -->
<!-- <p>微信公众号管理后台</p> -->
</div>
</body>
</html>

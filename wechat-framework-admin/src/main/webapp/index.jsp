<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String BASE_PATH = "/";
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("CONTEXT", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<base href="${CONTEXT}">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="format-detection" content="telephone=no" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>itfvck登录</title>
</head>
<script type="text/javascript">
	window.location.href="${CONTEXT}login/index";
</script>
<body>
</body>
</html>
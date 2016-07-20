<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String BASE_PATH = "/";
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("CONTEXT", basePath);
%>
<%-- <%@ page isELIgnored="false" %> --%>
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
<title>itfvck测试首页</title>
<script src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<a href="${redirectURI }">网页授权跳转</a>
	<p>openid:${userInfo.openId }</p>
	<p>unionid:${userInfo.unionId }</p>
	<p>nickName:${userInfo.nickName }</p>
	<p>city:${userInfo.city }</p>
	<br>
	<img alt="${userInfo.nickName }" src="${userInfo.headimgUrl }">
</body>
<script type="text/javascript">
	var CONTEXT = "${CONTEXT}";
</script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="js/weixin-common.js"></script>
</html>
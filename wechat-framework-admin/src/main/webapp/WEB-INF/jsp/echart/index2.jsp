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
<title>Echart测试首页</title>
<script src="js/jquery-2.1.4.min.js"></script>
<script src="static/echart-3.2.2/echarts.js"></script>
<!-- <script src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script> -->
<style type="text/css">
.chart-canv{
width: 100%; height: 600px;margin-top: 20px;
}


</style>


</head>
<body>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div id="BarTest1" class="chart-canv"></div>
	<div id="BarTest12" class="chart-canv"></div>
	<div id="BarTest14" class="chart-canv"></div>
	<div id="BarTest4" class="chart-canv"></div>
	<div id="LineTest" class="chart-canv"></div>
<!-- 	<div id="LineTest3" class="chart-canv"></div> -->
<!-- 	<div id="LineTest5" class="chart-canv"></div> -->
<!-- 	<div id="LineTest6" class="chart-canv"></div> -->
<!-- 	<div id="LineTest9" class="chart-canv"></div> -->
<!-- 	<div id="PieTest6" class="chart-canv"></div> -->
<!-- 	<div id="PieTest7" class="chart-canv"></div> -->
	
	
	
	 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<!--         <div id="main" class="chart-canv"></div> -->

</body>
<script type="text/javascript">
	var CONTEXT = "${CONTEXT}";
	
	function loadData(url,param,id){
		$.ajax({
			type : 'POST',
			url : url,
			data : param,
			dataType : 'json',
			success : function(data) {
				var result=data;
				if (result.success) {
					var option = data.option;
					// 基于准备好的dom，初始化echarts实例
			        var myChart = echarts.init(document.getElementById(id));
			     	// 使用刚指定的配置项和数据显示图表。
			        myChart.setOption(option,true);
			        document.getElementById(id).style.display="block";
			        document.getElementById(id).style.width="100%";
				}
			}
		});
	}
	
	loadData(CONTEXT+"echart2/BarTest1", null, "BarTest1");
	loadData(CONTEXT+"echart2/BarTest12", null, "BarTest12");
	loadData(CONTEXT+"echart2/BarTest14", null, "BarTest14");
	loadData(CONTEXT+"echart2/BarTest4", null, "BarTest4");
	loadData(CONTEXT+"echart2/LineTest", null, "LineTest");
// 	loadData(CONTEXT+"echart2/LineTest3", null, "LineTest3");
// 	loadData(CONTEXT+"echart2/LineTest5", null, "LineTest5");
// 	loadData(CONTEXT+"echart2/LineTest6", null, "LineTest6");
// 	loadData(CONTEXT+"echart2/LineTest9", null, "LineTest9");
// 	loadData(CONTEXT+"echart2/PieTest6", null, "PieTest6");
// 	loadData(CONTEXT+"echart2/PieTest7", null, "PieTest7");
	
	
</script>
</html>
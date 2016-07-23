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
</head>
<body>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div id="BarTest1" style="width: 100%; height: 600px;"></div>
	<div id="BarTest12" style="width: 100%; height: 600px;"></div>
	<div id="BarTest14" style="width: 100%; height: 600px;"></div>
	<div id="BarTest4" style="width: 100%; height: 600px;"></div>
	<div id="LineTest" style="width: 100%; height: 600px;"></div>
	<div id="LineTest3" style="width: 100%; height: 600px;"></div>
	<div id="LineTest5" style="width: 100%; height: 600px;"></div>
	<div id="LineTest6" style="width: 100%; height: 600px;"></div>
	<div id="LineTest9" style="width: 100%; height: 600px;"></div>
	<div id="PieTest6" style="width: 100%; height: 600px;"></div>
	<div id="PieTest7" style="width: 100%; height: 600px;"></div>
	
	
	
	 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
        <div id="main" style="height:400px"></div>

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
// 				var result=$.parseJSON(data);
				var result=data;
				if (result.success) {
					var option = $.parseJSON(result.option);
// 					var option = data.option;
					// 基于准备好的dom，初始化echarts实例
			        var myChart = echarts.init(document.getElementById(id));
			     	// 使用刚指定的配置项和数据显示图表。
			        myChart.setOption(option,true);
				}
			}
		});
	}
	
// 	loadData(CONTEXT+"echart/BarTest1", null, "BarTest1");
// 	loadData(CONTEXT+"echart/BarTest12", null, "BarTest12");
// 	loadData(CONTEXT+"echart/BarTest14", null, "BarTest14");
// 	loadData(CONTEXT+"echart/BarTest4", null, "BarTest4");
// 	loadData(CONTEXT+"echart/LineTest", null, "LineTest");
// 	loadData(CONTEXT+"echart/LineTest3", null, "LineTest3");
// 	loadData(CONTEXT+"echart/LineTest5", null, "LineTest5");
// 	loadData(CONTEXT+"echart/LineTest6", null, "LineTest6");
// 	loadData(CONTEXT+"echart/LineTest9", null, "LineTest9");
// 	loadData(CONTEXT+"echart/PieTest6", null, "PieTest6");
// 	loadData(CONTEXT+"echart/PieTest7", null, "PieTest7");
	
	
	
	
	// 基于准备好的dom，初始化echarts图表
// 	var myChart = echarts.init(document.getElementById('main'));

// 	var option = {"calculable": true,"title": {"text": "ECharts例子个数统计","link": "http://echarts.baidu.com/doc/example.html","subtext": "Rainbow bar example","x": "center"},"toolbox": {"feature": {"mark": {"show": true,"title": {"mark": "辅助线开关","markClear": "清空辅助线","markUndo": "删除辅助线"},"lineStyle": {"color": "#1e90ff","type": "dashed","width": 2}},"dataView": {"show": true,"title": "数据视图","readOnly": false,"lang": ["数据视图","关闭","刷新"]},"magicType": {"show": true,"title": {"line": "折线图切换","stack": "堆积","bar": "柱形图切换","tiled": "平铺"},"type": ["line","bar"]},"restore": {"show": true,"title": "还原"},"saveAsImage": {"show": true,"title": "保存为图片","type": "png","lang": ["点击保存"]}},"show": true},"tooltip": {"trigger": "item"},"grid": {"y2": 60,"y": 80,"borderWidth": 0},"xAxis": [{"type": "category","data": ["Line","Bar","Scatter","K","Pie","Radar","Chord","Force","Map","Gauge","Funnel"]}],"yAxis": [{"show": false,"type": "value"}],"series": [{"name": "ECharts例子个数统计","type": "bar","itemStyle": {"normal": {"label": {"show": true,"formatter": "{b}\n{c}","position": "top"},"color": function(params) {                        var colorList = [                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'                        ];                        return colorList[params.dataIndex]                    }}},"data": [12,21,10,4,12,5,6,5,25,23,7]}]};

	// 为echarts对象加载数据
// 	myChart.setOption(option);
</script>
</html>
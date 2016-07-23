package com.itfvck.wechatframework.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.abel533.echarts.AxisPointer;
import com.github.abel533.echarts.axis.AxisLabel;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import com.github.abel533.echarts.style.itemstyle.Normal;

@Controller
@RequestMapping(value = "echart2")
public class Echart3Controller {
	private static Logger logger = LoggerFactory.getLogger(Echart3Controller.class);

	@RequestMapping(value = "index")
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("echart/index2");
		return mv;
	}

	/**
	 * 折柱混合
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "BarTest1", produces = { "application/plain;charset=UTF-8" })
	@ResponseBody
	public String BarTest1(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		GsonOption option = new GsonOption();
		try {
			option.title().text("折柱混合").subtext("小标题");
			option.tooltip().trigger(Trigger.axis);
			option.toolbox().show(true).feature(Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
			option.legend("蒸发量", "降水量", "平均温度");
			option.xAxis(new CategoryAxis().data("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"));
			option.yAxis(new ValueAxis().name("水量").min(0).max(250).interval(50).axisLabel(new AxisLabel().formatter("{value} ml")),
			        new ValueAxis().name("温度").min(0).max(25).interval(5).axisLabel(new AxisLabel().formatter("{value} °C")));

			Bar bar = new Bar("蒸发量");
			bar.data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3);

			Bar bar2 = new Bar("降水量");
			bar2.data(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3);

			Line line = new Line("平均温度");
			line.yAxisIndex(1);
			line.data(2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2);

			option.series(bar, bar2, line);

			map.put("success", true);
			map.put("option", option);
		} catch (Exception e) {
			map.put("success", false);
			logger.error("错误", e);
		}
		return GsonUtil.format(map);
	}

	/**
	 * 坐标轴刻度与标签对齐(最简柱状图)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "BarTest12", produces = { "application/plain;charset=UTF-8" })
	@ResponseBody
	public String BarTest12(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		GsonOption option = new GsonOption();
		try {
			option.title().text("坐标轴刻度与标签对齐").x(X.center).subtext("二级小标题");
			option.color("#3398DB");
			option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.shadow));
			option.grid().left("3%").right("4%").bottom("3%").containLabel(true);

			CategoryAxis categoryAxis = new CategoryAxis();
			categoryAxis.axisTick(categoryAxis.axisTick().alignWithLabel(true)).name("X轴");
			categoryAxis.data("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
			option.xAxis(categoryAxis);

			option.yAxis(new ValueAxis().name("Y轴"));

			Bar bar = new Bar("直接访问");
			bar.barWidth(60);
			bar.data(10, 52, 200, 334, 390, 330, 220);

			option.series(bar);

			map.put("success", true);
			map.put("option", option);
		} catch (Exception e) {
			map.put("success", false);
			logger.error("错误", e);
		}
		return GsonUtil.format(map);
	}

	/**
	 * 堆叠条形图
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "BarTest14", produces = { "application/plain;charset=UTF-8" })
	@ResponseBody
	public String BarTest14(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		GsonOption option = new GsonOption();
		try {
			option.title().text("堆叠条形图").subtext("二级小标题").x(X.center);
			option.tooltip().trigger(Trigger.axis).axisPointer(new AxisPointer().type(PointerType.shadow)).y(Y.bottom);
			option.legend().data("直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎").bottom(Position.bottom);
			option.grid().left("3%").right("4%").bottom("3%").containLabel(true);
			option.xAxis(new ValueAxis().name("X轴"));
			option.yAxis(new CategoryAxis().data("周一", "周二", "周三", "周四", "周五", "周六", "周日").name("Y轴"));
			Bar bar = new Bar("直接访问").stack("总量").label(new ItemStyle().normal(new Normal().show(true).position(Position.insideRight)));
			bar.data(320, 302, 301, 334, 390, 330, 320);
			Bar bar2 = new Bar("邮件营销").stack("总量").label(new ItemStyle().normal(new Normal().show(true).position(Position.insideRight)));
			bar2.data(120, 132, 101, 134, 90, 230, 210);
			Bar bar3 = new Bar("联盟广告").stack("总量").label(new ItemStyle().normal(new Normal().show(true).position(Position.insideRight)));
			bar3.data(220, 182, 191, 234, 290, 330, 310);
			Bar bar4 = new Bar("视频广告").stack("总量").label(new ItemStyle().normal(new Normal().show(true).position(Position.insideRight)));
			bar4.data(150, 212, 201, 154, 190, 330, 410);
			Bar bar5 = new Bar("搜索引擎").stack("总量").label(new ItemStyle().normal(new Normal().show(true).position(Position.insideRight)));
			bar5.data(820, 832, 901, 934, 1290, 1330, 1320);

			option.series(bar, bar2, bar3, bar4, bar5);

			map.put("success", true);
			map.put("option", option);
		} catch (Exception e) {
			map.put("success", false);
			logger.error("错误", e);
		}
		return GsonUtil.format(map);
	}

	/**
	 * 饼图
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "BarTest4", produces = { "application/plain;charset=UTF-8" })
	@ResponseBody
	public String BarTest4(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		GsonOption option = new GsonOption();
		try {
			option.title().text("某站点用户访问来源").x(X.center).subtext("纯属虚构");
			option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
			option.legend().orient(Orient.vertical).left(X.left).data("直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎");

			Pie pie = new Pie("访问来源");
			pie.radius("55%").center("50%", "60%");
			pie.data(new Data("直接访问", 335), new Data("邮件营销", 310), new Data("联盟广告", 234), new Data("视频广告", 135), new Data("搜索引擎", 1548));
			pie.itemStyle(new ItemStyle().emphasis(new Emphasis().shadowBlur(10).shadowOffsetX(0).shadowColor("rgba(0, 0, 0, 0.5)")));
			option.series(pie);

			map.put("success", true);
			map.put("option", option);
		} catch (Exception e) {
			map.put("success", false);
			logger.error("错误", e);
		}
		return GsonUtil.format(map);
	}

	/**
	 * 折线图堆叠
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "LineTest", produces = { "application/plain;charset=UTF-8" })
	@ResponseBody
	public String LineTest(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		GsonOption option = new GsonOption();
		try {
			option.title().text("折线图堆叠").x(X.center).subtext("纯属虚构");
			option.tooltip().trigger(Trigger.axis).y(Y.bottom);
			option.legend().data("直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎").y(Y.bottom);
			option.grid().left("3%").right("4%").bottom("3%").containLabel(true);
			option.toolbox().feature(Tool.saveAsImage);
			CategoryAxis categoryAxis = new CategoryAxis();
			categoryAxis.boundaryGap(false).name("X轴");
			categoryAxis.data("周一", "周二", "周三", "周四", "周五", "周六", "周日");
			option.xAxis(categoryAxis);
			option.yAxis(new ValueAxis().name("Y轴"));

			Line line = new Line("直接访问").stack("总量");
			line.data(120, 132, 101, 134, 90, 230, 210);
			Line line1 = new Line("邮件营销").stack("总量");
			line1.data(220, 182, 191, 234, 290, 330, 310);
			Line line2 = new Line("联盟广告").stack("总量");
			line2.data(150, 232, 201, 154, 190, 330, 410);
			Line line3 = new Line("视频广告").stack("总量");
			line3.data(320, 332, 301, 334, 390, 330, 320);
			Line line4 = new Line("搜索引擎").stack("总量");
			line4.data(820, 932, 901, 934, 1290, 1330, 1320);

			option.series(line, line1, line2, line3, line4);

			map.put("success", true);
			map.put("option", option);
		} catch (Exception e) {
			map.put("success", false);
			logger.error("错误", e);
		}
		return GsonUtil.format(map);
	}
}

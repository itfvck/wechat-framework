package com.itfvck.wechatframework.api.report.interfacesummary;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.core.req.model.interfacesummary.InterfaceSummaryParam;
import com.itfvck.wechatframework.api.report.interfacesummary.model.InterfaceSummary;
import com.itfvck.wechatframework.api.report.interfacesummary.model.InterfaceSummaryHour;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 接口分析数据接口
 * 
 * @author qimiao
 *
 */
public class WxInterfaceSummaryAPI {
	// 获取接口分析数据
	private static String getinterfacesummary_url = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN";
	// 获取接口分析分时数据
	private static String getinterfacesummaryhour_url = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN";

	/**
	 * 获取接口分析分时数据
	 * 
	 * @param begin_date
	 *            end_date
	 * @return
	 */
	public static List<InterfaceSummaryHour> getInterfaceSummaryHour(String accesstoken, InterfaceSummaryParam param) {
		if (accesstoken != null) {
			param.setAccess_token(accesstoken);
			String requestUrl = getinterfacesummaryhour_url.replace("ACCESS_TOKEN", accesstoken);
			String json = JSONObject.toJSONString(param);
			String result = HttpUtils.post(requestUrl, json);
			InterfaceSummaryHour msgInfoList = JSON.parseObject(result, InterfaceSummaryHour.class);
			return msgInfoList.getList();
		}
		return null;
	}

	/**
	 * 获取接口分析数据
	 * 
	 * @param begin_date
	 *            end_date
	 * @return
	 */
	public static List<InterfaceSummary> getInterfaceSummary(String accesstoken, InterfaceSummaryParam param) {
		if (accesstoken != null) {
			param.setAccess_token(accesstoken);
			String requestUrl = getinterfacesummary_url.replace("ACCESS_TOKEN", accesstoken);
			String json = JSONObject.toJSONString(param);
			String result = HttpUtils.post(requestUrl, json);
			InterfaceSummary msgInfoList = JSON.parseObject(result, InterfaceSummary.class);
			return msgInfoList.getList();
		}
		return null;
	}

	public static void main(String[] args) {

		// getNewAccessToken("wx00737224cb9dbc7d","b9479ebdb58d1c6b6efd4171ebe718b5");

		WxInterfaceSummaryAPI s = new WxInterfaceSummaryAPI();
		InterfaceSummaryParam param = new InterfaceSummaryParam();
		param.setBegin_date("2015-01-01");
		param.setEnd_date("2015-01-01");

		// List<InterfaceSummary> list = s.getInterfaceSummary(param);
		List<InterfaceSummaryHour> list = s.getInterfaceSummaryHour("a8UEhkxmxN269afPJ7SuY9vVroHPYiwm9Yv5gu_yK4GGsA60IafJ3N9We4ubabgZ4lsl4kd0zqcH7JC70UsQ951Ndur4ejSIz7VvroBJn4g",
		        param);

		for (InterfaceSummaryHour bean : list) {
			System.out.println(bean.getRef_date());
			System.out.println(bean.getRef_hour());
			System.out.println(bean.getTotal_time_cost());
		}

	}

	private static void getNewAccessToken(String appid, String appscret) {
		// AccessToken atoken = new AccessToken(appid, appscret);
		// String newAccessToken = atoken.getNewAccessToken();
		// System.out.println(newAccessToken);
	}
}

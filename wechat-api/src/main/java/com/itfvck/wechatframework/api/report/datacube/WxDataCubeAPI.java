package com.itfvck.wechatframework.api.report.datacube;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.core.req.model.WexinReqException;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamMsgDistMonthParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamMsgDistParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamMsgDistWeekParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamMsgHourParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamMsgMonthParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamMsgParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamMsgWeekParam;
import com.itfvck.wechatframework.api.report.datacube.model.DataCubeStreamMsgDistInfo;
import com.itfvck.wechatframework.api.report.datacube.model.DataCubeStreamMsgDistMonthInfo;
import com.itfvck.wechatframework.api.report.datacube.model.DataCubeStreamMsgDistWeekInfo;
import com.itfvck.wechatframework.api.report.datacube.model.DataCubeStreamMsgHourInfo;
import com.itfvck.wechatframework.api.report.datacube.model.DataCubeStreamMsgInfo;
import com.itfvck.wechatframework.api.report.datacube.model.DataCubeStreamMsgMonthInfo;
import com.itfvck.wechatframework.api.report.datacube.model.DataCubeStreamMsgWeekInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 分析数据接口service
 * 
 * @author luweichao
 *
 *         2015年1月27日
 */
public class WxDataCubeAPI {

	// 获取消息发送概况数据
	private static String GETUPSTREAMMSG_URL = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN";
	// 获取消息分送分时数据
	private static String GETUPSTREAMMSGHOUR_URL = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN";
	// 获取消息发送周数据
	private static String GETUPSTREAMMSGWEEK_URL = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN";
	// 获取消息发送月数据
	private static String GETUPSTREAMMSGMONTH_URL = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN";
	// 获取消息发送分布数据
	private static String GETUPSTREAMMSGDIST_URL = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN";
	// 获取消息发送分布周数据
	private static String GETUPSTREAMMSGDISTWEEK_URL = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN";
	// 获取消息发送分布月数据
	private static String GETUPSTREAMMSGDISTMONTH_URL = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN";

	/**
	 * 获取消息发送概况数据
	 * 
	 * @param bDate
	 *            起始时间
	 * @param eDate
	 *            结束时间
	 * @return
	 * @throws WexinReqException
	 */
	public static List<DataCubeStreamMsgInfo> getWxDataCubeStreamMsgInfo(String accesstoken, String bDate, String eDate) throws WexinReqException {
		if (accesstoken != null) {
			// 封装请求参数
			DataCubeStreamMsgParam msgParam = new DataCubeStreamMsgParam();
			msgParam.setAccess_token(accesstoken);
			msgParam.setBegin_date(bDate);
			msgParam.setEnd_date(eDate);
			// 调用接口
			String requestUrl = GETUPSTREAMMSG_URL.replace("ACCESS_TOKEN", accesstoken);
			String json = JSONObject.toJSONString(msgParam);
			String result = HttpUtils.post(requestUrl, json);
			DataCubeStreamMsgInfo msgInfoList = JSON.parseObject(result, DataCubeStreamMsgInfo.class);
			return msgInfoList.getList();
		}
		return null;
	}

	/**
	 * 获取消息分送分时数据
	 * 
	 * @param bDate
	 *            起始时间
	 * @param eDate
	 *            结束时间
	 * @return
	 * @throws WexinReqException
	 */
	public static List<DataCubeStreamMsgHourInfo> getWxDataCubeStreamMsgHourInfo(String accesstoken, String bDate, String eDate) throws WexinReqException {
		if (accesstoken != null) {
			// 封装请求参数
			DataCubeStreamMsgHourParam msgParam = new DataCubeStreamMsgHourParam();
			msgParam.setAccess_token(accesstoken);
			msgParam.setBegin_date(bDate);
			msgParam.setEnd_date(eDate);

			// 调用接口
			String requestUrl = GETUPSTREAMMSGHOUR_URL.replace("ACCESS_TOKEN", accesstoken);

			String json = JSONObject.toJSONString(msgParam);
			String result = HttpUtils.post(requestUrl, json);
			DataCubeStreamMsgHourInfo msgInfoList = JSON.parseObject(result, DataCubeStreamMsgHourInfo.class);
			return msgInfoList.getList();
		}
		return null;
	}

	/**
	 * 获取消息发送周数据
	 * 
	 * @param bDate
	 *            起始时间
	 * @param eDate
	 *            结束时间
	 * @return
	 * @throws WexinReqException
	 */
	public static List<DataCubeStreamMsgWeekInfo> getWxDataCubeStreamMsgWeekInfo(String accesstoken, String bDate, String eDate) throws WexinReqException {
		if (accesstoken != null) {

			// 封装请求参数
			DataCubeStreamMsgWeekParam msgParam = new DataCubeStreamMsgWeekParam();
			msgParam.setAccess_token(accesstoken);
			msgParam.setBegin_date(bDate);
			msgParam.setEnd_date(eDate);

			// 调用接口
			String requestUrl = GETUPSTREAMMSGWEEK_URL.replace("ACCESS_TOKEN", accesstoken);
			String json = JSONObject.toJSONString(msgParam);
			String result = HttpUtils.post(requestUrl, json);
			DataCubeStreamMsgWeekInfo msgInfoList = JSON.parseObject(result, DataCubeStreamMsgWeekInfo.class);
			return msgInfoList.getList();
		}
		return null;
	}

	/**
	 * 获取消息发送月数据
	 * 
	 * @param bDate
	 *            起始时间
	 * @param eDate
	 *            结束时间
	 * @return
	 * @throws WexinReqException
	 */
	public static List<DataCubeStreamMsgMonthInfo> getWxDataCubeStreamMsgMonthInfo(String accesstoken, String bDate, String eDate) throws WexinReqException {
		if (accesstoken != null) {

			// 封装请求参数
			DataCubeStreamMsgMonthParam msgParam = new DataCubeStreamMsgMonthParam();
			msgParam.setAccess_token(accesstoken);
			msgParam.setBegin_date(bDate);
			msgParam.setEnd_date(eDate);

			// 调用接口
			String requestUrl = GETUPSTREAMMSGMONTH_URL.replace("ACCESS_TOKEN", accesstoken);
			String json = JSONObject.toJSONString(msgParam);
			String result = HttpUtils.post(requestUrl, json);
			DataCubeStreamMsgMonthInfo msgInfoList = JSON.parseObject(result, DataCubeStreamMsgMonthInfo.class);
			return msgInfoList.getList();
		}
		return null;
	}

	/**
	 * 获取消息发送分布数据
	 * 
	 * @param bDate
	 *            起始时间
	 * @param eDate
	 *            结束时间
	 * @return
	 * @throws WexinReqException
	 */
	public static List<DataCubeStreamMsgDistInfo> getWxDataCubeStreamMsgDistInfo(String accesstoken, String bDate, String eDate) throws WexinReqException {
		if (accesstoken != null) {

			// 封装请求参数
			DataCubeStreamMsgDistParam msgParam = new DataCubeStreamMsgDistParam();
			msgParam.setAccess_token(accesstoken);
			msgParam.setBegin_date(bDate);
			msgParam.setEnd_date(eDate);

			// 调用接口
			String requestUrl = GETUPSTREAMMSGDIST_URL.replace("ACCESS_TOKEN", accesstoken);
			String json = JSONObject.toJSONString(msgParam);
			String result = HttpUtils.post(requestUrl, json);
			DataCubeStreamMsgDistInfo msgInfoList = JSON.parseObject(result, DataCubeStreamMsgDistInfo.class);
			return msgInfoList.getList();
		}
		return null;
	}

	/**
	 * 获取消息发送分布周数据
	 * 
	 * @param bDate
	 *            起始时间
	 * @param eDate
	 *            结束时间
	 * @return
	 * @throws WexinReqException
	 */
	public static List<DataCubeStreamMsgDistWeekInfo> getWxDataCubeStreamMsgDistWeekInfo(String accesstoken, String bDate, String eDate) throws WexinReqException {
		if (accesstoken != null) {

			// 封装请求参数
			DataCubeStreamMsgDistWeekParam msgParam = new DataCubeStreamMsgDistWeekParam();
			msgParam.setAccess_token(accesstoken);
			msgParam.setBegin_date(bDate);
			msgParam.setEnd_date(eDate);

			// 调用接口
			String requestUrl = GETUPSTREAMMSGDISTWEEK_URL.replace("ACCESS_TOKEN", accesstoken);
			String json = JSONObject.toJSONString(msgParam);
			String result = HttpUtils.post(requestUrl, json);
			DataCubeStreamMsgDistWeekInfo msgInfoList = JSON.parseObject(result, DataCubeStreamMsgDistWeekInfo.class);
			return msgInfoList.getList();
		}
		return null;
	}

	/**
	 * 获取消息发送分布月数据
	 * 
	 * @param bDate
	 *            起始时间
	 * @param eDate
	 *            结束时间
	 * @return
	 * @throws WexinReqException
	 */
	public static List<DataCubeStreamMsgDistMonthInfo> getWxDataCubeStreamMsgDistMonthInfo(String accesstoken, String bDate, String eDate) throws WexinReqException {
		if (accesstoken != null) {

			// 封装请求参数
			DataCubeStreamMsgDistMonthParam msgParam = new DataCubeStreamMsgDistMonthParam();
			msgParam.setAccess_token(accesstoken);
			msgParam.setBegin_date(bDate);
			msgParam.setEnd_date(eDate);

			// 调用接口
			String requestUrl = GETUPSTREAMMSGDISTMONTH_URL.replace("ACCESS_TOKEN", accesstoken);
			String json = JSONObject.toJSONString(msgParam);
			String result = HttpUtils.post(requestUrl, json);
			DataCubeStreamMsgDistMonthInfo msgInfoList = JSON.parseObject(result, DataCubeStreamMsgDistMonthInfo.class);
			return msgInfoList.getList();
		}
		return null;
	}

	public static void main(String[] args) {

		// 获取消息发送概况数据
		getWxDataCubeStreamMsgInfo();

		// 获取消息分送分时数据
		testGetWxDataCubeStreamMsgHourInfo();

		// 获取消息发送周数据
		testGetWxDataCubeStreamMsgWeekInfo();

		// 获取消息发送月数据
		testGetWxDataCubeStreamMsgMonthInfo();

		// 获取消息发送分布数据
		testGetWxDataCubeStreamMsgDistInfo();

		// 获取消息发送分布周数据
		testGetWxDataCubeStreamMsgDistWeekInfo();

		// 获取消息发送分布月数据
		testGetWxDataCubeStreamMsgDistMonthInfo();
	}

	/**
	 * 获取消息发送概况数据-测试
	 */
	private static void getWxDataCubeStreamMsgInfo() {
		System.out.println("test getWxDataCubeStreamMsgInfo start ");
		WxDataCubeAPI s = new WxDataCubeAPI();
		try {
			List<DataCubeStreamMsgInfo> msgInfoList = s.getWxDataCubeStreamMsgInfo(
					"a8UEhkxmxN269afPJ7SuY9vVroHPYiwm9Yv5gu_yK4GGsA60IafJ3N9We4ubabgZ4lsl4kd0zqcH7JC70UsQ951Ndur4ejSIz7VvroBJn4g", "2015-01-01", "2015-01-07");
			if (msgInfoList != null && msgInfoList.size() > 0) {
				for (DataCubeStreamMsgInfo wxDataCubeStreamMsgInfo : msgInfoList) {
					System.out.println(wxDataCubeStreamMsgInfo.getMsg_count());
					System.out.println(wxDataCubeStreamMsgInfo.getMsg_type());
				}
			}
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
		System.out.println("test getWxDataCubeStreamMsgInfo end ");
	}

	/**
	 * 获取消息分送分时数据-测试
	 */
	private static void testGetWxDataCubeStreamMsgHourInfo() {
		System.out.println("test testGetWxDataCubeStreamMsgHourInfo start ");
		WxDataCubeAPI s = new WxDataCubeAPI();
		try {
			List<DataCubeStreamMsgHourInfo> msgInfoList = s.getWxDataCubeStreamMsgHourInfo(
					"a8UEhkxmxN269afPJ7SuY9vVroHPYiwm9Yv5gu_yK4GGsA60IafJ3N9We4ubabgZ4lsl4kd0zqcH7JC70UsQ951Ndur4ejSIz7VvroBJn4g", "2015-01-07", "2015-01-07");
			if (msgInfoList != null && msgInfoList.size() > 0) {
				for (DataCubeStreamMsgHourInfo wxDataCubeStreamMsghourInfo : msgInfoList) {
					System.out.println(wxDataCubeStreamMsghourInfo.getMsg_count());
					System.out.println(wxDataCubeStreamMsghourInfo.getMsg_type());
					System.out.println(wxDataCubeStreamMsghourInfo.getRef_hour());
				}
			}
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
		System.out.println("test testGetWxDataCubeStreamMsgHourInfo end ");
	}

	/**
	 * 获取消息发送周数据-测试
	 */
	private static void testGetWxDataCubeStreamMsgWeekInfo() {
		System.out.println("test testGetWxDataCubeStreamMsgWeekInfo start ");
		WxDataCubeAPI s = new WxDataCubeAPI();
		try {
			List<DataCubeStreamMsgWeekInfo> msgInfoList = s.getWxDataCubeStreamMsgWeekInfo(
					"a8UEhkxmxN269afPJ7SuY9vVroHPYiwm9Yv5gu_yK4GGsA60IafJ3N9We4ubabgZ4lsl4kd0zqcH7JC70UsQ951Ndur4ejSIz7VvroBJn4g", "2015-01-01", "2015-01-07");
			if (msgInfoList != null && msgInfoList.size() > 0) {
				for (DataCubeStreamMsgWeekInfo wxDataCubeStreamMsgInfo : msgInfoList) {
					System.out.println(wxDataCubeStreamMsgInfo.getMsg_count());
					System.out.println(wxDataCubeStreamMsgInfo.getMsg_type());
				}
			}
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
		System.out.println("test testGetWxDataCubeStreamMsgWeekInfo end ");
	}

	/**
	 * 获取消息发送月数据-测试
	 */
	private static void testGetWxDataCubeStreamMsgMonthInfo() {
		System.out.println("test testGetWxDataCubeStreamMsgMonthInfo start ");
		WxDataCubeAPI s = new WxDataCubeAPI();
		try {
			List<DataCubeStreamMsgMonthInfo> msgInfoList = s.getWxDataCubeStreamMsgMonthInfo(
					"a8UEhkxmxN269afPJ7SuY9vVroHPYiwm9Yv5gu_yK4GGsA60IafJ3N9We4ubabgZ4lsl4kd0zqcH7JC70UsQ951Ndur4ejSIz7VvroBJn4g", "2014-01-01", "2015-01-30");
			if (msgInfoList != null && msgInfoList.size() > 0) {
				for (DataCubeStreamMsgMonthInfo wxDataCubeStreamMsgInfo : msgInfoList) {
					System.out.println(wxDataCubeStreamMsgInfo.getMsg_count());
					System.out.println(wxDataCubeStreamMsgInfo.getMsg_type());
				}
			}
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
		System.out.println("test testGetWxDataCubeStreamMsgMonthInfo end ");
	}

	/**
	 * 获取消息发送分布数据-测试
	 */
	private static void testGetWxDataCubeStreamMsgDistInfo() {
		System.out.println("test testGetWxDataCubeStreamMsgDistInfo start ");
		WxDataCubeAPI s = new WxDataCubeAPI();
		try {
			List<DataCubeStreamMsgDistInfo> msgInfoList = s.getWxDataCubeStreamMsgDistInfo(
					"a8UEhkxmxN269afPJ7SuY9vVroHPYiwm9Yv5gu_yK4GGsA60IafJ3N9We4ubabgZ4lsl4kd0zqcH7JC70UsQ951Ndur4ejSIz7VvroBJn4g", "2015-01-01", "2015-01-15");
			if (msgInfoList != null && msgInfoList.size() > 0) {
				for (DataCubeStreamMsgDistInfo wxDataCubeStreamMsgInfo : msgInfoList) {
					System.out.println(wxDataCubeStreamMsgInfo.getRef_date());
					System.out.println(wxDataCubeStreamMsgInfo.getCount_interval());
				}
			}
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
		System.out.println("test testGetWxDataCubeStreamMsgDistInfo end ");
	}

	/**
	 * 获取消息发送分布周数据-测试
	 */
	private static void testGetWxDataCubeStreamMsgDistWeekInfo() {
		System.out.println("test testGetWxDataCubeStreamMsgDistWeekInfo start ");
		WxDataCubeAPI s = new WxDataCubeAPI();
		try {
			List<DataCubeStreamMsgDistWeekInfo> msgInfoList = s.getWxDataCubeStreamMsgDistWeekInfo(
					"a8UEhkxmxN269afPJ7SuY9vVroHPYiwm9Yv5gu_yK4GGsA60IafJ3N9We4ubabgZ4lsl4kd0zqcH7JC70UsQ951Ndur4ejSIz7VvroBJn4g", "2015-01-01", "2015-01-15");
			if (msgInfoList != null && msgInfoList.size() > 0) {
				for (DataCubeStreamMsgDistWeekInfo wxDataCubeStreamMsgInfo : msgInfoList) {
					System.out.println(wxDataCubeStreamMsgInfo.getRef_date());
					System.out.println(wxDataCubeStreamMsgInfo.getCount_interval());
				}
			}
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
		System.out.println("test testGetWxDataCubeStreamMsgDistWeekInfo end ");
	}

	/**
	 * 获取消息发送分布月数据-测试
	 */
	private static void testGetWxDataCubeStreamMsgDistMonthInfo() {
		System.out.println("test testGetWxDataCubeStreamMsgDistMonthInfo start ");
		WxDataCubeAPI s = new WxDataCubeAPI();
		try {
			List<DataCubeStreamMsgDistMonthInfo> msgInfoList = s.getWxDataCubeStreamMsgDistMonthInfo(
					"a8UEhkxmxN269afPJ7SuY9vVroHPYiwm9Yv5gu_yK4GGsA60IafJ3N9We4ubabgZ4lsl4kd0zqcH7JC70UsQ951Ndur4ejSIz7VvroBJn4g", "2015-01-01", "2015-01-15");
			if (msgInfoList != null && msgInfoList.size() > 0) {
				for (DataCubeStreamMsgDistMonthInfo wxDataCubeStreamMsgInfo : msgInfoList) {
					System.out.println(wxDataCubeStreamMsgInfo.getRef_date());
					System.out.println(wxDataCubeStreamMsgInfo.getCount_interval());
				}
			}
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
		System.out.println("test testGetWxDataCubeStreamMsgDistMonthInfo end ");
	}
}

package com.itfvck.wechatframework.api.report.datastatistics.useranalysis;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.core.req.model.WexinReqException;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamUserCumulateParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamUserSummaryParam;
import com.itfvck.wechatframework.api.report.datastatistics.useranalysis.model.UserAnalysisRtnInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * @ClassName: JwUserAnalysisAPI
 * @Description: 用户分析数据接口
 * @author zhaoxl
 */
public class WxUserAnalysisAPI {

	private static Logger logger = LoggerFactory.getLogger(WxUserAnalysisAPI.class);

	private static final String getUserSummary = "https://api.weixin.qq.com/datacube/getusersummary?access_token=%s";
	private static final String getUserCumulate = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=%s";

	private static Long getDays(String Date1, String Date2) {
		return Date.valueOf(Date1).getTime() / 86400000L - Date.valueOf(Date2).getTime() / 86400000L;
	}

	/**
	 * @throws WexinReqException
	 * @Title: getUserSummary @Description: 获取用户增减数据,传入的日期最大间隔为7天 @param @param
	 *         accesstoken @param @return 设定文件 @return UserAnalysisRtnInfo
	 *         返回类型 @throws
	 */
	public static List<UserAnalysisRtnInfo> getUserSummary(String accesstoken, String begin_date, String end_date) throws WexinReqException {
		if (accesstoken != null) {
			if (getDays(end_date, begin_date) >= 7) {
				logger.error("传入的日期间隔大于7天");
				return null;
			} else {
				DataCubeStreamUserSummaryParam userAnalysis = new DataCubeStreamUserSummaryParam();
				userAnalysis.setAccess_token(accesstoken);
				userAnalysis.setBegin_date(begin_date);
				userAnalysis.setEnd_date(end_date);
				String json = JSONObject.toJSONString(userAnalysis);
				String result = HttpUtils.post(String.format(getUserSummary, accesstoken), json);
				UserAnalysisRtnInfo msgInfoList = JSON.parseObject(result, UserAnalysisRtnInfo.class);
				return msgInfoList.getList();
			}
		}
		return null;
	}

	/**
	 * 获取累计用户数据
	 * 
	 * @param accesstoken
	 * @param begin_date
	 * @param end_date
	 * @return
	 * @throws WexinReqException
	 */
	public static List<UserAnalysisRtnInfo> getUserCumulate(String accesstoken, String begin_date, String end_date) throws WexinReqException {
		if (accesstoken != null) {
			if (getDays(end_date, begin_date) >= 7) {
				logger.error("传入的日期间隔大于7天");
				return null;
			} else {
				DataCubeStreamUserCumulateParam userCumulate = new DataCubeStreamUserCumulateParam();
				userCumulate.setAccess_token(accesstoken);
				userCumulate.setBegin_date(begin_date);
				userCumulate.setEnd_date(end_date);

				String json = JSONObject.toJSONString(userCumulate);
				String result = HttpUtils.post(String.format(getUserCumulate, accesstoken), json);
				UserAnalysisRtnInfo msgInfoList = JSON.parseObject(result, UserAnalysisRtnInfo.class);
				return msgInfoList.getList();
			}
		}
		return null;
	}
}

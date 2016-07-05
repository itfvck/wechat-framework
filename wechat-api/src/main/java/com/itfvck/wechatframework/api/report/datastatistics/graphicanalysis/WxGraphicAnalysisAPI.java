package com.itfvck.wechatframework.api.report.datastatistics.graphicanalysis;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.api.core.req.model.WexinReqException;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamArticleSummaryParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamArticleTotalParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamUserReadHourParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamUserReadParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamUserShareHourParam;
import com.itfvck.wechatframework.api.core.req.model.dataCube.DataCubeStreamUserShareParam;
import com.itfvck.wechatframework.api.report.datastatistics.graphicanalysis.model.GraphicAnalysisRtnInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * @ClassName: JwGraphicAnalysisAPI
 * @Description: 图文分析数据接口
 * @author zhaoxl
 */
public class WxGraphicAnalysisAPI {

	private static Logger logger = LoggerFactory.getLogger(WxGraphicAnalysisAPI.class);
	private static final String getArticleSummary = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=%s";
	private static final String getArticleTotal = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=%s";
	private static final String getUserRead = "https://api.weixin.qq.com/datacube/getuserread?access_token=%s";
	private static final String getUserReadHour = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=%s";
	private static final String getUserShare = "https://api.weixin.qq.com/datacube/getusershare?access_token=%s";
	private static final String getUserShareHour = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=%s";

	private static Long getDays(String Date1, String Date2) {
		return Date.valueOf(Date1).getTime() / 86400000L - Date.valueOf(Date2).getTime() / 86400000L;
	}

	/**
	 * @throws UnsupportedEncodingException
	 * @Title: getArticleSummary @Description: 获取图文群发每日数据 @param @param
	 *         accesstoken @param @param begin_date @param @param
	 *         end_date @param @return @param @throws WexinReqException
	 *         设定文件 @return List<GraphicAnalysisRtnInfo> 返回类型 @throws
	 */
	public static List<GraphicAnalysisRtnInfo> getArticleSummary(String accesstoken, String begin_date, String end_date) throws WexinReqException, UnsupportedEncodingException {
		if (accesstoken != null) {
			if (getDays(end_date, begin_date) >= 1) {
				logger.error("传入的日期间隔大于1天");
				return null;
			} else {
				DataCubeStreamArticleSummaryParam articleSummary = new DataCubeStreamArticleSummaryParam();
				articleSummary.setAccess_token(accesstoken);
				articleSummary.setBegin_date(begin_date);
				articleSummary.setEnd_date(end_date);

				String json = JSONObject.toJSONString(articleSummary);
				String result = HttpUtils.post(String.format(getArticleSummary, accesstoken), json);
				GraphicAnalysisRtnInfo msgInfoList = JSON.parseObject(result, GraphicAnalysisRtnInfo.class);
				return msgInfoList.getList();
			}
		}
		return null;
	}

	/**
	 * @throws UnsupportedEncodingException
	 * @Title: getArticleTotal @Description: 获取图文群发总数据 最大时间跨度 1天 @param @param
	 *         accesstoken @param @param begin_date @param @param
	 *         end_date @param @return @param @throws WexinReqException
	 *         设定文件 @return List<GraphicAnalysisRtnInfo> 返回类型 @throws
	 */
	public static List<GraphicAnalysisRtnInfo> getArticleTotal(String accesstoken, String begin_date, String end_date) throws WexinReqException, UnsupportedEncodingException {
		if (accesstoken != null) {
			if (getDays(end_date, begin_date) >= 1) {
				logger.error("传入的日期间隔大于1天");
				return null;
			} else {
				DataCubeStreamArticleTotalParam articleTotal = new DataCubeStreamArticleTotalParam();
				articleTotal.setAccess_token(accesstoken);
				articleTotal.setBegin_date(begin_date);
				articleTotal.setEnd_date(end_date);

				String json = JSONObject.toJSONString(articleTotal);
				String result = HttpUtils.post(String.format(getArticleTotal, accesstoken), json);
				GraphicAnalysisRtnInfo msgInfoList = JSON.parseObject(result, GraphicAnalysisRtnInfo.class);
				return msgInfoList.getList();
			}
		}
		return null;
	}

	/**
	 * @throws UnsupportedEncodingException
	 * @Title: getUserRead @Description: 获取图文统计数据 最大时间跨度 3 @param @param
	 *         accesstoken @param @param begin_date @param @param
	 *         end_date @param @return @param @throws WexinReqException
	 *         设定文件 @return List<GraphicAnalysisRtnInfo> 返回类型 @throws
	 */
	public static List<GraphicAnalysisRtnInfo> getUserRead(String accesstoken, String begin_date, String end_date) throws WexinReqException {
		if (accesstoken != null) {
			if (getDays(end_date, begin_date) >= 3) {
				logger.error("传入的日期间隔大于3天");
				return null;
			} else {
				DataCubeStreamUserReadParam userRead = new DataCubeStreamUserReadParam();
				userRead.setAccess_token(accesstoken);
				userRead.setBegin_date(begin_date);
				userRead.setEnd_date(end_date);

				String json = JSONObject.toJSONString(userRead);
				String result = HttpUtils.post(String.format(getUserRead, accesstoken), json);
				GraphicAnalysisRtnInfo msgInfoList = JSON.parseObject(result, GraphicAnalysisRtnInfo.class);
				return msgInfoList.getList();
			}
		}
		return null;
	}

	/**
	 * @Title: getUserReadHour @Description: 获取图文统计分时数据 最大时间跨度1 @param @param
	 *         accesstoken @param @param begin_date @param @param
	 *         end_date @param @return @param @throws WexinReqException
	 *         设定文件 @return List<GraphicAnalysisRtnInfo> 返回类型 @throws
	 */
	public static List<GraphicAnalysisRtnInfo> getUserReadHour(String accesstoken, String begin_date, String end_date) throws WexinReqException {
		if (accesstoken != null) {
			if (getDays(end_date, begin_date) >= 1) {
				logger.error("传入的日期间隔大于1天");
				return null;
			} else {
				DataCubeStreamUserReadHourParam userReadHour = new DataCubeStreamUserReadHourParam();
				userReadHour.setAccess_token(accesstoken);
				userReadHour.setBegin_date(begin_date);
				userReadHour.setEnd_date(end_date);

				String json = JSONObject.toJSONString(userReadHour);
				String result = HttpUtils.post(String.format(getUserReadHour, accesstoken), json);
				GraphicAnalysisRtnInfo msgInfoList = JSON.parseObject(result, GraphicAnalysisRtnInfo.class);
				return msgInfoList.getList();
			}
		}
		return null;
	}

	/**
	 * @Title: getUserShare @Description: 获取图文分享转发数据 最大时间跨度 7 @param @param
	 *         accesstoken @param @param begin_date @param @param
	 *         end_date @param @return @param @throws WexinReqException
	 *         设定文件 @return List<GraphicAnalysisRtnInfo> 返回类型 @throws
	 */
	public static List<GraphicAnalysisRtnInfo> getUserShare(String accesstoken, String begin_date, String end_date) throws WexinReqException {
		if (accesstoken != null) {
			if (getDays(end_date, begin_date) >= 7) {
				logger.error("传入的日期间隔大于7天");
				return null;
			} else {
				DataCubeStreamUserShareParam userShare = new DataCubeStreamUserShareParam();
				userShare.setAccess_token(accesstoken);
				userShare.setBegin_date(begin_date);
				userShare.setEnd_date(end_date);

				String json = JSONObject.toJSONString(userShare);
				String result = HttpUtils.post(String.format(getUserShare, accesstoken), json);
				GraphicAnalysisRtnInfo msgInfoList = JSON.parseObject(result, GraphicAnalysisRtnInfo.class);
				return msgInfoList.getList();
			}
		}
		return null;
	}

	public static List<GraphicAnalysisRtnInfo> getUserShareHour(String accesstoken, String begin_date, String end_date) throws WexinReqException {
		if (accesstoken != null) {
			if (getDays(end_date, begin_date) >= 1) {
				logger.error("传入的日期间隔大于1天");
				return null;
			} else {
				DataCubeStreamUserShareHourParam userShareHour = new DataCubeStreamUserShareHourParam();
				userShareHour.setAccess_token(accesstoken);
				userShareHour.setBegin_date(begin_date);
				userShareHour.setEnd_date(end_date);

				String json = JSONObject.toJSONString(userShareHour);
				String result = HttpUtils.post(String.format(getUserShareHour, accesstoken), json);
				GraphicAnalysisRtnInfo msgInfoList = JSON.parseObject(result, GraphicAnalysisRtnInfo.class);
				return msgInfoList.getList();
			}
		}
		return null;
	}
}
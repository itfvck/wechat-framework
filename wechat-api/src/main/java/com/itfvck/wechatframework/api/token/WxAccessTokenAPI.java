package com.itfvck.wechatframework.api.token;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * @Description 基础API
 * @Author vcdemon
 * @CreationDate 2016年5月12日 上午10:31:55
 */
public class WxAccessTokenAPI {

	private static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

	/**
	 * @Description 获取基础Access_token
	 * @param appid
	 *            公众号appid
	 * @param appsecret
	 *            公众号secret
	 * @return
	 * @CreationDate 2016年5月12日 上午11:53:55
	 * @Author vcdemon
	 */
	public static String getAccess_token(String appid, String appsecret) {
		BaseParams baseData = new BaseParams();
		baseData.setAppId(appid);
		baseData.setAppSecret(appsecret);
		baseData = getAccess_token(baseData);
		if (baseData != null && StringUtils.isNotEmpty(baseData.getAccess_token())) {
			return baseData.getAccess_token();
		}
		return null;
	}

	/**
	 * @Description 获取基础Access_token
	 * @param baseData,传入appid,appsecret
	 * @return
	 * @CreationDate 2016年5月12日 上午11:53:55
	 * @Author vcdemon
	 */
	private static BaseParams getAccess_token(BaseParams baseData) {
		try {
			String responseBody = HttpUtils.get(String.format(GET_ACCESS_TOKEN_URL, baseData.getAppId(), baseData.getAppSecret()));
			if (!StringUtils.isEmpty(responseBody)) {
				baseData.setAccess_token(JSON.parseObject(responseBody, BaseParams.class).getAccess_token());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseData;
	}
}

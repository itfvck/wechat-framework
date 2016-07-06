package com.itfvck.wechatframework.token;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.api.jsapi.WxJsSDKAPI;
import com.itfvck.wechatframework.api.token.WxAccessTokenAPI;

/**
 * token管理抽象类，
 * 
 * @author lidong
 *
 */
public class AbstractTokenProxy implements TokenProxy {
	private static Logger logger = LoggerFactory.getLogger(AbstractTokenProxy.class);
	/**
	 * 默认token容器
	 */
	protected ConcurrentHashMap<String, Map<Object, Object>> tokenMap = new ConcurrentHashMap<String, Map<Object, Object>>();
	protected static final String ACCESS_TOKEN_PREFIX = "access_token";
	protected static final String JS_TIKET_PREFIX = "js_tiket";

	/**
	 * 默认token过期时间
	 */
	protected static final Long EXPIRE_TIME = 6000 * 1000L;

	// protected static final Long EXPIRE_TIME = 20 * 1000L;// 测试用。值设小

	public String accessToken(String appid, String secret) {
		return null;
	}

	public String jsTiket(String appid, String secret) {
		return null;
	}

	/**
	 * 从map获取token,该方法给默认token管理类使用
	 * 
	 * @param appid
	 * @return
	 */
	protected String getAccessTokenFromMap(String appid, String prefix) {
		String token = null;
		// 获取token数据集合
		Map<Object, Object> map = tokenMap.get(prefix + appid);
		if (map != null) {
			// 获取token值
			token = (String) map.get(prefix);
		}
		return token;
	}

	/**
	 * 刷新access_token
	 * 
	 * @param appid
	 * @param secret
	 * @return
	 */
	protected String refreshAccessToken(String appid, String secret) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		String access_token = WxAccessTokenAPI.getAccess_token(appid, secret);
		logger.info("请求access_token=" + access_token);
		if (StringUtils.isNotEmpty(access_token)) {
			map.put(ACCESS_TOKEN_PREFIX, access_token);
			map.put(EXPIRE_TIME, new Date().getTime());
			tokenMap.put(ACCESS_TOKEN_PREFIX + appid, map);
			return getAccessTokenFromMap(appid, ACCESS_TOKEN_PREFIX);
		}
		return null;
	}

	/**
	 * 刷新js_tiket
	 * 
	 * @param appid
	 * @param secret
	 * @return
	 */
	protected String refreshJsTiket(String appid, String secret) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		String accessToken = getAccessTokenFromMap(appid, ACCESS_TOKEN_PREFIX);
		if (StringUtils.isEmpty(accessToken)) {
			accessToken = refreshAccessToken(appid, secret);
		}
		String js_tiket = WxJsSDKAPI.getJs_tiket(accessToken);
		logger.info("请求js_tiket=" + js_tiket);
		if (StringUtils.isNotEmpty(js_tiket)) {
			map.put(JS_TIKET_PREFIX, js_tiket);
			map.put(EXPIRE_TIME, new Date().getTime());
			tokenMap.put(JS_TIKET_PREFIX + appid, map);
			return getAccessTokenFromMap(appid, JS_TIKET_PREFIX);
		}
		return null;
	}

	/**
	 * 检测map中token是否过期,该方法给默认token管理类使用
	 * 
	 * @param appid
	 * @param prefix
	 * @return true过期，false未过期
	 */
	protected boolean checkExpire(String appid, String prefix) {
		// 获取token数据集合
		Map<Object, Object> map = tokenMap.get(prefix + appid);
		if (map != null) {
			// 获取token存储时间
			Long expireTime = (Long) map.get(EXPIRE_TIME);
			if ((expireTime + EXPIRE_TIME) < new Date().getTime()) {
				return true;
			}
		}
		return false;
	}

	protected void cleanToken(String appid, String prefix) {
		tokenMap.remove(prefix + appid);
	}

}

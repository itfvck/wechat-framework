package com.itfvck.wechatframework.token.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itfvck.wechatframework.token.AbstractTokenProxy;

/**
 * 默认token管理类
 * 
 * @author vcdemon
 *
 */
//@Service("tokenProxy")
public class TokenProxyDefault extends AbstractTokenProxy {
	private static Logger logger = LoggerFactory.getLogger(TokenProxyDefault.class);

	@Override
	public String accessToken(String appid, String secret) {
		// 获取access_token数据集合
		Map<Object, Object> map = tokenMap.get(ACCESS_TOKEN_PREFIX + appid);
		if (map != null) {
			if (!checkExpire(appid, ACCESS_TOKEN_PREFIX)) {
				// token未过期
				logger.info("access_token未过期");
				return getAccessTokenFromMap(appid, ACCESS_TOKEN_PREFIX);
			} else {
				// token过期，清除token
				logger.info("access_token过期，清除token");
				cleanToken(appid, ACCESS_TOKEN_PREFIX);
				// 刷新access_token
				logger.info("刷新access_token");
				return refreshAccessToken(appid, secret);
			}
		} else {
			// 不存在access_token数据集合，刷新access_token
			logger.info("不存在access_token数据集合，刷新access_token");
			return refreshAccessToken(appid, secret);
		}
	}

	@Override
	public String jsTiket(String appid, String secret) {
		// 获取js_tiket数据集合
		Map<Object, Object> map = tokenMap.get(JS_TIKET_PREFIX + appid);
		if (map != null) {
			if (!checkExpire(appid, JS_TIKET_PREFIX)) {
				// js_tiket未过期
				logger.info("js_tiket未过期");
				return getAccessTokenFromMap(appid, JS_TIKET_PREFIX);
			} else {
				// js_tiket过期，清除js_tiket
				logger.info("js_tiket过期，清除js_tiket");
				cleanToken(appid, JS_TIKET_PREFIX);
				// 刷新js_tiket,并返回js_tiket
				logger.info("刷新js_tiket,并返回js_tiket");
				return refreshJsTiket(appid, secret);
			}
		} else {
			// 不存在js_tiket数据集合，刷新js_tiket
			logger.info("不存在js_tiket数据集合，刷新js_tiket");
			return refreshJsTiket(appid, secret);
		}
	}

}

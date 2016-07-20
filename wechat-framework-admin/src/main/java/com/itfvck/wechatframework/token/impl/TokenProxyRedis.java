package com.itfvck.wechatframework.token.impl;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfvck.wechatframework.api.jsapi.WxJsSDKAPI;
import com.itfvck.wechatframework.api.token.WxAccessTokenAPI;
import com.itfvck.wechatframework.jedis.JedisTemplate;
import com.itfvck.wechatframework.token.AbstractTokenProxy;

/**
 * 默认token管理类
 * 
 * @author lidong
 *
 */
@Service("tokenProxy")
public class TokenProxyRedis extends AbstractTokenProxy {
	private static Logger logger = LoggerFactory.getLogger(TokenProxyRedis.class);

	@Autowired
	private JedisTemplate jedisTemplate;

	@Override
	public String accessToken(String appid, String secret) {
		String token = jedisTemplate.get(ACCESS_TOKEN_PREFIX + appid);
		if (StringUtils.isNotEmpty(token)) {
			logger.info("accessToken redis存在,accessToken=" + token);
			return token;
		} else {
			String access_token = WxAccessTokenAPI.getAccess_token(appid, secret);
			logger.info("accessToken redis未获取到,刷新accessToken=" + access_token);
			if (StringUtils.isNotEmpty(access_token)) {
				jedisTemplate.setex(ACCESS_TOKEN_PREFIX + appid, EXPIRE_TIME, access_token, TimeUnit.MILLISECONDS);
				logger.info("accessToken 存入redis");
				return access_token;
			}
		}
		return null;
	}

	@Override
	public String jsTiket(String appid, String secret) {
		String token = jedisTemplate.get(JS_TIKET_PREFIX + appid);
		if (StringUtils.isNotEmpty(token)) {
			logger.info("js_tiket redis存在,js_tiket=" + token);
			return token;
		} else {
			String js_tiket = WxJsSDKAPI.getJs_tiket(accessToken(appid, secret));
			logger.info("js_tiket redis未获取到,刷新js_tiket=" + js_tiket);
			if (StringUtils.isNotEmpty(js_tiket)) {
				jedisTemplate.setex(JS_TIKET_PREFIX + appid, EXPIRE_TIME, js_tiket, TimeUnit.MILLISECONDS);
				logger.info("js_tiket 存入redis");
				return js_tiket;
			}
		}
		return null;
	}

}

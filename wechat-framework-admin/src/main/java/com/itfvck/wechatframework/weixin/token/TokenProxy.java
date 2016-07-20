package com.itfvck.wechatframework.token;

/**
 * token管理接口
 * 
 * @author lidong
 *
 */
public interface TokenProxy {

	String accessToken(String appid, String secret);

	String jsTiket(String appid, String secret);
}

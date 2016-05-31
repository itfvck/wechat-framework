package com.itfvck.wechatframework.core.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.common.WechatConfig;

/**
 * Access token实体模型
 * 
 * @author ChengNing
 * @date 2014年12月12日
 */
public class AccessToken extends Token {

    private static Logger logger = LoggerFactory.getLogger(AccessToken.class);
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    @Override
    protected String tokenName() {
        return "access_token";
    }

    @Override
    protected String expiresInName() {
        return "expires_in";
    }

    /**
     * 组织accesstoken的请求utl
     */
    @Override
    protected String accessTokenUrl() {
        String url = String.format(ACCESS_TOKEN_URL, WechatConfig.instance().getAppid(), WechatConfig.instance().getAppSecret());
        logger.info("创建获取access_token url");
        return url;
    }

}

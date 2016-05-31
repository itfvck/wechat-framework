package com.itfvck.wechatframework.api.oauth.protocol.get_access_token;

import com.itfvck.wechatframework.core.common.WechatConfig;

/**
 * 请求：通过code换取网页授权access_token Created by xuwen on 2015-12-11.
 */
public class GetAccessTokenRequest {

    public GetAccessTokenRequest(String code) {
        this.code = code;
    }

    private String appid = WechatConfig.instance().getAppid();
    private String secret = WechatConfig.instance().getAppSecret();
    private String code;
    private String grant_type = "authorization_code";

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}

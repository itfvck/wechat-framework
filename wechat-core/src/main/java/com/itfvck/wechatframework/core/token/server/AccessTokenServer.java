package com.itfvck.wechatframework.core.token.server;

import com.itfvck.wechatframework.core.common.WechatConfig;

/**
 * 适配器
 * 
 * @author ChengNing
 * @date 2015年1月30日
 */
public class AccessTokenServer extends AbsServer implements TokenServer {

    /**
     * 
     */
    public String token() {
        return super.token();
    }

    @Override
    protected String getCustomerServerClass() {
        return WechatConfig.instance().getAccessTokenServer();
    }

    @Override
    public IServer defaultServer() {
        return AccessTokenMemServer.instance();
    }

}

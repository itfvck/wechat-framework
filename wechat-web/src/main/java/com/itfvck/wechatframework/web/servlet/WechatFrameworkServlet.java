package com.itfvck.wechatframework.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.itfvck.wechatframework.core.common.WechatConfig;
import com.itfvck.wechatframework.web.support.WechatSupport;

public abstract class WechatFrameworkServlet extends HttpServlet {
    private static final long serialVersionUID = -3673669864159664378L;
    protected WechatSupport wechatService = null;
    protected WechatConfig conf = WechatConfig.instance();

    public void init() throws ServletException {

    }

    public WechatSupport getWechatService() {
        return wechatService;
    }

    public void setWechatService(WechatSupport wechatService) {
        this.wechatService = wechatService;
    }

}

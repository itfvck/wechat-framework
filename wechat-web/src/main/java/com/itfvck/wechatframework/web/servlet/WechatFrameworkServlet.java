package com.itfvck.wechatframework.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.web.service.WechatDefaultService;
import com.itfvck.wechatframework.web.support.WechatSupport;

public abstract class WechatFrameworkServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(WechatFrameworkServlet.class);
    private static final long serialVersionUID = -3673669864159664378L;
    private static final String CLAZZ_NAME = "wechatService";

    private WechatSupport wechat = null;

    public void init() throws ServletException {
        initWechatServer();
        logger.info("消息处理中心服务器:" + wechat);
    }

    private void initWechatServer() {
        try {
            wechat = (WechatSupport) Class.forName(this.getInitParameter(CLAZZ_NAME), true, Thread.currentThread().getContextClassLoader()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            logger.info("自定义微信消息处理中心服务器初始化失败,转入默认消息处理器初始化");
            wechat = WechatDefaultService.instance();
            logger.info("默认消息处理器初始化完成");
        }
    }

    public WechatSupport getWechatService() {
        return wechat;
    }

}

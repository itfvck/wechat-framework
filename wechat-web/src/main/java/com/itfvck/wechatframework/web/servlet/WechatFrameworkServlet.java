package com.itfvck.wechatframework.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.support.WechatSupport;
import com.itfvck.wechatframework.web.service.WechatDefaultService;

/**
 * 默认servlet初始化层
 * 
 * @author
 *
 */
public abstract class WechatFrameworkServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(WechatFrameworkServlet.class);
    private static final long serialVersionUID = -3673669864159664378L;
    private static final String CLAZZ_NAME = "wechatService";

    private WechatSupport wechat = null;

    public void init() throws ServletException {
        initWechatServer();
        logger.info("消息处理中心服务器:" + wechat);
    }

    /**
     * 初始化微信消息处理器对象，第一步初始化自定义消息处理器，初始化失败则采用默认消息处理器
     */
    private void initWechatServer() {
        try {
            wechat = (WechatSupport) Class.forName(this.getInitParameter(CLAZZ_NAME), true, Thread.currentThread().getContextClassLoader()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            logger.info("自定义微信消息处理中心服务器初始化失败,转入默认消息处理器初始化");
            wechat = WechatDefaultService.instance();
            logger.info("默认消息处理器初始化完成");
        }
    }

    /**
     * 获取消息处理器对象
     * 
     * @return
     */
    public WechatSupport getWechatService() {
        return wechat;
    }

}

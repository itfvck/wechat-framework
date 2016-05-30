package com.itfvck.wechatframework.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.common.WechatConfig;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.util.SignatureUtil;
import com.itfvck.wechatframework.web.support.WechatSupport;

public abstract class WechatDefaultDispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Logger logger = LoggerFactory.getLogger(WechatDefaultDispatcher.class);

    private WechatSupport wechatService = null;
    private WechatConfig conf = WechatConfig.instance();

    public WechatSupport getWechatService() {
        return wechatService;
    }

    public void setWechatService(WechatSupport wechatService) {
        this.wechatService = wechatService;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WechatParam params = new WechatParam(request);
        logger.info("GET params：" + params.toString());
        PrintWriter out = null;
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (SignatureUtil.checkSignature(params, conf)) {
                out.print(params.getEchostr());
            } else {
                out.print("params=" + params.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("IOException错误", e.getMessage());
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
            out = null;
        }
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WechatParam params = new WechatParam(request);
        logger.info("POST params：" + params.toString());
        PrintWriter out = null;
        String xml = null;
        try {
            out = response.getWriter();
            // 调用核心服务类接收处理请求
            xml = wechatService.service(request, conf, params);
            out.print(xml);
        } catch (Exception e) {
            logger.error("核心服务类接收处理请求错误", xml + "\n" + e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
                out = null;
            }
        }
    }

}

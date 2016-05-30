package com.itfvck.wechatframework.core.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.common.WechatCommonConst;
import com.itfvck.wechatframework.core.common.WechatConfig;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.mp.AesException;
import com.itfvck.wechatframework.core.mp.WXBizMsgCrypt;
import com.itfvck.wechatframework.core.msg.Article;
import com.itfvck.wechatframework.core.requestMsg.Item;
import com.itfvck.wechatframework.core.requestMsg.WechatRequest;
import com.itfvck.wechatframework.core.responseMsg.WechatResponse;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
    static Logger logger = LoggerFactory.getLogger(MessageUtil.class);
    private static XStream xstream = new XStream();

    /**
     * 解析微信发来的请求(Xml)
     * 
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     * @throws AesException
     */
    public static String parseXml(HttpServletRequest request, WechatConfig conf, WechatParam params) throws Exception {
        Document document = new SAXReader().read(request.getInputStream());
        if (WechatCommonConst.AES.getValue().equals(params.getEncrypt_type())) {
            // 将加密的XML转换为明文XML
            logger.info("parseXml接收到的安全模式消息微信消息" + document.asXML());
            document = DocumentHelper.parseText(new WXBizMsgCrypt(conf).decryptMsg(params, document.asXML()));
        }
        logger.info("parseXml接收到的微信消息" + document.asXML());
        return document.asXML();
    }

    public static WechatRequest fromXML(String xml) {
        xstream.alias("xml", WechatRequest.class);
        xstream.alias("item", Item.class);
        return (WechatRequest) xstream.fromXML(xml);
    }

    public static String toXML(WechatResponse response) {
        xstream.alias("xml", WechatResponse.class);
        xstream.alias("item", Article.class);
        return xstream.toXML(response);
    }
}

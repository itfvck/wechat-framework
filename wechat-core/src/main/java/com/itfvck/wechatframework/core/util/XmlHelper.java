package com.itfvck.wechatframework.core.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatCommonConst;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.mp.AesException;
import com.itfvck.wechatframework.core.mp.WXBizMsgCrypt;
import com.itfvck.wechatframework.core.msg.ArticleResponse;
import com.itfvck.wechatframework.core.requestMsg.Item;
import com.itfvck.wechatframework.core.requestMsg.WechatRequest;
import com.itfvck.wechatframework.core.responseMsg.WechatResponse;
import com.thoughtworks.xstream.XStream;

public class XmlHelper {
	static Logger logger = LoggerFactory.getLogger(XmlHelper.class);
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
	public static String parseXml(HttpServletRequest request, BaseParams conf, WechatParam params) throws Exception {
		Document document = new SAXReader().read(request.getInputStream());
		if (WechatCommonConst.AES.getValue().equals(params.getEncrypt_type())) {
			// 将加密的XML转换为明文XML
			logger.info("parseXml接收到的安全模式消息微信消息" + document.asXML());
			document = DocumentHelper.parseText(new WXBizMsgCrypt(conf).decryptMsg(params, document.asXML()));
		}
		logger.info("parseXml接收到的微信消息" + document.asXML());
		return document.asXML();
	}

	/**
	 * 将XML格式的字符串转换为WechatRequest对象，"xml"作为根节点，"item"作为Item根节点，其他节点为对象字段
	 * 
	 * @param xml
	 *            从流中读取出来的XML转换后的字符串
	 * @see Item
	 * @see WechatRequest
	 * @return WechatRequest
	 */
	public static WechatRequest toObj(String xml) {
		xstream.alias("xml", WechatRequest.class);
		xstream.alias("item", Item.class);
		return (WechatRequest) xstream.fromXML(xml);
	}

	/**
	 * 将WechatResponse对象转换为XML格式的字符串，"xml"作为根节点，"item"作为ArticleResponse根节点，
	 * 其他节点为对象字段
	 * 
	 * @param response
	 *            将要返回给微信服务器的消息对象
	 * @see ArticleResponse
	 * @see WechatResponse
	 * @return
	 */
	public static String toXML(WechatResponse response) {
		xstream.alias("xml", WechatResponse.class);
		xstream.alias("item", ArticleResponse.class);
		return xstream.toXML(response);
	}

	/**
	 * 将XML字符串转换为对象的通用方法，"xml"作为跟节点，其他节点为对象字段
	 * 
	 * @param xml
	 *            XML字符串转
	 * @param t
	 *            传入具体对象类型，需要将该对象作为XML根节点
	 * @return
	 */
	public static Object toObj(String xml, Class t) {
		xstream.alias("xml", t);
		return xstream.fromXML(xml);
	}

	/**
	 * 将对象转换为XML字符串的通用方法，"xml"作为根节点，其他节点为对象字段
	 * 
	 * @param t
	 * @return
	 */
	public static String toXML(Object t) {
		xstream.alias("xml", t.getClass());
		return xstream.toXML(t);
	}
}

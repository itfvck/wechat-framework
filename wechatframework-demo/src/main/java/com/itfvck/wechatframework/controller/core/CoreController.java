package com.itfvck.wechatframework.controller.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.web.service.WechatWebService;

/**
 * 微信消息接收与返回控制器
 * 
 * @author vcdemon
 *
 */
@Controller
public class CoreController {
	private static Logger logger = LoggerFactory.getLogger(CoreController.class);

	/**
	 * 默认公众号消息批量处理工具@com.itfvck.wechatframework.web.service.impl.WechatServiceTemplate
	 */
	@Autowired
	private WechatWebService wechatWebService;

	/**
	 * 微信公众号接入URL验证，可以处理多公众号,允许消息加解密方式为 安全模式
	 * 
	 * @param request
	 * @param response
	 * @param params
	 */
	@RequestMapping(value = { "wechat/dispacther" }, method = { RequestMethod.GET })
	public void validateWechatUrl(HttpServletRequest request, HttpServletResponse response, WechatParam params) {
		logger.info("GET params：" + params.toString());
		PrintWriter out = null;
		try {
			out = response.getWriter();
			BaseParams baseParams = new BaseParams();
			baseParams.setGhId("gh_f43460b9c5c3");
			baseParams.setAppId("wx44d483e10bee9fc1");
			baseParams.setAppSecret("353df047c6100ad4922e08f150306bbe");
			baseParams.setToken("123456");
			baseParams.setEncodingAESKey("");

			BaseParams baseParams2 = new BaseParams();
			baseParams2.setGhId("a");
			baseParams2.setAppId("b");
			baseParams2.setAppSecret("c ");
			baseParams2.setToken("123456");
			baseParams2.setEncodingAESKey("d");

			List<BaseParams> baseParamList = new ArrayList<BaseParams>();
			baseParamList.add(baseParams);
			baseParamList.add(baseParams2);

			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (wechatWebService.check(params, baseParamList)) {
				out.print(params.getEchostr());
			} else {
				out.print("params=" + params.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("微信公众号接入URL验证错误", e);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
			out = null;
		}
	}

	/**
	 * 处理微信公众号的消息与返回，可以处理多公众号,允许消息加解密方式为 安全模式
	 * 
	 * @param request
	 * @param response
	 * @param params
	 */
	@RequestMapping(value = { "wechat/dispacther" }, method = { RequestMethod.POST })
	public void dealWechatMsg(HttpServletRequest request, HttpServletResponse response, WechatParam params) {
		logger.info("POST params：" + params.toString());
		PrintWriter out = null;
		String xml = null;
		try {
			out = response.getWriter();
			// 调用核心服务类接收处理请求
			BaseParams baseParams = new BaseParams();
			baseParams.setGhId("gh_f43460b9c5c3");
			baseParams.setAppId("wx44d483e10bee9fc1");
			baseParams.setAppSecret("353df047c6100ad4922e08f150306bbe");
			baseParams.setToken("123456");

			BaseParams baseParams2 = new BaseParams();
			baseParams2.setGhId("a");
			baseParams2.setAppId("b");
			baseParams2.setAppSecret("c ");
			baseParams2.setToken("123456");
			baseParams2.setEncodingAESKey("d");

			List<BaseParams> baseParamList = new ArrayList<BaseParams>();
			baseParamList.add(baseParams);
			baseParamList.add(baseParams2);
			// 批量处理请求与返回消息
			xml = wechatWebService.getResponse(request, response, params, baseParamList);
			out.print(xml);
		} catch (Exception e) {
			e.printStackTrace();
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

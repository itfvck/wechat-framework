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

@Controller
public class CoreController {
	private static Logger logger = LoggerFactory.getLogger(CoreController.class);

	@Autowired
	private WechatWebService wechatWebService;

	@RequestMapping(value = { "wechat/dispacther" }, method = { RequestMethod.GET })
	public void get(HttpServletRequest request, HttpServletResponse response, WechatParam params) {
		logger.info("GET params：" + params.toString());
		PrintWriter out = null;
		try {
			out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			BaseParams baseParams = new BaseParams();
			baseParams.setAppId("wx44d483e10bee9fc1");
			baseParams.setAppSecret("353df047c6100ad4922e08f150306bbe");
			baseParams.setToken("123456");
			baseParams.setEncodingAESKey("");

			List<BaseParams> baseParamList = new ArrayList<BaseParams>();
			baseParamList.add(baseParams);

			if (wechatWebService.check(params, baseParamList)) {
				out.print(params.getEchostr());
			} else {
				out.print("params=" + params.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("IOException错误", e);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
			out = null;
		}
	}

	@RequestMapping(value = { "wechat/dispacther" }, method = { RequestMethod.POST })
	public void test(HttpServletRequest request, HttpServletResponse response, WechatParam params) {
		logger.info("POST params：" + params.toString());
		PrintWriter out = null;
		String xml = null;
		try {
			out = response.getWriter();
			// 调用核心服务类接收处理请求
			BaseParams baseParams = new BaseParams();
			baseParams.setAppId("wx44d483e10bee9fc1");
			baseParams.setAppSecret("353df047c6100ad4922e08f150306bbe");
			baseParams.setToken("123456");

			List<BaseParams> baseParamList = new ArrayList<BaseParams>();
			baseParamList.add(baseParams);
			xml = wechatWebService.getResponse(request, response, params, baseParamList);
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

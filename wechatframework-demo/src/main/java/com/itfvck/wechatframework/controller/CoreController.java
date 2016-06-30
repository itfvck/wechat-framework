package com.itfvck.wechatframework.controller;

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

			BaseParams baseParams3 = new BaseParams();
			baseParams3.setAppId("wx4012ae791c4fda09");
			baseParams3.setAppSecret("f95f6d616c40e38950e6e9e3f1bf4542");
			baseParams3.setToken("123456");
			baseParams3.setEncodingAESKey("jKNpnswdPlP7FlQbRqTjoJadIpptYhz46wZpVHF5Rjy");

			BaseParams baseParams2 = new BaseParams();
			baseParams2.setAppId("wx2029edf82462dc9f");
			baseParams2.setAppSecret("d10416a2e668b3d372c959a183bd7269");
			baseParams2.setToken("123456");
			
			
			List<BaseParams> baseParamList = new ArrayList<BaseParams>();
			baseParamList.add(baseParams);
			baseParamList.add(baseParams2);
			baseParamList.add(baseParams3);

			if (wechatWebService.check(params, baseParamList)) {
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

			BaseParams baseParams3 = new BaseParams();
			baseParams3.setAppId("wx4012ae791c4fda09");
			baseParams3.setAppSecret("f95f6d616c40e38950e6e9e3f1bf4542");
			baseParams3.setToken("123456");
			baseParams3.setEncodingAESKey("jKNpnswdPlP7FlQbRqTjoJadIpptYhz46wZpVHF5Rjy");

			BaseParams baseParams2 = new BaseParams();
			baseParams2.setAppId("wx2029edf82462dc9f");
			baseParams2.setAppSecret("d10416a2e668b3d372c959a183bd7269");
			baseParams2.setToken("123456");
			
			
			List<BaseParams> baseParamList = new ArrayList<BaseParams>();
			baseParamList.add(baseParams);
			baseParamList.add(baseParams2);
			baseParamList.add(baseParams3);
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

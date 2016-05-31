wechat-framework
===
wechat-framework简介
---
wechat-framework是一个帮助开发者简化开发微信公众号的一套轻量级的应用框架。目前已经将应用与微信服务器之间的消息接收与返回完全封装完成：接收到的消息封装成WechatRequest对象，返回的消息封装成WechatResponse对象，微信公众号的消息加解密方式可以任选，安全模式的加解密同样不需要开发者操心，开发者完全不用关注太细节的问题，开发者只需要关注业务代码。
wechat-framework主要构成部分
---
>* wechat-core：

>wechat-framework核心组件，该组件封装有微信接入验证工具、消息接收与返回服务、消息处理中心、access_token管理、jsapi_token管理、http(https)工具、安全模式加解密等核心功能。

>* wechat-api：

>wechat-framework的API交互组件，该组件封装与微信服务器做api请求交互的功能。该组件依赖wechat-core组件。

>* wechat-web：

>wechat-framework提供的轻量级web组件，该组件已经封装好一个默认的微信服务器消息入口，以及提供一个默认的消息处理器.该组件是一个简易的Servlet组件。开发者也可以采用其他web框架，只要提供微信服务器消息入口即可。

---------
wechat-framework 快速入门
---
wechat-framework源码中提供示例wechatframework-demo工程，该demo为一个SpringMVC搭建好的可运行的maven项目，可在其基础之上修改即可，其中wechat-framework在web.xml中的重要的配置均有说明。如果你要自己搭建，那么请按照如下步骤进行。
* 注：以下项目指标准maven结构的项目

### 第一步：
* 创建一个web工程，导入jdk和wechat-framework的jar包。可以使用已经打包编译好的jar包,下载地址[wechat-framework](https://github.com/vcdemon/wechat-framework/releases)
创建wechat4j配置文件，命名为“wechat4j.properties”，在src/java/resources目录下（即classpath路径下）。你可以在wechat-core.jar包的根目录下找到wechat4j.properties.sample文件，复制到src/java/resources目录下修改名称即可。wechat4j.properties配置文件的配置项意义参见[wechat4j配置文件解读](https://github.com/sword-org/wechat4j/wiki/wechat4j%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E8%A7%A3%E8%AF%BB)。主要参数内容如下：
```Java
#公众号的Token(令牌)
wechat.token=token
#公众号的AppID(应用ID)
wechat.appid=appid
#公众号的AppSecret(应用密钥)
wechat.appsecret=secret
#公众号的EncodingAESKey(消息加解密密钥)
wechat.encodingaeskey=encodingaeskey
```
wechat4j.properties配置文件的详细配置项意义参见wechat4j配置文件解读

### 第二步：
* 配置web.xml
  * 1 配置access_token、jsapi_token定时刷新的监听器
  ```java
  <!-- token定时刷新监听器 -->
	<listener>
		<listener-class>com.itfvck.wechatframework.core.token.TokenListener</listener-class>
	</listener>
  ```
  * 2 配置消息接收入口Servlet

```java
<servlet>
	<servlet-name>WechatframeworkServlet</servlet-name>
	<!-- 用户可自定义消息请求入口，不一定要采用Servlet的访问路径，例如可以在SpringMVC的Controller中配置访问入口，只要将WechatDefaultDispatcherServlet中的doGet和doPost的方法移植出来即可。 -->
	<servlet-class>com.itfvck.wechatframework.web.servlet.WechatDefaultDispatcherServlet</servlet-class>
	<!-- 用户可自定义消息处理中心MyService extends WechatSupport 即可，然后将此类配置在init-param中，参数名必须为wechatService。如果使用spring，则可以将MyService交给spring注入。此处若不配置，则会采用默认的示例消息处理中心WechatDefaultService -->
	<!-- <init-param> -->
	<!-- <param-name>wechatService</param-name> -->
	<!-- <param-value>com.itfvck.wechatframework.service.MyService</param-value> -->
	<!-- </init-param> -->
	<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
		<servlet-name>WechatframeworkServlet</servlet-name>
		<url-pattern>/wechat/dispacther</url-pattern>
</servlet-mapping>
```
该配置文件在wechatframework-demo项目中

#### 第三步：
* 重写消息处理器WechatSupport

```java
package com.itfvck.wechatframework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.common.MsgType;
import com.itfvck.wechatframework.core.msg.Image;
import com.itfvck.wechatframework.core.requestMsg.WechatRequest;
import com.itfvck.wechatframework.core.responseMsg.WechatResponse;
import com.itfvck.wechatframework.core.support.WechatSupport;

/**
 * 用户自定义消息处理中心，若要该类起作用，则需配置在wem.xml中
 *
 * @author
 *
 */
public class MyService extends WechatSupport {
    static Logger logger = LoggerFactory.getLogger(MyService.class);

    /**
     * 文本消息处理Msgtype=text
     *
     * @param wechatRequest
     *            请求对象
     * @return
     * @throws Exception
     */
    @Override
    protected String onText(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        if (wechatRequest.getContent().indexOf("收到不支持的消息类型") > 0) {
            xml = onUnknown(wechatRequest);
        } else {
            logger.info("wechatRequest：", wechatRequest.toString());
            String content = wechatRequest.getContent().trim();
            // TODO 这里写具体的业务

            // 返回的消息对象，任何返回消息都构造为WechatResponse
            WechatResponse wechatResponse = new WechatResponse();
            wechatResponse.setContent("文本回复：" + content);
            wechatResponse.setMsgType(MsgType.text.name());
            // 消息对象构造完成之后，调用formatWechatResponse方法即可
            // formatWechatResponse方法会自动对ToUserName，FromUserName，CreateTime赋值
            xml = formatWechatResponse(wechatRequest, wechatResponse);

            logger.info("WechatResponse：", wechatResponse.toString());
            logger.info("onText Xml：", xml);
        }
        return xml;
    }

    /**
     * 图片消息处理Msgtype=image
     *
     * @param wechatRequest
     * @return
     * @throws Exception
     */
    @Override
    protected String onImage(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        logger.info("wechatRequest：", wechatRequest.toString());
        WechatResponse wechatResponse = new WechatResponse();
        wechatResponse.setMsgType(MsgType.image.name());
        wechatResponse.setImage(new Image(wechatRequest.getMediaId()));
        xml = formatWechatResponse(wechatRequest, wechatResponse);
        logger.info("WechatResponse：", wechatResponse.toString());
        logger.info("onImage Xml：", xml);
        return xml;
    }

}
```

上面代码中的``onText()``是WechatSupport的父类消息转发器WechatDispatcher中的抽象方法，需要你自己的类来实现，表示对文本消息的处理，示例中是接收到用户的消息之后，返回给用户“文本回复：原句返回”文本消息。
``onImage()``则是示例原图返回的消息。

## 如何得到微信的请求参数
继承了``WechatSupport``类之后，你可以通过``wechatRequest.getFromUserName()``类似的方法来得到微信服务器请求的参数。详细信息请阅读[微信请求参数](https://github.com/sword-org/wechat4j/wiki/%E5%BE%97%E5%88%B0%E5%BE%AE%E4%BF%A1%E8%AF%B7%E6%B1%82%E5%8F%82%E6%95%B0)
## 如何设置响应参数
继承了``WechatSupport``类之后，你可以通过``wechatResponse.setFromUserName(fromUser)``类似的方法来设置给微信服务器的响应参数。详细信息请阅读[响应微信服务器参数](https://github.com/sword-org/wechat4j/wiki/%E8%AE%BE%E7%BD%AE%E5%93%8D%E5%BA%94%E5%BE%AE%E4%BF%A1%E5%8F%82%E6%95%B0)
## 如何响应用户信息
以文本信息为例，响应文本信息只需要在你的``onText``方法中使用``formatWechatResponse(wechatRequest, wechatResponse)``即可（参见上面的代码例子）

## wechatframework示例项目
* [wechatframework](https://github.com/vcdemon/wechat-framework/)

如果你有好的demo项目，请邮件或者修改本文件然后pull request给我，我会列在上面。

## 技术支持
* it技术交流QQ群 <br>
IT求职招聘总群：**286548895**<br>
深圳Java求职招聘②：**533192504**<br>
深圳PHP求职招聘： **46528911**<br>
深圳.NET求职招聘: **33258730**<br>
深圳安卓求职招聘: **210321987**<br>
深圳同城程序员 **523101596**
* 支持邮件 **345280563@qq.com**


## 贡献代码

1. 如果你觉得本项目不错，希望你能够点击一下右上角的star
2. 如果你希望参与改进本项目，那么请点击右上角的fork，修改之后pull request即可。如果你的贡献不错，你就会收到加入[wechatframework](https://github.com/vcdemon/wechat-framework)开源社区的邀请。
3. 如果你发现了一个bug，请你创建一个issue来报告。
非常非常欢迎你能够参与本项目的建设，每人做出一点点贡献，对整个项目来说就是一个非常大的贡献，希望集合众人的力量，让项目走的更好，能够为更多的人服务。

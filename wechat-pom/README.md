Project Encoding:UTF-8

1、wechat-framework

wechat-framework是一个帮助开发者简化开发微信公众号的一套轻量级的Java应用框架。目前已经将应用与微信服务器之间的消息接收与返回完全封装完成：接收到的消息封装成WechatRequest对象，返回的消息封装成WechatResponse对象，微信公众号的消息加解密方式可以任选，安全模式的加解密同样不需要开发者操心，开发者完全不用关注太细节的问题，开发者只需要关注业务代码。

2、作者 
vcdemon(345280563@qq.com)
it技术交流QQ群 286548895

3、wechat-framework主要构成部分

wechat-core：
wechat-framework核心组件，该组件封装有微信接入验证工具、消息接收与返回服务、消息处理中心、http(https)工具、安全模式加解密等核心功能。

wechat-api：
wechat-framework的API交互组件，该组件封装与微信服务器做api请求交互的功能。该组件依赖wechat-core组件。

wechat-web：
wechat-framework提供的轻量级web组件，该组件已经封装好一个默认的微信服务器消息入口，以及提供一个默认的消息处理器.该组件是一个简易的Servlet组件。开发者也可以采用其他web框架，只要提供微信服务器消息入口即可。

wechatframework-demo：
wechat-framework提供的示例程序，代码完整，可以无误跑通。
	示例中提供了token管理机制的实现示例代码。
	示例中提供了com.itfvck.wechatframework.controller.core.CoreController类作为入口与微信服务器的完整对接与消息接收和返回的代码。支持多公众号的对接。
	示例中提供了com.itfvck.wechatframework.controller.core.ValidateController类与微信JS-SDK对接的完整代码，相应的前端处理代码，请看webapp/js/weixin-common.js
	示例中提供了com.itfvck.wechatframework.controller.IndexController类做了一个简单的微信OAuth2网页授权回调进入第三方网页，从而获取微信用户信息的完整的使用示例。

wechatframework-admin：
wechat-framework提供的微信公众号后台管理系统，目标是一个管理后台能够管理多个公众号。


4、更多资料

https://github.com/vcdemon/wechat-framework
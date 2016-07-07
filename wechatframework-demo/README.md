Project Encoding:UTF-8

1、wechatframework-demo

wechat-framework提供的示例程序，代码完整，可以无误跑通。

wechatframework-demo由springMVC架构搭建。

示例中提供了token管理机制的实现示例代码。
	提供token管理接口TokenProxy。默认实现有两种token管理方式：
	
com.itfvck.wechatframework.token.impl.TokenProxyDefault
	TokenProxyDefault是将token保存在内存中，适合单机部署，通常作为开发使用。为了便于开发，demo集成进quartz作为定时器，开发者可以自己在定时器TimerTask中测试相关代码。
	
com.itfvck.wechatframework.token.impl.TokenProxyRedis
	TokenProxyRedis是将token保存在redis中，jedis和springMVC的集成已经搭建完成，redis的相关参数可以在redis.properties中配置.
	开发者可自定义token管理方式，实现类继承AbstractTokenProxy即可。
	
	示例中提供了com.itfvck.wechatframework.controller.core.CoreController类作为入口与微信服务器的完整对接与消息接收和返回的代码。支持多公众号的对接。
	
	示例中提供了com.itfvck.wechatframework.controller.core.ValidateController类与微信JS-SDK对接的完整代码，相应的前端处理代码，请看webapp/js/weixin-common.js
	
	示例中提供了com.itfvck.wechatframework.controller.IndexController类做了一个简单的微信OAuth2网页授权回调进入第三方网页，从而获取微信用户信息的完整的使用示例。

2、作者 
vcdemon(345280563@qq.com)
it技术交流QQ群 286548895

3、更多资料

https://github.com/vcdemon/wechat-framework
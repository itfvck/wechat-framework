Project Encoding:UTF-8

1、wechat-core

wechat-framework核心组件，该组件封装有微信接入验证工具com.itfvck.wechatframework.core.util.SignatureUtil、
消息接收与返回服务、消息处理中心com.itfvck.wechatframework.core.support.WechatDispatcher、http(https)工具、
安全模式加解密等核心功能。
消息处理类：com.itfvck.wechatframework.core.support.WechatSupport
开发者只需要自己定义类继承WechatSupport类，然后重写各个消息处理方法就可以实现定制开发。
例如接收到的文本消息处理方法：

@Override
protected String onText(WechatRequest wechatRequest) throws Exception;

com.itfvck.wechatframework.core.requestMsg.WechatRequest是微信服务器发送过来的XML消息解析之后封装成的对象，对象内已经包含有所有的消息属性。
与此对应的是com.itfvck.wechatframework.core.responseMsg.WechatResponse类，该类为需要返回的消息封装。
具体使用代码，请参照com.itfvck.wechatframework.core.support.WechatSupport类中的示例代码。

2、作者 
vcdemon(345280563@qq.com)
it技术交流QQ群 286548895

3、更多资料

https://github.com/vcdemon/wechat-framework
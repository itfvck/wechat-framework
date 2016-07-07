Project Encoding:UTF-8

1、wechat-api

现在微信越来越火，基于微信的公众号和服务号越来越丰富，虽然微信帮助文档已经提供了相关的接口，但是接口比较多，通过代码自己调用比较麻烦，所以为减轻开发者独自创造轮子，将微信API进行了统一封装！

2、作者 
vcdemon(345280563@qq.com)
it技术交流QQ群 286548895

3、快速使用方法：
为方便查找与调用,API类进行统一命名，以Wx字母开头，以API字母结尾.例如：WxAccessTokenAPI。
所有获取微信接口的方法都是静态方法，可以通过传递参数调用，API的包基本与微信开发者文档目录对应，通过英语单据，如参数有疑问，可以对照微信开发者帮助文档进行理解。
调用方式,例如获取微信access_token:
String token=WxAccessTokenAPI.getAccess_token(String appid, String appsecret);

4、更多资料

https://github.com/vcdemon/wechat-framework

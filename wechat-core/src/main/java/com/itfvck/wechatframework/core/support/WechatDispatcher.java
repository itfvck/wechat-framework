package com.itfvck.wechatframework.core.support;

import javax.servlet.http.HttpServletRequest;

import com.itfvck.wechatframework.core.common.EventType;
import com.itfvck.wechatframework.core.common.MsgType;
import com.itfvck.wechatframework.core.common.WechatCommonConst;
import com.itfvck.wechatframework.core.common.WechatConfig;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.mp.WXBizMsgCrypt;
import com.itfvck.wechatframework.core.requestMsg.WechatRequest;
import com.itfvck.wechatframework.core.responseMsg.WechatResponse;
import com.itfvck.wechatframework.core.util.XmlHelper;

/**
 * 微信服务器与用户消息转发控制中心
 * 
 * @author
 *
 */
abstract class WechatDispatcher {

    /**
     * 微信服务器消息入口
     * 
     * @param request
     * @param conf
     * @param params
     * @return 返回处理后的消息
     * @throws Exception
     */
    public String service(HttpServletRequest request, WechatConfig conf, WechatParam params) throws Exception {
        WechatRequest wechatRequest = XmlHelper.toObj(XmlHelper.parseXml(request, conf, params));
        String xml = null;
        // 消息类型
        switch (MsgType.valueOf(wechatRequest.getMsgType())) {
        case event:
            xml = dispatchEvent(wechatRequest);
            break;
        default:
            xml = dispatchMessage(wechatRequest);
            break;
        }
        // 加密
        return WechatCommonConst.AES.getValue().equals(params.getEncrypt_type()) ? new WXBizMsgCrypt(conf).encryptMsg(xml, params) : xml;
    }

    /**
     * 普通消息分发中心
     * 
     * @param wechatRequest
     * @return
     * @throws Exception
     */
    private String dispatchMessage(WechatRequest wechatRequest) throws Exception {
        // 消息类型
        MsgType msgType = MsgType.valueOf(wechatRequest.getMsgType());
        String msgResponse = null;
        switch (msgType) {
        case text:
            msgResponse = onText(wechatRequest);
            break;
        case image:
            msgResponse = onImage(wechatRequest);
            break;
        case voice:
            msgResponse = onVoice(wechatRequest);
            break;
        case video:
            msgResponse = onVideo(wechatRequest);
            break;
        case shortvideo:
            msgResponse = onShortVideo(wechatRequest);
            break;
        case location:
            msgResponse = onLocation(wechatRequest);
            break;
        case link:
            msgResponse = onLink(wechatRequest);
            break;
        default:
            msgResponse = onUnknown(wechatRequest);
            break;
        }
        return msgResponse;
    }

    /**
     * 事件消息分发中心
     * 
     * @param wechatRequest
     * @return
     * @throws Exception
     */
    private String dispatchEvent(WechatRequest wechatRequest) throws Exception {
        // 事件推送
        // 事件类型
        EventType eventType = EventType.valueOf(wechatRequest.getEvent());
        String msgResponse = null;
        switch (eventType) {
        case CLICK:
            msgResponse = click(wechatRequest);
            break;
        case subscribe:
            msgResponse = subscribe(wechatRequest);
            break;
        case unsubscribe:
            msgResponse = unSubscribe(wechatRequest);
            break;
        case SCAN:
            msgResponse = scan(wechatRequest);
            break;
        case LOCATION:
            msgResponse = location(wechatRequest);
            break;
        case VIEW:
            msgResponse = view(wechatRequest);
            break;
        case TEMPLATESENDJOBFINISH:
            msgResponse = templateMsgCallback(wechatRequest);
            break;
        case scancode_push:
            msgResponse = scanCodePush(wechatRequest);
            break;
        case scancode_waitmsg:
            msgResponse = scanCodeWaitMsg(wechatRequest);
            break;
        case pic_sysphoto:
            msgResponse = picSysPhoto(wechatRequest);
            break;
        case pic_photo_or_album:
            msgResponse = picPhotoOrAlbum(wechatRequest);
            break;
        case pic_weixin:
            msgResponse = picWeixin(wechatRequest);
            break;
        case location_select:
            msgResponse = locationSelect(wechatRequest);
            break;
        case kf_create_session:
            msgResponse = kfCreateSession(wechatRequest);
            break;
        case kf_close_session:
            msgResponse = kfCloseSession(wechatRequest);
            break;
        case kf_switch_session:
            msgResponse = kfSwitchSession(wechatRequest);
            break;
        default:
            msgResponse = onUnknown(wechatRequest);
            break;
        }
        return msgResponse;
    }

    /**
     * 将返回消息对象格式化为微信服务器所需要的XML格式字符串
     * 
     * @param wechatRequest
     * @param wechatResponse
     * @return
     */
    protected String getWechatResponse(WechatRequest wechatRequest, WechatResponse wechatResponse) {
        return XmlHelper.toXML(setWechatResponseBase(wechatRequest, wechatResponse));
    }

    /**
     * 设置返回消息对象的基础数据
     * 
     * @param wechatRequest
     * @param response
     * @return
     */
    private WechatResponse setWechatResponseBase(WechatRequest wechatRequest, WechatResponse response) {
        // 发送方帐号, 公告号将要向该号发送回复消息
        // 开发者微信帐号
        response.setToUserName(wechatRequest.getFromUserName());
        response.setFromUserName(wechatRequest.getToUserName());
        response.setCreateTime(System.currentTimeMillis());
        return response;
    }

    /**
     * 文本消息处理Msgtype=text
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     * @throws Exception
     */
    protected abstract String onText(WechatRequest wechatRequest) throws Exception;

    /**
     * 图像消息Msgtype=image
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String onImage(WechatRequest wechatRequest) throws Exception;

    /**
     * 语音消息 Msgtype=voice
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String onVoice(WechatRequest wechatRequest) throws Exception;

    /**
     * 视频 消息Msgtype=video
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String onVideo(WechatRequest wechatRequest) throws Exception;

    /**
     * 小视频 消息Msgtype=shortvideo
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String onShortVideo(WechatRequest wechatRequest) throws Exception;

    /**
     * 地理位置消息Msgtype=location
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String onLocation(WechatRequest wechatRequest) throws Exception;

    /**
     * 链接消息Msgtype=link
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String onLink(WechatRequest wechatRequest) throws Exception;

    /**
     * 未知消息类型的错误处理逻辑，不需要处理则空方法即可
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String onUnknown(WechatRequest wechatRequest) throws Exception;

    /**
     * click点击事件处理event=location
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String click(WechatRequest wechatRequest) throws Exception;

    /**
     * subscribe关注事件处理
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String subscribe(WechatRequest wechatRequest) throws Exception;

    /**
     * unSubscribe取消关注事件处理
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String unSubscribe(WechatRequest wechatRequest) throws Exception;

    /**
     * scan事件处理
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String scan(WechatRequest wechatRequest) throws Exception;

    /**
     * location事件处理event=location
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String location(WechatRequest wechatRequest) throws Exception;

    /**
     * view 事件处理event=location
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String view(WechatRequest wechatRequest) throws Exception;

    /**
     * 模板消息发送回调
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String templateMsgCallback(WechatRequest wechatRequest) throws Exception;

    /**
     * 扫码推事件
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String scanCodePush(WechatRequest wechatRequest) throws Exception;

    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String scanCodeWaitMsg(WechatRequest wechatRequest) throws Exception;

    /**
     * 弹出系统拍照发图的事件
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String picSysPhoto(WechatRequest wechatRequest) throws Exception;

    /**
     * 弹出拍照或者相册发图的事件
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String picPhotoOrAlbum(WechatRequest wechatRequest) throws Exception;

    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String picWeixin(WechatRequest wechatRequest) throws Exception;

    /**
     * 弹出地理位置选择器的事件
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String locationSelect(WechatRequest wechatRequest) throws Exception;

    /**
     * 客服人员有接入会话
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String kfCreateSession(WechatRequest wechatRequest) throws Exception;

    /**
     * 客服人员有关闭会话
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String kfCloseSession(WechatRequest wechatRequest) throws Exception;

    /**
     * 客服人员有转接会话
     * 
     * @param params
     * @param baseConf
     * @param requestMap
     */
    protected abstract String kfSwitchSession(WechatRequest wechatRequest) throws Exception;
}

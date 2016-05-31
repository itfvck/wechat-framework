package com.itfvck.wechatframework.core.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.common.MsgType;
import com.itfvck.wechatframework.core.msg.Image;
import com.itfvck.wechatframework.core.msg.Voice;
import com.itfvck.wechatframework.core.requestMsg.WechatRequest;
import com.itfvck.wechatframework.core.responseMsg.WechatResponse;

/**
 * 微信消息处理中心，用户可继承该类以便实现业务定制
 * 
 * @author
 *
 */
public abstract class WechatSupport extends WechatDispatcher {
    static Logger logger = LoggerFactory.getLogger(WechatSupport.class);

    @Override
    protected String onText(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        if (wechatRequest.getContent().indexOf("收到不支持的消息类型") > 0) {
            xml = onUnknown(wechatRequest);
        } else {
            logger.info("wechatRequest：", wechatRequest.toString());
            String content = wechatRequest.getContent().trim();
            WechatResponse wechatResponse = new WechatResponse();
            wechatResponse.setContent("文本回复：" + content);
            wechatResponse.setMsgType(MsgType.text.name());
            xml = formatWechatResponse(wechatRequest, wechatResponse);
            logger.info("WechatResponse：", wechatResponse.toString());
            logger.info("onText Xml：", xml);
        }
        return xml;
    }

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

    @Override
    protected String onVoice(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        logger.info("wechatRequest：", wechatRequest.toString());
        WechatResponse wechatResponse = new WechatResponse();
        wechatResponse.setMsgType(MsgType.voice.name());
        wechatResponse.setVoice(new Voice(wechatRequest.getMediaId()));
        xml = formatWechatResponse(wechatRequest, wechatResponse);
        logger.info("WechatResponse：", wechatResponse.toString());
        logger.info("onVoice Xml：", xml);
        return xml;
    }

    @Override
    protected String onVideo(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        logger.info("wechatRequest：", wechatRequest.toString());
        WechatResponse wechatResponse = new WechatResponse();
        wechatResponse.setContent("视频消息回复：" + wechatRequest.getMediaId() + "," + wechatRequest.getThumbMediaId());
        wechatResponse.setMsgType(MsgType.video.name());
        xml = formatWechatResponse(wechatRequest, wechatResponse);
        logger.info("WechatResponse：", wechatResponse.toString());
        logger.info("onVideo Xml：", xml);
        return xml;
    }

    @Override
    protected String onShortVideo(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        logger.info("wechatRequest：", wechatRequest.toString());
        WechatResponse wechatResponse = new WechatResponse();
        wechatResponse.setContent("小视频消息回复：" + wechatRequest.getMediaId() + "," + wechatRequest.getThumbMediaId());
        wechatResponse.setMsgType(MsgType.text.name());
        xml = formatWechatResponse(wechatRequest, wechatResponse);
        logger.info("WechatResponse：", wechatResponse.toString());
        logger.info("onShortVideo Xml：", xml);
        return xml;
    }

    @Override
    protected String onLocation(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        logger.info("wechatRequest：", wechatRequest.toString());
        WechatResponse wechatResponse = new WechatResponse();
        wechatResponse.setContent("地理位置消息回复：" + wechatRequest.getLabel());
        wechatResponse.setMsgType(MsgType.text.name());
        xml = formatWechatResponse(wechatRequest, wechatResponse);
        logger.info("WechatResponse：", wechatResponse.toString());
        logger.info("onLocation Xml：", xml);
        return xml;
    }

    @Override
    protected String onLink(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        logger.info("wechatRequest：", wechatRequest.toString());
        WechatResponse wechatResponse = new WechatResponse();
        wechatResponse.setContent("链接消息回复：" + String.format("<a href='%s'>%s</a>", wechatRequest.getUrl(), wechatRequest.getTitle()));
        wechatResponse.setMsgType(MsgType.text.name());
        xml = formatWechatResponse(wechatRequest, wechatResponse);
        logger.info("WechatResponse：", wechatResponse.toString());
        logger.info("onLocation Xml：", xml);
        return xml;
    }

    @Override
    protected String onUnknown(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        logger.info("wechatRequest：", wechatRequest.toString());
        WechatResponse wechatResponse = new WechatResponse();
        wechatResponse.setContent("未知消息回复：不知名消息,例如：聊天表情、个性名片、收藏、未知文件等");
        wechatResponse.setMsgType(MsgType.text.name());
        xml = formatWechatResponse(wechatRequest, wechatResponse);
        logger.info("WechatResponse：", wechatResponse.toString());
        logger.info("onUnknown Xml：", xml);
        return xml;
    }

    @Override
    protected String click(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String subscribe(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        logger.info("wechatRequest：", wechatRequest.toString());
        WechatResponse wechatResponse = new WechatResponse();
        wechatResponse.setContent("关注事件消息回复：欢迎关注");
        wechatResponse.setMsgType(MsgType.text.name());
        xml = formatWechatResponse(wechatRequest, wechatResponse);
        logger.info("WechatResponse：", wechatResponse.toString());
        logger.info("onLocation Xml：", xml);
        return xml;
    }

    @Override
    protected String unSubscribe(WechatRequest wechatRequest) throws Exception {
        String xml = null;
        logger.info("wechatRequest：", wechatRequest.toString());
        WechatResponse wechatResponse = new WechatResponse();
        wechatResponse.setContent("取消关注事件消息回复：取消关注");
        wechatResponse.setMsgType(MsgType.text.name());
        xml = formatWechatResponse(wechatRequest, wechatResponse);
        logger.info("WechatResponse：", wechatResponse.toString());
        logger.info("onLocation Xml：", xml);
        return xml;
    }

    @Override
    protected String scan(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String location(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String view(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String templateMsgCallback(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String scanCodePush(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String scanCodeWaitMsg(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String picSysPhoto(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String picPhotoOrAlbum(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String picWeixin(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String locationSelect(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String kfCreateSession(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String kfCloseSession(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String kfSwitchSession(WechatRequest wechatRequest) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}

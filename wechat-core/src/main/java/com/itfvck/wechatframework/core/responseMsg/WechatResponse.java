package com.itfvck.wechatframework.core.responseMsg;

import java.util.List;

import com.itfvck.wechatframework.core.msg.Article;
import com.itfvck.wechatframework.core.msg.Image;
import com.itfvck.wechatframework.core.msg.Music;
import com.itfvck.wechatframework.core.msg.Video;
import com.itfvck.wechatframework.core.msg.Voice;

public class WechatResponse {
    private String ToUserName;// 接收方帐号（收到的OpenID）
    private String FromUserName;// 开发者微信号
    private long CreateTime;// 消息创建时间戳 （整型）
    private String MsgType;// 消息类型text|image|语音，voice|video|music|news
    private String Content;// 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）

    private Image Image;// 回复 图片消息
    private Voice Voice;// 回复语音消息
    private Video Video;// 回复视频消息
    private Music Music;// 回复音乐消息

    private Integer ArticleCount;// 图文消息个数,限制在10条内
    private List<Article> Articles;
    private String KfAccount;// 指定会话接入的客服账号

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }

    public String getKfAccount() {
        return KfAccount;
    }

    public void setKfAccount(String kfAccount) {
        KfAccount = kfAccount;
    }

    @Override
    public String toString() {
        return "WechatResponse [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime + ", MsgType=" + MsgType + ", Content=" + Content
                + ", Image=" + Image + ", Voice=" + Voice + ", Video=" + Video + ", Music=" + Music + ", ArticleCount=" + ArticleCount + ", Articles=" + Articles + ", KfAccount="
                + KfAccount + "]";
    }

}

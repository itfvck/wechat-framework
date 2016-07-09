package com.itfvck.wechatframework.core.requestMsg;

import java.util.List;

public class WechatRequest {
	private String ToUserName;// 开发者微信号
	private String FromUserName;// 发送方帐号（一个OpenID）
	private String CreateTime;// 消息创建时间 （整型）
	private String MsgType;// 消息类型(text|image|location|link|voice|video|shortvideo|event)
	private String Event;// 事件类型，subscribe(订阅)、unsubscribe(取消订阅)|SCAN扫描带参数二维码事件|LOCATION上报地理位置事件|CLICK自定义菜单事件|VIEW
	private String EventKey;// 事件KEY值，qrscene_为前缀，后面为二维码的参数值|事件KEY值，与自定义菜单接口中KEY值对应|事件KEY值，设置的跳转URL
	private String MsgId;// 消息id，64位整型
	private String MenuId;// 菜单ID
	private String Content;// 文本消息内容
	private String Location_X;// 地理位置维度
	private String Location_Y;// 地理位置经度
	private String Scale;// 地图缩放大小
	private String Label;// 地理位置信息
	private String Title;// 消息标题
	private String Description;// 消息描述
	private String Url;// 消息链接
	private String PicUrl;// 图片链接（由系统生成）
	private String MediaId;// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String Format;// 语音格式，如amr，speex等
	private String Status;
	private String Latitude; // 上报地理位置事件Latitude地理位置纬度
	private String Longitude; // 上报地理位置事件Longitude地理位置经度
	private String Precision; // 上报地理位置事件Precision地理位置精度
	private String Ticket; // 扫描带参数二维码事件Ticket,可用来换取二维码图片
	private String ThumbMediaId; // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	private String ScanType; // 扫描类型，一般是qrcode
	private String ScanResult; // 扫描结果，即二维码对应的字符串信息
	private String Count;
	private List<Item> item;
	private String Poiname;
	private String Recognition;// 语音识别结果，UTF8编码
	private String Encrypt;// 消息加解密方式 安全模式 接收到的加密消息

	public String getEncrypt() {
		return Encrypt;
	}

	public void setEncrypt(String encrypt) {
		Encrypt = encrypt;
	}

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

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public String getScanType() {
		return ScanType;
	}

	public void setScanType(String scanType) {
		ScanType = scanType;
	}

	public String getScanResult() {
		return ScanResult;
	}

	public void setScanResult(String scanResult) {
		ScanResult = scanResult;
	}

	public String getCount() {
		return Count;
	}

	public void setCount(String count) {
		Count = count;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public String getPoiname() {
		return Poiname;
	}

	public void setPoiname(String poiname) {
		Poiname = poiname;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getMenuId() {
		return MenuId;
	}

	public void setMenuId(String menuId) {
		MenuId = menuId;
	}

	@Override
	public String toString() {
		return "WechatRequest [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime + ", MsgType=" + MsgType + ", Event=" + Event
		        + ", EventKey=" + EventKey + ", MsgId=" + MsgId + ", MenuId=" + MenuId + ", Content=" + Content + ", Location_X=" + Location_X + ", Location_Y=" + Location_Y
		        + ", Scale=" + Scale + ", Label=" + Label + ", Title=" + Title + ", Description=" + Description + ", Url=" + Url + ", PicUrl=" + PicUrl + ", MediaId=" + MediaId
		        + ", Format=" + Format + ", Status=" + Status + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Precision=" + Precision + ", Ticket=" + Ticket
		        + ", ThumbMediaId=" + ThumbMediaId + ", ScanType=" + ScanType + ", ScanResult=" + ScanResult + ", Count=" + Count + ", item=" + item + ", Poiname=" + Poiname
		        + ", Recognition=" + Recognition + "]";
	}

}

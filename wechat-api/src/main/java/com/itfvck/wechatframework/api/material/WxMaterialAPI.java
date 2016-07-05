package com.itfvck.wechatframework.api.material;

import java.io.File;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 素材管理
 * 
 * @author vcdemon
 *
 */
public class WxMaterialAPI {
	private static final String PARAM_FILE = "media";

	/**
	 * 新增临时素材<br>
	 * 正确情况下的返回JSON数据包结果如下：<br>
	 * {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
	 * 错误情况下的返回JSON数据包示例如下（示例为无效媒体类型错误）： <br>
	 * {"errcode":40004,"errmsg": "invalid media type"}
	 * 
	 * @param file
	 *            要上传的文件
	 * @param type
	 *            媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @return
	 * @author vcdemon
	 */
	public static String uploadTemp(File file, MediaType type, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";
		url = String.format(url, accsee_token, type.name());
		String result = HttpUtils.postFile(url, PARAM_FILE, file);
		MediaFile media = parseUploadResult(result);
		return media.getMedia_id();
	}

	/**
	 * 获取临时素材
	 * 
	 * @param mediaId
	 *            媒体文件ID
	 * @return
	 * @author vcdemon
	 */
	public static byte[] downloadTemp(String mediaId, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";
		url = String.format(url, accsee_token, mediaId);
		byte[] fb = HttpUtils.getFile(url);
		if (fb == null || fb.length == 0)
			return null;
		return fb;
	}

	/**
	 * 新增永久图文素材
	 * 
	 * @param ArticleMaterial
	 *            articles
	 * @see ArticleMaterial
	 * @return 返回的即为新增的图文消息素材的media_id。
	 * @author vcdemon
	 */
	public static String uploadNews(ArticleMaterial articles, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=%s";
		url = String.format(url, accsee_token);
		String result = HttpUtils.post(url, JSONObject.toJSONString(articles));
		MediaFile media = parseUploadResult(result);
		return media.getMedia_id();
	}

	/**
	 * 获取图文消息素材
	 * 
	 * @param mediaId
	 * @return { "news_item": [ { "title":TITLE,
	 *         "thumb_media_id"::THUMB_MEDIA_ID,
	 *         "show_cover_pic":SHOW_COVER_PIC(0/1), "author":AUTHOR,
	 *         "digest":DIGEST, "content":CONTENT, "url":URL,
	 *         "content_source_url":CONTENT_SOURCE_URL }, //多图文消息有多篇文章 ] }<br>
	 *         错误情况下的返回JSON数据包示例如下（示例为无效媒体类型错误）： <br>
	 *         {"errcode":40007,"errmsg": "invalid media_id"}
	 * @author vcdemon
	 */
	public static ArticleMaterial getNews(String mediaId, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s";
		url = String.format(url, accsee_token);
		String result = HttpUtils.post(url, JSONObject.toJSONString(new MediaFile().setMedia_id(mediaId)));
		ArticleMaterial material = JSON.parseObject(result, ArticleMaterial.class);
		return material;
	}

	/**
	 * 获取永久图文消息素材列表
	 * 
	 * @param media
	 *            { "type":news, "offset":OFFSET, "count":COUNT }
	 * @return 返回说明
	 * 
	 *         永久图文消息素材列表的响应如下：
	 * 
	 *         { "total_count": TOTAL_COUNT, "item_count": ITEM_COUNT, "item":
	 *         [{ "media_id": MEDIA_ID, "content": { "news_item": [{ "title":
	 *         TITLE, "thumb_media_id": THUMB_MEDIA_ID, "show_cover_pic":
	 *         SHOW_COVER_PIC(0 / 1), "author": AUTHOR, "digest": DIGEST,
	 *         "content": CONTENT, "url": URL, "content_source_url":
	 *         CONTETN_SOURCE_URL }, //多图文消息会在此处有多篇文章 ] }, "update_time":
	 *         UPDATE_TIME }, //可能有多个图文消息item结构 ] } <br>
	 *         错误情况下的返回JSON数据包示例如下（示例为无效媒体类型错误）：
	 * 
	 *         {"errcode":40007,"errmsg":"invalid media_id"}
	 * @author vcdemon
	 */
	public static ArticleMaterial getNewsList(MediaFile media, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=%s";
		url = String.format(url, accsee_token);
		media.setType(MediaType.news.name());
		String result = HttpUtils.post(url, JSONObject.toJSONString(media));
		ArticleMaterial material = JSON.parseObject(result, ArticleMaterial.class);
		return material;
	}

	/**
	 * 修改永久图文素材<br>
	 * 调用示例 { "media_id":MEDIA_ID, "index":INDEX, "articles": { "title": TITLE,
	 * "thumb_media_id": THUMB_MEDIA_ID, "author": AUTHOR, "digest": DIGEST,
	 * "show_cover_pic": SHOW_COVER_PIC(0 / 1), "content": CONTENT,
	 * "content_source_url": CONTENT_SOURCE_URL } }
	 * 
	 * @param article
	 * @return 返回说明
	 * 
	 *         { "errcode": ERRCODE, "errmsg": ERRMSG } 正确时errcode的值应为0。
	 * @author vcdemon
	 */
	public static MediaFile updateNews(ArticleMaterial article, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=%s";
		url = String.format(url, accsee_token);
		String result = HttpUtils.post(url, JSONObject.toJSONString(article));
		MediaFile media = parseUploadResult(result);
		return media;
	}

	/**
	 * 上传图文消息内的图片获取URL<br>
	 * 返回说明 正常情况下的返回结果为： <br>
	 * { "url": "http://mmbiz.qpic.cn/mmbiz/gLO17UPS6FS2xsypf378iaNhWacZ1Gfdgdf"
	 * }<br>
	 * 其中url就是上传图片的URL，可用于后续群发中，放置到图文消息中。
	 * 
	 * @param file
	 * @return url
	 * @author vcdemon
	 */
	public static String uploadNewsImg(File file, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s";
		url = String.format(url, accsee_token);
		String result = HttpUtils.postFile(url, PARAM_FILE, file);
		MediaFile media = parseUploadResult(result);
		return media.getUrl();
	}

	/**
	 * 新增永久Image素材
	 * 
	 * @param file
	 * @return MediaFile { "media_id":MEDIA_ID, "url":URL }
	 * @author vcdemon
	 */
	public static MediaFile uploadPermImage(File file, String accsee_token) {
		return uploadPerm(file, MediaType.image, accsee_token);
	}

	/**
	 * 新增永久Voice素材
	 * 
	 * @param file
	 * @return { "media_id":MEDIA_ID }
	 * @author vcdemon
	 */
	public static String uploadPermVoice(File file, String accsee_token) {
		MediaFile media = uploadPerm(file, MediaType.voice, accsee_token);
		return media.getMedia_id();
	}

	/**
	 * 新增永久Thumb素材
	 * 
	 * @param file
	 * @return { "media_id":MEDIA_ID }
	 * @author vcdemon
	 */
	public static String uploadPermThumb(File file, String accsee_token) {
		MediaFile media = uploadPerm(file, MediaType.thumb, accsee_token);
		return media.getMedia_id();
	}

	/**
	 * 新增永久Video素材
	 * 
	 * @param file
	 * @return { "media_id":MEDIA_ID }
	 * @author vcdemon
	 */
	public String uploadPermVideo(File file, String title, String introduction, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=%s&title=%s&introduction=%s";
		url = String.format(url, accsee_token, MediaType.video.name(), title, introduction);
		String result = HttpUtils.postFile(url, PARAM_FILE, file);
		MediaFile media = parseUploadResult(result);
		return media.getMedia_id();
	}

	/**
	 * 新增其他类型永久素材,分别有图片（image）、语音（voice）、和缩略图（thumb）
	 * 
	 * @param file
	 * @param type
	 *            媒体文件类型，分别有图片（image）、语音（voice）、和缩略图（thumb）
	 * @return MediaFile
	 */
	private static MediaFile uploadPerm(File file, MediaType type, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=%s";
		url = String.format(url, accsee_token, type.name());
		String result = HttpUtils.postFile(url, PARAM_FILE, file);
		MediaFile media = parseUploadResult(result);
		return media;
	}

	/**
	 * 获取其他类型（图片、语音、视频）列表, 素材的类型，图片（image）、视频（video）、语音 （voice）
	 * 
	 * @param media
	 *            { "type":TYPE, "offset":OFFSET, "count":COUNT }
	 * @return 其他类型（图片、语音、视频）的返回如下：
	 * 
	 *         { "total_count": TOTAL_COUNT, "item_count": ITEM_COUNT, "item":
	 *         [{ "media_id": MEDIA_ID, "name": NAME, "update_time":
	 *         UPDATE_TIME, "url":URL }, //可能会有多个素材 ] }<br>
	 *         错误情况下的返回JSON数据包示例如下（示例为无效媒体类型错误）：
	 * 
	 *         {"errcode":40007,"errmsg":"invalid media_id"}
	 * @author vcdemon
	 */
	public static MediaFile getPermMediaFileList(MediaFile media, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=%s";
		url = String.format(url, accsee_token);
		media.setType(MediaType.news.name());
		String result = HttpUtils.post(url, JSONObject.toJSONString(media));
		MediaFile material = JSON.parseObject(result, MediaFile.class);
		return material;
	}

	/**
	 * 获取视频消息素材
	 * 
	 * @param mediaId
	 * @return 如果返回的是视频消息素材，则内容如下： <br>
	 *         { "title":TITLE, "description":DESCRIPTION, "down_url":DOWN_URL,}
	 * @author vcdemon
	 */
	public static MediaFile getVedio(String mediaId, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s";
		url = String.format(url, accsee_token);
		String result = HttpUtils.post(url, JSONObject.toJSONString(new MediaFile().setMedia_id(mediaId)));
		MediaFile media = parseUploadResult(result);
		return media;
	}

	/**
	 * 获取素材总数
	 * 
	 * @return { "voice_count":COUNT, "video_count":COUNT, "image_count":COUNT,
	 *         "news_count":COUNT } <br>
	 *         错误情况下的返回JSON数据包示例如下（示例为无效媒体类型错误）： {"errcode":-1,"errmsg":
	 *         "system error"}
	 * @author vcdemon
	 */
	public static MediaFile getMaterialCount(String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=%s";
		url = String.format(url, accsee_token);
		String result = HttpUtils.get(url);
		MediaFile media = parseUploadResult(result);
		return media;
	}

	/**
	 * 下载永久Image素材
	 * 
	 * @param mediaId
	 * @return
	 * @author vcdemon
	 */
	public static byte[] downloadPermImage(String mediaId, String accsee_token) {
		return downloadPerm(mediaId, accsee_token);
	}

	/**
	 * 下载永久Voice素材
	 * 
	 * @param mediaId
	 * @return
	 * @author vcdemon
	 */
	public static byte[] downloadPermVoice(String mediaId, String accsee_token) {
		return downloadPerm(mediaId, accsee_token);
	}

	/**
	 * 下载永久Thumb素材
	 * 
	 * @param mediaId
	 * @return
	 * @author vcdemon
	 */
	public static byte[] downloadPermThumb(String mediaId, String accsee_token) {
		return downloadPerm(mediaId, accsee_token);
	}

	/**
	 * 获取其他类型的素材消息,分别有图片（image）、语音（voice）、和缩略图（thumb）
	 * 
	 * @param mediaId
	 * @return
	 */
	private static byte[] downloadPerm(String mediaId, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s&media_id=%s";
		url = String.format(url, accsee_token, mediaId);
		byte[] fb = HttpUtils.getFile(url);
		if (fb == null || fb.length == 0)
			return null;
		return fb;
	}

	/**
	 * 删除永久素材
	 * 
	 * @param mediaId
	 * @return 返回说明 { "errcode":ERRCODE, "errmsg":ERRMSG }
	 *         正常情况下调用成功时，errcode将为0。
	 * @author vcdemon
	 */
	public static MediaFile deletePermMaterial(String mediaId, String accsee_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=%s";
		url = String.format(url, accsee_token);
		String result = HttpUtils.post(url, JSONObject.toJSONString(new MediaFile().setMedia_id(mediaId)));
		MediaFile media = parseUploadResult(result);
		return media;
	}

	private static MediaFile parseUploadResult(String result) {
		MediaFile material = null;
		material = JSON.parseObject(result, MediaFile.class);
		return material;
	}

}

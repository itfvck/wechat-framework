package com.itfvck.wechatframework.api.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

public class UserManageAPI {
    /**
     * @Description 创建标签
     * @param tag
     *            传入Tag属性tag->name,access_token
     * @return
     * @CreationDate 2016年5月13日 下午2:28:02
     */
    public static Tag createTags(Tag tag) {
        String url = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=%s";
        url = String.format(url, tag.getAccess_token());
        try {
            String responseBody = HttpUtils.post(url, JSONObject.toJSONString(tag));
            tag = JSON.parseObject(responseBody, Tag.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }

    /**
     * @Description 获取公众号已创建的标签
     * @param tag
     *            传入access_token
     * @return
     * @CreationDate 2016年5月16日 上午10:03:27
     * @Author lidong(dli@gdeng.cn)
     */
    public static Tag getTags(Tag tag) {
        String url = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=%s";
        url = String.format(url, tag.getAccess_token());
        try {
            String responseBody = HttpUtils.get(url);
            tag = JSON.parseObject(responseBody, Tag.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }

    /**
     * @Description 修改标签
     * @param tag
     *            传入Tag属性tag->name,Tag属性tag->id,access_token
     * @return
     * @CreationDate 2016年5月16日 上午10:13:53
     * @Author lidong(dli@gdeng.cn)
     */
    public static Tag updateTags(Tag tag) {
        String url = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=%s";
        url = String.format(url, tag.getAccess_token());
        try {
            String responseBody = HttpUtils.post(url, JSONObject.toJSONString(tag));
            tag = JSON.parseObject(responseBody, Tag.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }

    /**
     * @Description 删除标签
     * @param tag
     *            传入Tag属性tag->id,access_token
     * @return
     * @CreationDate 2016年5月16日 上午10:20:00
     * @Author lidong(dli@gdeng.cn)
     */
    public static Tag deleteTags(Tag tag) {
        String url = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=%s";
        url = String.format(url, tag.getAccess_token());
        try {
            String responseBody = HttpUtils.post(url, JSONObject.toJSONString(tag));
            tag = JSON.parseObject(responseBody, Tag.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }

    /**
     * @Description 获取标签下粉丝列表
     * @param tag
     *            传入tagid,access_token,next_openid(第一个拉取的OPENID，不填默认从头开始拉取)
     * @return
     * @CreationDate 2016年5月16日 上午10:34:56
     * @Author lidong(dli@gdeng.cn)
     */
    public static Tag getTagUser(Tag tag) {
        String url = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=%s";
        url = String.format(url, tag.getAccess_token());
        try {
            String responseBody = HttpUtils.post(url, JSONObject.toJSONString(tag));
            tag = JSON.parseObject(responseBody, Tag.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }

    /**
     * @Description 获取用户身上的标签列表
     * @param tag
     *            传入openid,access_token
     * @return tagid_list
     * @CreationDate 2016年5月16日 上午10:42:14
     * @Author lidong(dli@gdeng.cn)
     */
    public static Tag getIdList(Tag tag) {
        String url = "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=%s";
        url = String.format(url, tag.getAccess_token());
        try {
            String responseBody = HttpUtils.post(url, JSONObject.toJSONString(tag));
            tag = JSON.parseObject(responseBody, Tag.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }

    /**
     * @Description 批量为用户打标签
     * @param tag
     *            传入tagid,openid_list,access_token
     * @return
     * @CreationDate 2016年5月16日 上午10:45:49
     * @Author lidong(dli@gdeng.cn)
     */
    public static Tag batchTagging(Tag tag) {
        String url = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=%s";
        url = String.format(url, tag.getAccess_token());
        try {
            String responseBody = HttpUtils.post(url, JSONObject.toJSONString(tag));
            tag = JSON.parseObject(responseBody, Tag.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }

    /**
     * @Description 批量为用户取消标签
     * @param tag
     *            传入tagid,openid_list,access_token
     * @return
     * @CreationDate 2016年5月16日 上午10:45:49
     * @Author lidong(dli@gdeng.cn)
     */
    public static Tag batchunTagging(Tag tag) {
        String url = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=%s";
        url = String.format(url, tag.getAccess_token());
        try {
            String responseBody = HttpUtils.post(url, JSONObject.toJSONString(tag));
            tag = JSON.parseObject(responseBody, Tag.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }

    /**
     * @Description 设置用户备注名
     * @param user
     *            传入remark,openid,access_token
     * @return
     * @CreationDate 2016年5月16日 上午11:43:20
     * @Author lidong(dli@gdeng.cn)
     */
    public static UserInfo updateRemark(UserInfo user) {
        String url = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=%s";
        url = String.format(url, user.getAccess_token());
        try {
            String responseBody = HttpUtils.post(url, JSONObject.toJSONString(user));
            user = JSON.parseObject(responseBody, UserInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * @Description 获取用户基本信息（包括UnionID机制）
     * @param user
     *            传入openid,access_token
     * @return
     * @CreationDate 2016年5月16日 上午11:36:52
     * @Author lidong(dli@gdeng.cn)
     */
    public static UserInfo getUserInfo(UserInfo user) {
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=%s";
        url = String.format(url, user.getAccess_token(), user.getOpenid(), user.getLanguage());
        try {
            String responseBody = HttpUtils.get(url);
            user = JSON.parseObject(responseBody, UserInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * @Description 批量获取用户基本信息 ,开发者可通过该接口来批量获取用户基本信息。最多支持一次拉取100条。
     * @param user
     *            传入access_token,user_list->openid列表
     * @return
     * @CreationDate 2016年5月16日 上午11:49:36
     * @Author lidong(dli@gdeng.cn)
     */
    public static UserData batchGetUserInfo(UserData user) {
        String url = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=%s";
        url = String.format(url, user.getAccess_token());
        try {
            String responseBody = HttpUtils.post(url, JSONObject.toJSONString(user));
            user = JSON.parseObject(responseBody, UserData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * @Description 获取用户列表
     * @param user
     *            传入access_token,next_openid(可以不传值，不可为null,否则报错,可为"")
     * @return
     * @CreationDate 2016年5月16日 下午12:18:00
     * @Author lidong(dli@gdeng.cn)
     */
    public static UserData getUserList(UserData user) {
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s&next_openid=%s";
        url = String.format(url, user.getAccess_token(), user.getNext_openid());
        try {
            String responseBody = HttpUtils.get(url);
            user = JSON.parseObject(responseBody, UserData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}

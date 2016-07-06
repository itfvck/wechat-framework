package com.itfvck.wechatframework.api.user.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * @Description 用户标签
 * @Project weixin-core
 * @ClassName Tag.java
 * @Author lidong(dli@gdeng.cn)
 * @CreationDate 2016年5月16日 上午9:19:12
 * @Version V2.0
 * @Copyright 谷登科技 2015-2016
 * @ModificationHistory
 */
public class Tag extends BaseData {

    private static final long serialVersionUID = 2530235101040923369L;

    private int id;// 标签id
    private String name;// 标签名
    private int count;// 此标签下粉丝数
    private Tag tag;// 创建标签,返回
    private List<Tag> tags;// 获取公众号已创建的标签
    private int tagid;// 标签id
    private String next_openid;// 第一个拉取的OPENID，不填默认从头开始拉取//拉取列表最后一个用户的openid
    private Data data;// 粉丝列表
    private List<String> openid_list;// 粉丝列表
    private List<Integer> tagid_list;// 被置上的标签列表

    public class Data {
        private List<String> openid;

        public List<String> getOpenid() {
            return openid;
        }

        public void setOpenid(List<String> openid) {
            this.openid = openid;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<String> getOpenid_list() {
        return openid_list;
    }

    public void setOpenid_list(List<String> openid_list) {
        this.openid_list = openid_list;
    }

    public List<Integer> getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(List<Integer> tagid_list) {
        this.tagid_list = tagid_list;
    }

    @Override
    public String toString() {
        return "Tag [id=" + id + ", name=" + name + ", count=" + count + ", tag=" + tag + ", tags=" + tags + ", tagid=" + tagid + ", next_openid=" + next_openid + ", data=" + data
                + ", openid_list=" + openid_list + ", tagid_list=" + tagid_list + "]";
    }

}

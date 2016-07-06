package com.itfvck.wechatframework.api.user.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class UserData extends BaseData {

    private static final long serialVersionUID = 1965604174963327182L;
    private List<UserInfo> user_list;//
    private List<UserInfo> user_info_list;//
    private int total;// 关注该公众账号的总用户数
    private int count;// 拉取的OPENID个数，最大值为10000
    private String next_openid="";// 拉取列表的最后一个用户的OPENID
    private Data data;// 列表数据，OPENID的列表

    public List<UserInfo> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<UserInfo> user_list) {
        this.user_list = user_list;
    }

    public List<UserInfo> getUser_info_list() {
        return user_info_list;
    }

    public void setUser_info_list(List<UserInfo> user_info_list) {
        this.user_info_list = user_info_list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public class Data {
        private List<String> openid;// 列表数据，OPENID的列表

        public List<String> getOpenid() {
            return openid;
        }

        public void setOpenid(List<String> openid) {
            this.openid = openid;
        }
    }
}

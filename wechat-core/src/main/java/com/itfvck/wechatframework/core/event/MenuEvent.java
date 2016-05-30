package com.itfvck.wechatframework.core.event;

/**
 * 自定义菜单事件
 */
public class MenuEvent extends BaseEvent {
    /**
     * 事件Key值,与自定义菜单接口中Key值对应
     */
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

}

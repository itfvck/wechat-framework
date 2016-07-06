package com.itfvck.wechatframework.api.menu;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

/**
 * 微信菜单
 * 
 * @author Zhangxs
 * @version 2015-7-4
 */
public class Menu extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1919219168096558969L;
	private List<MenuButton> button;

	public List<MenuButton> getButton() {
		return button;
	}

	public void setButton(List<MenuButton> button) {
		this.button = button;
	}

}

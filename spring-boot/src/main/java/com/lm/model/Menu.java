package com.lm.model;

import java.util.List;

/**
 * 菜单表
 * @author 刘阳
 * @version v1.0.1
 * <p>最后更新 by 刘阳  @ 2018年4月19日 </p>
 * @since v1.0.0
 */
public class Menu {
	private String id;
	private String text;
	private String icon;
	private String url;
	 // 子菜单
    private List<Menu> menus;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}

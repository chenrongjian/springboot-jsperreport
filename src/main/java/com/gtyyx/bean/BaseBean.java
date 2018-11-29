package com.gtyyx.bean;

import java.io.Serializable;

/**
 * @author: crj
 * @date: 2018年11月7日 下午3:37:25
 */
public class BaseBean {
	//ID
	private String id;
	// 名称
	private String name;
	// 类别
	private String lable;
	// 数值
	private long number;
	// 是否显示
	private boolean showFlag;
	
	public BaseBean() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public boolean isShowFlag() {
		return showFlag;
	}
	public void setShowFlag(boolean showFlag) {
		this.showFlag = showFlag;
	}
	

}

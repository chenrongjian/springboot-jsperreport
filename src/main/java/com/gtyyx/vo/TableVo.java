package com.gtyyx.vo;

import java.io.Serializable;

/**
 * @author: crj
 * @date: 2018年11月6日 下午4:34:15
 */
public class TableVo implements Serializable{
	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;
	// ID
	private String id;
	// 名称
	private String name;
	// 类别
	private String lable;
	// 数值
	private long number;
	// 是否显示
	private boolean showFlag;
	
	
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

package com.infosys.knowledge.model;

import java.util.Date;

public class FrameNotice {

	private Long id;
	
	private String name;
	
	private String caution;
	
	private String tag;
	
	private String categ;
	
	private Date gmt_create;
	
	private Date gmt_modify;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCateg() {
		return categ;
	}

	public void setCateg(String categ) {
		this.categ = categ;
	}

	public Date getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}

	public Date getGmt_modify() {
		return gmt_modify;
	}

	public void setGmt_modify(Date gmt_modify) {
		this.gmt_modify = gmt_modify;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof FrameNotice) || null == obj) {
			return false;
		}
		FrameNotice notice = (FrameNotice) obj;
		if(getId() == null || notice.getId() == null) {
			return false;
		}
		return getId().equals(notice.getId());
	}
}

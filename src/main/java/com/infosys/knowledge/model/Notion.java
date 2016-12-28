package com.infosys.knowledge.model;

import java.util.Date;

public class Notion {

	private Long id;
	
	private String label;
	
	private String explain;
	
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
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
		if(!(obj instanceof Notion) || null == obj) {
			return false;
		}
		Notion notion = (Notion) obj;
		if(getId() == null || notion.getId() == null) {
			return false;
		}
		return getId().equals(notion.getId());
	}
}

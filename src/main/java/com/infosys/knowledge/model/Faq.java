package com.infosys.knowledge.model;

import java.util.Date;

public class Faq {

	private Long id;
	
	private String question;
	
	private String answer;
	
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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
		if(!(obj instanceof Faq) || null == obj) {
			return false;
		}
		Faq faq = (Faq) obj;
		if(getId() == null || faq.getId() == null) {
			return false;
		}
		return getId().equals(faq.getId());
	}
}

package com.bsb.valise.helpSupport.model;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

public class HelpSupportDto implements Serializable {

	private static final long serialVersionUID = -7305437655994492288L;

	@Id
	@Field(SearchableItem.ID_FIELD)
	private String id;

	@Field(SearchableItem.LOB_FIELD)
	private String lob;

	@Field(SearchableItem.CAT_FIELD)
	private String cat;

	@Field(SearchableItem.CAT_IMAGE_URL_FIELD)
	private String catImageUrl;

	@Field(SearchableItem.SUB_CAT_FIELD)
	private String subCategory;

	@Field(SearchableItem.QUESTION_FIELD)
	private String question;

	@Field(SearchableItem.ANSWER_FIELD)
	private String answer;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getCatImageUrl() {
		return catImageUrl;
	}

	public void setCatImageUrl(String catImageUrl) {
		this.catImageUrl = catImageUrl;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
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

}

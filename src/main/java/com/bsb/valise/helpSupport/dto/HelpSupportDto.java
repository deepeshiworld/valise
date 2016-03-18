package com.bsb.valise.helpSupport.dto;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

public class HelpSupportDto implements Serializable {

	private static final long serialVersionUID = -7305437655994492288L;

	@Id
	@Field
	private String id;

	@Field
	private String lob;

	@Field
	private String cat;

	@Field("cat_image_url")
	private String catImageUrl;

	@Field("sub_cat")
	private String subCategory;

	@Field("question")
	private String question;

	@Field("answer_link")
	private String answer;

}

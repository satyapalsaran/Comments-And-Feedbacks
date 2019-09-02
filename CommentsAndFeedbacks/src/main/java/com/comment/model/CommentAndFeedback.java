package com.comment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "topic")
public class CommentAndFeedback {

	@Id
	private String commetId;

	private String productId;

	private String commets;
	private boolean isObjectionable;

	public boolean getIsObjectionable() {
		return isObjectionable;
	}

	public void setIsObjectionable(boolean isObjectionable) {
		this.isObjectionable = isObjectionable;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCommetId() {
		return commetId;
	}

	public void setCommetId(String commetId) {
		this.commetId = commetId;
	}

	public String getCommets() {
		return commets;
	}

	public void setCommets(String commets) {
		this.commets = commets;
	}
}

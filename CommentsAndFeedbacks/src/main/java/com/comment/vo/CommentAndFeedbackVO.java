package com.comment.vo;

public class CommentAndFeedbackVO {

	private String commetId;
	private String productId;
	private String commets;
	private boolean isObjectionable;
    public boolean isObjectionable() {
		return isObjectionable;
	}

	public void setObjectionable(boolean isObjectionable) {
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

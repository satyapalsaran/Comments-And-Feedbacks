package com.comment.utilities;

import com.comment.model.CommentAndFeedback;
import com.comment.vo.CommentAndFeedbackVO;

public class ObjectConvertorUtil {

	public static CommentAndFeedbackVO convert2TopicVO(CommentAndFeedback topic) {
		if (topic == null) {
			return null;
		}
		CommentAndFeedbackVO resource = new CommentAndFeedbackVO();
		resource.setCommetId(topic.getCommetId());
		resource.setCommets(topic.getCommets());
		resource.setProductId(topic.getProductId());
		resource.setObjectionable(topic.getIsObjectionable());
		return resource;
	}
	
	public static CommentAndFeedback convert2Topic(CommentAndFeedbackVO comment,String proudctId,boolean isObjectionable) {
		if (comment == null) {
			return null;
		}
		CommentAndFeedback resource = new CommentAndFeedback();
		resource.setCommetId(comment.getCommetId());
		resource.setCommets(comment.getCommets());
		resource.setProductId(proudctId);
		resource.setIsObjectionable(isObjectionable);
		return resource;
	}
	
	
	
	
	
	
}

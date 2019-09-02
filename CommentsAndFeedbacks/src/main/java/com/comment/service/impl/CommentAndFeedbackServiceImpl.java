package com.comment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.dao.CommentAndFeedbackDao;
import com.comment.model.CommentAndFeedback;
import com.comment.service.CommentAndFeedbackService;
import com.comment.utilities.ApplicationConfig;
import com.comment.utilities.CommentAndFeedbackException;
import com.comment.utilities.ObjectConvertorUtil;
import com.comment.utilities.Util;
import com.comment.vo.CommentAndFeedbackVO;

@Service
public class CommentAndFeedbackServiceImpl implements CommentAndFeedbackService {
	
	@Autowired
	private CommentAndFeedbackDao dao;
	
	@Autowired
	private ApplicationConfig appconfig;

	@Override
	public CommentAndFeedbackVO add(CommentAndFeedbackVO resource,String proudctId) throws CommentAndFeedbackException {
		if (resource == null || Util.isEmpty(resource.getCommets())) {
			throw new CommentAndFeedbackException("Commnet  cannot be null");
		}
		boolean isObjectionable=appconfig.isValidate(resource.getCommets());
		CommentAndFeedback topic = ObjectConvertorUtil.convert2Topic(resource,proudctId,isObjectionable);
		return ObjectConvertorUtil.convert2TopicVO(dao.save(topic));
	}

	@Override
	public CommentAndFeedbackVO update(CommentAndFeedbackVO resource,String proudctId) throws CommentAndFeedbackException {
		String id = resource.getCommetId();
		if (id == null) {
			throw new CommentAndFeedbackException("commnet id cannot be null");
		}
		Optional<CommentAndFeedback> existing = dao.findById(id);
		if(!existing.isPresent()) {
			throw new CommentAndFeedbackException("Invalid ID!");
		}
		boolean isObjectionable=appconfig.isValidate(resource.getCommets());
		CommentAndFeedback topic = ObjectConvertorUtil.convert2Topic(resource,proudctId,isObjectionable);
		return ObjectConvertorUtil.convert2TopicVO(dao.save(topic));
		
	}

	@Override
	public void delete(String id,String proudctId) throws CommentAndFeedbackException {
		dao.deleteById(id);
	}

	@Override
	public Optional<CommentAndFeedbackVO> getById(String id,String proudctId) {
		Optional<CommentAndFeedback> op = dao.findById(id);
		return op.map(topic -> ObjectConvertorUtil.convert2TopicVO(topic));
	}

	@Override
	public List<CommentAndFeedbackVO> getAll() {
		return dao.findAll().stream()
				.map(topic -> ObjectConvertorUtil.convert2TopicVO(topic))
				.collect(Collectors.toList());
	}

}

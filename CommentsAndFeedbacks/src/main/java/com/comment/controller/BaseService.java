package com.comment.controller;

import java.util.List;
import java.util.Optional;

import com.comment.utilities.CommentAndFeedbackException;

public interface BaseService<T> {

	T add(T resource,String proudctId) throws CommentAndFeedbackException;
	T update(T resource,String proudctId) throws CommentAndFeedbackException;
	void delete(String id,String proudctId) throws CommentAndFeedbackException;
	Optional<T> getById(String id,String proudctId);
	List<T> getAll();
}

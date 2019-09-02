package com.comment.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.comment.model.CommentAndFeedback;

public interface CommentAndFeedbackDao extends MongoRepository<CommentAndFeedback, String> {

}

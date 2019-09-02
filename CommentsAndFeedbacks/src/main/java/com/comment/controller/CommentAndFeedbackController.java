package com.comment.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comment.service.CommentAndFeedbackService;
import com.comment.utilities.CommentAndFeedbackException;
import com.comment.utilities.RestResponse;
import com.comment.vo.CommentAndFeedbackVO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("product")
public class CommentAndFeedbackController extends BaseController {
	
	@Autowired
	private CommentAndFeedbackService service;

	@RequestMapping(value="/{productId}/comment",method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody CommentAndFeedbackVO resource , @PathVariable("productId") String productId) {
		try {
			System.out.println("controller productId" +productId);
			CommentAndFeedbackVO topic = service.add(resource,productId);
			return ResponseEntity.ok(new RestResponse<>(topic));
		} catch (CommentAndFeedbackException e) {
			return error(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{productId}/comment/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody CommentAndFeedbackVO resource, @PathVariable("id") String id,@PathVariable("productId") String productId) {
		resource.setCommetId(id);
		try {
			CommentAndFeedbackVO topic = service.update(resource,productId);
			return ResponseEntity.ok(new RestResponse<>(topic));
		} catch (CommentAndFeedbackException e) {
			return error(e.getMessage());
		}
	}
	@RequestMapping(value = "/{productId}/comment/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> get(@PathVariable("id") String id,@PathVariable("productId") String productId) {
		Optional<CommentAndFeedbackVO> o = service.getById(id,productId);
		if (o.isPresent()) {
			return ResponseEntity.ok(new RestResponse<>(o.get()));
		}
		return error("No Record Found for ID : " + id);
	}
	@RequestMapping(value = "/{productId}/comment/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id,@PathVariable("productId") String productId) {
		Optional<CommentAndFeedbackVO> o = service.getById(id,productId);
		if(o.isPresent())
		{
			try {
				service.delete(id,productId);
			} catch (CommentAndFeedbackException e) {
				e.printStackTrace();
			}
		}
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<CommentAndFeedbackVO> topics = service.getAll();
		return ResponseEntity.ok(new RestResponse<>(topics));
	}
}

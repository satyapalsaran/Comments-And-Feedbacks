package com.comment.controller;

import org.springframework.http.ResponseEntity;

import com.comment.utilities.RestResponse;

public class BaseController {
	
	public ResponseEntity<?> error(String message) {
		return ResponseEntity.ok(new RestResponse<>(-1, message));
	}
}

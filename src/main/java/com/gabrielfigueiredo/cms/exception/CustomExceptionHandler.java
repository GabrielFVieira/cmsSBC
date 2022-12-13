package com.gabrielfigueiredo.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<JsonResponse> handleNotFoundException(NotFoundException exception) {
		JsonResponse error = new JsonResponse(exception.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ServerException.class)
	public ResponseEntity<JsonResponse> handleServerException(ServerException exception) {
		JsonResponse error = new JsonResponse(exception.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Data
	@JsonInclude(Include.NON_NULL)
	class JsonResponse {
		private String message;

		public JsonResponse(String message) {
			this.message = message;
		}
	}
}

package com.gabrielfigueiredo.cms.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gabrielfigueiredo.cms.dto.InvalidFieldDTO;

import lombok.Data;

@ControllerAdvice
public class CustomExceptionHandler {

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

	@ExceptionHandler(DomainException.class)
	public ResponseEntity<JsonResponse> handleDomainException(DomainException exception) {
		JsonResponse error = new JsonResponse(exception.getMessage());
		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(InvalidParamException.class)
	public ResponseEntity<JsonResponse> handleInvalidParamException(InvalidParamException exception) {
		JsonResponse error = new JsonResponse(exception.getMessage(), exception.getInvalidFields());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<JsonResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		List<InvalidFieldDTO> fields = exception.getBindingResult().getFieldErrors().stream()
		.map(err -> new InvalidFieldDTO(err.getField(), err.getDefaultMessage()))
		.distinct()
		.collect(Collectors.toList());

		JsonResponse error = new JsonResponse("Invalid parameter(s)", fields);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@Data
	@JsonInclude(Include.NON_EMPTY)
	class JsonResponse {
		private String message;
		private List<InvalidFieldDTO> fields;

		public JsonResponse(String message) {
			this.message = message;
		}

		public JsonResponse(String message, List<InvalidFieldDTO> fields) {
			this.message = message;
			this.fields = fields;
		}
	}
}

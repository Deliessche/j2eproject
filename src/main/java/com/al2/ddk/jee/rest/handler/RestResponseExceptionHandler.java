package com.al2.ddk.jee.rest.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.al2.ddk.jee.exception.NetflischException;

@RestControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NetflischException.class })
	protected ResponseEntity<Object> handleConflict(NetflischException e, WebRequest request) {
		
		return handleExceptionInternal(e, e.getErrorMsg(), new HttpHeaders(), HttpStatus.valueOf(e.getErrorCode()), request);
	}
}

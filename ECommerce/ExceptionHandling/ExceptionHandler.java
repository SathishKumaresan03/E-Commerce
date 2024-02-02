package com.sathish.ECommerce.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.sathish.ECommerce.Responce.ResponceStructure;

@ControllerAdvice
public class ExceptionHandler extends Exception {


	@org.springframework.web.bind.annotation.ExceptionHandler(UserdefinedException.class)
	public ResponseEntity<ResponceStructure<String>> HandlingException(UserdefinedException definedException) {
		ResponceStructure<String> responceStructure = new ResponceStructure<>();
		responceStructure.setMessage("");
		responceStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responceStructure.setData(definedException.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, null, HttpStatus.BAD_REQUEST.value());
	}
}

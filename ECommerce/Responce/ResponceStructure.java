package com.sathish.ECommerce.Responce;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ResponceStructure<T> {

	int status;
	String message;
	T data;
}

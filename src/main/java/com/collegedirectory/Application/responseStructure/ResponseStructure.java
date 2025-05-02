package com.collegedirectory.Application.responseStructure;

import lombok.Builder;

@Builder
public class ResponseStructure<T> {

	private int status;
	private String message;
	private T body;
}

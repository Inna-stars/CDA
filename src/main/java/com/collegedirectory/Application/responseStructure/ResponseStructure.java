package com.collegedirectory.Application.responseStructure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
public class ResponseStructure<T> {

	private int status;
	private String message;
	private T body;
}

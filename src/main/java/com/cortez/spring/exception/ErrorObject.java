package com.cortez.spring.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorObject {

	private final String message;
    private final String field;
    private final Object parameter;
}

package com.duytran.sample.exception.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.duytran.sample.exception.AbstractHttpStatusException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Parameters are missing or invalid")
public class BadRequestException extends AbstractHttpStatusException {
	private static final long serialVersionUID = 3936851559749221938L;
}

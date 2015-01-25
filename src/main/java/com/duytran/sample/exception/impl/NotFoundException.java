package com.duytran.sample.exception.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.duytran.sample.exception.AbstractHttpStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data not found")
public class NotFoundException extends AbstractHttpStatusException {
	private static final long serialVersionUID = -3854604267634317270L;

}

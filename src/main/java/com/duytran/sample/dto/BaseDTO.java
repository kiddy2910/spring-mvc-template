package com.duytran.sample.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {
	private static final long serialVersionUID = -7278927748337183144L;
	
	private StatusCode status;

	public BaseDTO(StatusCode status) {
		this.status = status;
	}

	public StatusCode getStatus() {
		return status;
	}
}

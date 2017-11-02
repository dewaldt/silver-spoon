package com.dewaldtvanwyk.metric.response;

/* Generic JSON Error response POJO */

public class ErrorResponse {

	String message;
	String trace;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReason() {
		return trace;
	}

	public void setReason(String trace) {
		this.trace = trace;
	}

}

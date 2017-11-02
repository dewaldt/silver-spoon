package com.dewaldtvanwyk.metric.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dewaldtvanwyk.metric.response.ErrorResponse;
import com.dewaldtvanwyk.metric.response.MetricResponse;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@ControllerAdvice
public class ControllerExceptionTranslator {

	/*
	 * A simplified exception handler. As it stands, it is revealing a bit too much,
	 * but it may be helpful during development to troubleshoot problems on the
	 * front-end
	 */

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	ErrorResponse handleException(Exception exception) {

		//standard error response to be populated
		ErrorResponse errorResponse = new ErrorResponse();
		try {
			errorResponse.setMessage(exception.getMessage());

			if (null != exception.getCause()) {
				errorResponse.setReason(exception.getCause().getMessage());
			}
		} catch (Exception e) // Error in exception handler
		{
			errorResponse.setMessage("Unknown exception");
			errorResponse.setReason("Failed to catch error on unknown exception");
		}

		return errorResponse;

	}

}
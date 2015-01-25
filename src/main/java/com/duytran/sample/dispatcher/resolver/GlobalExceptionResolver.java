package com.duytran.sample.dispatcher.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.duytran.sample.exception.impl.BadRequestException;
import com.duytran.sample.exception.impl.NotFoundException;

public class GlobalExceptionResolver implements HandlerExceptionResolver, Ordered {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex) {
		
		if (ex instanceof MissingServletRequestParameterException) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else if (ex instanceof HttpRequestMethodNotSupportedException) {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		} 
		
		else if (ex instanceof NotFoundException) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else if (ex instanceof BadRequestException) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		else {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
		return new ModelAndView(new MappingJackson2JsonView());
    }

	@Override
	public int getOrder() {
		return 0;
	}
}

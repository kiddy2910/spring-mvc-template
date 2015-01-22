package com.duytran.sample.dispatcher.resolver;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.duytran.sample.dto.StatusCode;

public class GlobalExceptionResolver implements HandlerExceptionResolver, Ordered {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        if (!(ex instanceof HttpRequestMethodNotSupportedException)) {
            // TODO log error
        }

        Map<String, StatusCode> internalServerError = new HashMap<String, StatusCode>();
        internalServerError.put("status", StatusCode.ERROR_INTERNAL_SERVER_ERROR);
        return new ModelAndView(new MappingJackson2JsonView(), internalServerError);
    }

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
}

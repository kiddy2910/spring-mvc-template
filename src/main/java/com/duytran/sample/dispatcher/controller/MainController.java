package com.duytran.sample.dispatcher.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("mainController")
public class MainController {

	@RequestMapping(value = "/")
	void index(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
	}

}

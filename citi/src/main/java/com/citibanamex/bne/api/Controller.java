package com.citibanamex.bne.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@RequestMapping(value = "/test/angel")
	public ResponseEntity<Object> test() {

		logger.info("/test/angel");

		return new ResponseEntity<>("/test/angel", HttpStatus.OK);
	}

	@RequestMapping(value = "/")
	public String prueba() {
		return "Version Sppring 2.0.3";
	}

}

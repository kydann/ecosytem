package com.citibanamex.bne.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citibanamex.bne.modelo.Usuario;
import com.citibanamex.bne.services.ApiService;

@RestController
@RequestMapping("/v1")
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private ApiService apiService;

	@RequestMapping(value = "/persona", method = RequestMethod.POST, produces = "application/json")
	public Usuario obtenerTodopersona(RequestEntity<Object> request) {// engloba el header y body json
		return apiService.porpersona(request);
	}

	@RequestMapping(value = "/todo", method = RequestMethod.POST, produces = "application/json")
	public List<Usuario> obtenerTodo() {
		return apiService.obtenerTodo();
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String guardar(@RequestBody Usuario usuario) {
		return apiService.insertar(usuario);
	}
	// checa este

	@RequestMapping(value = "/saludar")
	public String saludar() {
		return "Hola Soy un Saludo";
	}
	/*
	@RequestMapping(value = "/generic/endpoint1")
	public ResponseEntity<SqlStatementResponse> directQuery(@RequestBody SqlStatementRequest request) {
		SqlStatementResponse output = apiService.directRawQuery(request);

		logger.info("Calling direct query service");

		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	@RequestMapping(value = "/generic/endpoint2", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> directQuery() {
		Map<String, Object> output = apiService.proxyQueryToMap();

		logger.info("Calling direct query to map service");

		return new ResponseEntity<>(output, HttpStatus.OK);
	}*/
}

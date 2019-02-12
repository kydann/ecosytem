#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;
import ${package}.services.ApiService;

@RestController
@RequestMapping("/v1")
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private ApiService apiService;
	
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
	}
}

package com.citibanamex.bne.jdbcserver.controller.v1;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citibanamex.bne.jdbcserver.services.BaseDaoService;
import com.citibanamex.bne.jdbcserver.viewmodel.SqlStatementRequest;
import com.citibanamex.bne.jdbcserver.viewmodel.SqlStatementResponse;
 
@RestController
@RequestMapping("/v1")
public class Controller {

	@Autowired
	private BaseDaoService baseDaoService;

	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public SqlStatementResponse query(@RequestBody  SqlStatementRequest sqlStatementRequest) throws SQLException {
		System.out.println("SI ENTRE");
		return baseDaoService.query(sqlStatementRequest);
		 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public SqlStatementResponse update(@RequestBody  SqlStatementRequest sqlStatementRequest) throws SQLException {
		
		return baseDaoService.update(sqlStatementRequest);
		 
	}
}

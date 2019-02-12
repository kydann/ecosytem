package com.citibanamex.bne.implementation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.citibanamex.bne.connector.Connector;
import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;
import com.citibanamex.bne.jdbcclient.service.JdbcService;
import com.citibanamex.bne.modelo.Usuario;
import com.citibanamex.bne.repository.ApiRepository;
import com.citibanamex.bne.services.ApiService;
import com.citibanamex.bne.services.ProxyService;

@Service
public class ApiServiceImp implements ApiService {	
	
	@Autowired
	ApiRepository apirepo;
	
	@Override
	public SqlStatementResponse directRawQuery(SqlStatementRequest request) {
		JdbcService jdbcService = Connector.services().getJdbcService();	
		SqlStatementResponse response =  jdbcService.query(request);		
		return response;
	}
	
	@Override 
	public Map<String, Object> proxyQueryToMap(){
		SqlStatementRequest request         = new SqlStatementRequest();				
		JdbcService         jdbcService     = Connector.services().getJdbcService();
		ProxyService        proxyService    = Connector.services().getProxyService();
		
		request.setSql("select * from BBS_THIRD_PARTY_ACCNT where CONTRACT_NUMBER=? and PRODUCT_CODE=? and  INSTRUMENT_CODE=?");		
		request.setParams(new Object[] {"2791858", "0001", "01"});
		
		return proxyService.queryToMap((jdbcService.query(request).getResultSet()));
	}
	
	@Override
	public Usuario porpersona(RequestEntity<Object> request) {
		return apirepo.findById(request);
	}
	
	public String insertar(Usuario usuario) {
		return apirepo.guardar(usuario);
	}

	@Override
	public List<Usuario> obtenerTodo() {
		return apirepo.obtenerTodo();
	}
}

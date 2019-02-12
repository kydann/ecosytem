#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.implementation;

import java.util.Map;

import org.springframework.stereotype.Service;

import ${package}.connector.Connector;
import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;
import com.citibanamex.bne.jdbcclient.service.JdbcService;
import ${package}.services.ApiService;
import ${package}.services.ProxyService;

@Service
public class ApiServiceImp implements ApiService {	
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
}

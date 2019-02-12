#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services;

import java.util.Map;

import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;

public interface ApiService {
	public SqlStatementResponse directRawQuery(SqlStatementRequest request);
	public Map<String, Object> proxyQueryToMap();
}

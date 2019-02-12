#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services;

import java.util.List;
import java.util.Map;

public interface ProxyService {		
	public Map<String, Object> queryToMap(List<Object[]> params);
 }

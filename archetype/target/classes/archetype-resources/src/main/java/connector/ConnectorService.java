#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.connector;

import com.citibanamex.bne.jdbcclient.service.JdbcService;
import ${package}.services.ProxyService;
import com.citibanamex.bne.tuxedoclient.service.TuxedoService;

public interface ConnectorService { 
	public JdbcService getJdbcService();
	public TuxedoService getTuxedoService();
	public ProxyService getProxyService();
}

package com.citibanamex.bne.connector;

import com.citibanamex.bne.jdbcclient.service.JdbcService;
import com.citibanamex.bne.services.ProxyService;
import com.citibanamex.bne.tuxedoclient.service.TuxedoService;

public interface ConnectorService { 
	public JdbcService getJdbcService();
	public TuxedoService getTuxedoService();
	public ProxyService getProxyService();
}

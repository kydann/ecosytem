package com.citibanamex.bne.connector;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.citibanamex.bne.jdbcclient.service.JdbcService;
import com.citibanamex.bne.services.ProxyService;
import com.citibanamex.bne.tuxedoclient.service.TuxedoService;

@Component
public class Connector implements ConnectorService, ApplicationContextAware {
	private static ApplicationContext applicationContext;
	
	@Autowired
	private JdbcService jdbcService;
	
	@Autowired
	private TuxedoService tuxedoService;
	
	@Autowired
	private ProxyService proxyService;

	@Override
	public JdbcService getJdbcService() {
		return jdbcService;
	}
	
	@Override
	public TuxedoService getTuxedoService() {
		return tuxedoService;
	}

	@Override
	public ProxyService getProxyService() {
		return proxyService;
	}
		
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {		
		Connector.applicationContext = applicationContext;
	}
	
	/**
     * A static method to lookup the SpringContextBridgedServices Bean in 
     * the applicationContext. It is basically an instance of itself, which 
     * was registered by the @Component annotation.
     *
     * @return the SpringContextBridgedServices, which exposes all the 
     * Spring services that are bridged from the Spring context.
     */
    public static ConnectorService services() {
        return applicationContext.getBean(ConnectorService.class);
    }
}

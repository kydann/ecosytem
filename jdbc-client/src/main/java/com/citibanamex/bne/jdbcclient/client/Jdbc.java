	package com.citibanamex.bne.jdbcclient.client;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citibanamex.bne.jdbcclient.component.JdbcFallbackFactory;
import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;

@RefreshScope
@FeignClient(name = "${jdbc.name}", url = "${jdbc.url:}", fallbackFactory = JdbcFallbackFactory.class)
public interface Jdbc {
	 @RequestMapping(value = "${jdbc.uri.read}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	 public SqlStatementResponse query(SqlStatementRequest sqlStatementRequest);
	 
	 @RequestMapping(value = "${jdbc.uri.write}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	 public SqlStatementResponse update(SqlStatementRequest sqlStatementRequest);	
}

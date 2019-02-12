package com.citibanamex.bne.jdbcclient.component;

import org.springframework.stereotype.Component;

import com.citibanamex.bne.jdbcclient.client.Jdbc;
import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;

@Component
public class JdbcFallback implements Jdbc {
	@Override
	public SqlStatementResponse query(SqlStatementRequest sqlStatementRequest) {	
		return null;
	}

	@Override
	public SqlStatementResponse update(SqlStatementRequest sqlStatementRequest) {
		return null;
	}
}

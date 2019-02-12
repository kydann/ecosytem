package com.citibanamex.bne.jdbcclient.service;

import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;

public interface JdbcService {
	public  SqlStatementResponse query(SqlStatementRequest sqlStatementRequest);
	public SqlStatementResponse update(SqlStatementRequest sqlStatementRequest);
}

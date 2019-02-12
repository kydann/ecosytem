package com.citibanamex.bne.jdbcserver.dao;

import java.sql.SQLException;

import com.citibanamex.bne.jdbcserver.viewmodel.SqlStatementResponse;


public interface DataBaseDao {
	public SqlStatementResponse update(String sql, Object[] params) throws SQLException ;
	public SqlStatementResponse query(String sql, Object[] params) throws SQLException;
	
}

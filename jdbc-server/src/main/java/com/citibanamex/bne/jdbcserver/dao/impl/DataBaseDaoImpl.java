package com.citibanamex.bne.jdbcserver.dao.impl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.citibanamex.bne.jdbcserver.dao.DataBaseDao;
import com.citibanamex.bne.jdbcserver.viewmodel.SqlStatementResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Repository
public class DataBaseDaoImpl implements DataBaseDao {
	
	private static final Logger logger = LoggerFactory.getLogger(DataBaseDaoImpl.class);
	
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	@HystrixCommand(fallbackMethod = "queryFail")
	public SqlStatementResponse query(String sql, Object[] params) throws SQLException {
		QueryRunner runner = new QueryRunner(dataSource);
		long t0 = System.currentTimeMillis();
		SqlStatementResponse result = new SqlStatementResponse();
		result.setResultSet(runner.query(sql, new ArrayListHandler(), params)); 
		logger.info("Time elapsed DataBaseDaoImpl.queryDatabase", (System.currentTimeMillis() - t0) + " ms");
		runner = null;
		return result;
	}

	public SqlStatementResponse queryFail(String sql, Object[] params , Throwable e) throws SQLException {
		logger.error("queryFail", e);
		throw  new SQLException();
	}
	
	
	@Override
	@HystrixCommand(fallbackMethod = "updateFail")
	public SqlStatementResponse update(String sql, Object[] params) throws SQLException {
		QueryRunner runner = new QueryRunner(dataSource);
		long t0 = System.currentTimeMillis();
		SqlStatementResponse result = new SqlStatementResponse();
		result.setRowsAfect(runner.update(sql, params));
		logger.info("Time elapsed DataBaseDaoImpl.update", (System.currentTimeMillis() - t0) + " ms");
		runner = null;
		return result;
	}
	
	public SqlStatementResponse updateFail(String sql, Object[] params , Throwable e) throws SQLException {
		logger.error("updateFail", e);
		throw  new SQLException();
	}
	

}

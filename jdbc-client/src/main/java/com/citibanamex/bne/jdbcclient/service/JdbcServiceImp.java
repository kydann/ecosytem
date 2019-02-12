package com.citibanamex.bne.jdbcclient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citibanamex.bne.jdbcclient.client.Jdbc;
import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;

@Service
public class JdbcServiceImp implements JdbcService {
private static final Logger logger = LoggerFactory.getLogger(Jdbc.class);	
	@Autowired
	private Jdbc dataBaseDao;

	@Override
    public  SqlStatementResponse query( SqlStatementRequest sqlStatementRequest ) {
    	long t0 = System.currentTimeMillis();
    	SqlStatementResponse r = dataBaseDao.query(sqlStatementRequest);    	
    	logger.info("Time elapsed BaseDaoService.query: " + (System.currentTimeMillis() - t0) + " ms");
    	return r;
    };
 
    @Override
    public SqlStatementResponse update(SqlStatementRequest sqlStatementRequest ) {
    	long t0 = System.currentTimeMillis();
    	SqlStatementResponse r = dataBaseDao.update(sqlStatementRequest); 
    	logger.info("Time elapsed BaseDaoService.query: " + (System.currentTimeMillis() - t0) + " ms");
    	return r;
    }
}

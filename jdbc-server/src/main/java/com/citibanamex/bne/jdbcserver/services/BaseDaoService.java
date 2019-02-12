package com.citibanamex.bne.jdbcserver.services;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citibanamex.bne.jdbcserver.dao.DataBaseDao;
import com.citibanamex.bne.jdbcserver.viewmodel.SqlStatementRequest;
import com.citibanamex.bne.jdbcserver.viewmodel.SqlStatementResponse;
 
@Service
public class BaseDaoService {
	private static final Logger logger = LoggerFactory.getLogger(BaseDaoService.class);
	
	@Autowired
	private DataBaseDao dataBaseDao;

    public  SqlStatementResponse query( SqlStatementRequest sqlStatementRequest ) throws SQLException  {
     
    	return dataBaseDao.query(sqlStatementRequest.getSql(), sqlStatementRequest.getParams()); 
    	 
    };
 
     
    public SqlStatementResponse update(SqlStatementRequest sqlStatementRequest ) throws SQLException   {
    	return  dataBaseDao.update(sqlStatementRequest.getSql(), sqlStatementRequest.getParams()); 
    }
    
}

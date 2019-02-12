package com.citibanamex.bne.jdbcclient.component;

import org.springframework.stereotype.Component;

import com.citibanamex.bne.jdbcclient.client.Jdbc;
import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;

import feign.hystrix.FallbackFactory;

@Component
public class JdbcFallbackFactory implements FallbackFactory<Jdbc> {
	@Override 
	public Jdbc create(Throwable cause) {
		return new Jdbc(){
            @Override
            public SqlStatementResponse query(SqlStatementRequest sqlStatementRequest) {
                System.out.println("Fallback cause: " + cause.getMessage());
                
                return null;
            }
            
            @Override
            public SqlStatementResponse update(SqlStatementRequest sqlStatementRequest) {
                System.out.println("Fallback cause: " + cause.getMessage());
                
                return null;
            }
        };
	}
}

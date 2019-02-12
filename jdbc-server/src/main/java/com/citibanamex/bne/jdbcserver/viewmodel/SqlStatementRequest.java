package com.citibanamex.bne.jdbcserver.viewmodel;


import org.hibernate.validator.constraints.NotEmpty;

 
public class SqlStatementRequest {

	@NotEmpty(message = "SQL may not be empty or null")
	private String sql;

	private Object[] params;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

}

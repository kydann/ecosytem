package com.citibanamex.bne.jdbcclient.model;

import java.util.List;

public class SqlStatementResponse {
	private List<Object[]> resultSet;
    private int rowsAfect; 

    public int getRowsAfect() {
		return rowsAfect;
	}

	public void setRowsAfect(int rowsAfect) {
		this.rowsAfect = rowsAfect;
	}

   
    public List<Object[]> getResultSet() {
        return resultSet;
    }

    public void setResultSet(List<Object[]> resultSet) {
        this.resultSet = resultSet;
    }
}
